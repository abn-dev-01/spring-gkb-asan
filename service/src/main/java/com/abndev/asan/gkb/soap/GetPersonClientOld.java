package com.abndev.asan.gkb.soap;

import com.abndev.asan.gkb.person.schema.GetPerson;
import com.abndev.asan.gkb.person.schema.GetPersonResponse;
import com.abndev.asan.gkb.person.schema.ObjectFactory;
import com.abndev.asan.gkb.utils.HttpConnector;
import com.abndev.asan.gkb.utils.SSLTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.WebServiceIOException;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapMessage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.TransformerException;
import java.io.IOException;

@Component
public class GetPersonClientOld {
    private static final Logger LOG = LoggerFactory.getLogger(GetPersonClientOld.class);
    public static final String SOAP_USER_ID = "781fceae-563c-4c19-a6c7-4fd0217f0be2";
    @Autowired
    private WebServiceTemplate webServiceTemplate;
    @Value("${soap.client.user.name}")
    private String userName;
    @Value("${soap.client.user.password}")
    private String userPassword;
    @Value("${soap.client.proxy.enable}")
    private Boolean proxyEnable;

    public Object getPerson() {
        ObjectFactory factory = new ObjectFactory();
        GetPerson person = new GetPerson();
        person.setIin("440902700044");
        person.setConsentConfirmed(true);

        JAXBElement<GetPerson> getPersonRequest = factory.createGetPerson(person);

        SSLTool.disableCertificateValidation();

        // set a HttpComponentsMessageSender which provides support for basic authentication
        HttpConnector httpConnector = new HttpConnector(userName, userPassword, proxyEnable);
        webServiceTemplate.setMessageSender(httpConnector.httpComponentsMessageSender());

        WebServiceMessageCallback webServiceMessageCallback = new WebServiceMessageCallback() {
            @Override
            public void doWithMessage(WebServiceMessage message)
                    throws IOException, TransformerException {
                try {
                    // get the header from the SOAP message
                    SoapHeader soapHeader = ((SoapMessage) message).getSoapHeader();

                    // create the header element
                    ObjectFactory factory = new ObjectFactory();
//                                    UserIdSoapHeaders userIdSoapHeader = factory.createUserIdSoapHeaders();
//                                    userIdSoapHeader.setUserId("781fceae-563c-4c19-a6c7-4fd0217f0be2");
//                                    JAXBElement<UserIdSoapHeaders> headers = factory.createUserId(userIdSoapHeader);
//                                    JAXBElement<String> userId = factory.createUserId(SOAP_USER_ID);
                    JAXBElement<String> userId =
                            new JAXBElement<>(new QName("userId"), String.class, SOAP_USER_ID);

                    // create a marshaller
                    JAXBContext context = JAXBContext.newInstance(String.class);
                    Marshaller marshaller = context.createMarshaller();

//                                    soapHeader.addHeaderElement(new QName("iserId").)
//                                    soapHeader.addAttribute(new QName("userId"), SOAP_USER_ID);

                    // marshal the headers into the specified result
                    marshaller.marshal(userId, soapHeader.getResult());

                }
                catch (Exception exc) {
                    LOG.error("error during marshalling of the SOAP headers", exc);
                    if (exc instanceof WebServiceIOException) {
                        throw new WSTimeoutException(exc);
                    }
                }
            }
        };
        
        JAXBElement<GetPersonResponse> response = null;
        int counter = 0;
        boolean timeToExit = false;
        while (counter < 3 && !timeToExit) {
            try {
                response = (JAXBElement<GetPersonResponse>) webServiceTemplate
                        .marshalSendAndReceive(getPersonRequest, webServiceMessageCallback);
                timeToExit = true;
            }
            catch (Exception exc) {
                LOG.error("Loading SOAP failed.", exc);
                if (exc instanceof WSTimeoutException) {
                    counter++;
                }
            }
        }

        return response.getValue().getReturn();
    }
}
