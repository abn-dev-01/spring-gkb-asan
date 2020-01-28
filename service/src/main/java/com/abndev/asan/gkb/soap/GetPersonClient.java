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
import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.ws.support.MarshallingUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMResult;
import java.io.IOException;

@Component
public class GetPersonClient {
    private static final Logger LOG = LoggerFactory.getLogger(GetPersonClient.class);
    public static final String SOAP_USER_ID = "781fceae-563c-4c19-a6c7-4fd0217f0be2";
    @Autowired
    private WebServiceTemplate webServiceTemplate;
    @Value("${soap.client.user.name}")
    private String userName;
    @Value("${soap.client.user.password}")
    private String userPassword;
    @Value("${soap.client.proxy.enable}")
    private Boolean proxyEnable;

    public DOMResult getPerson() {

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
                    JAXBElement<String> userId =
                            new JAXBElement<>(new QName("userId"), String.class, SOAP_USER_ID);

                    // create a marshaller
                    JAXBContext context = JAXBContext.newInstance(String.class);
                    Marshaller marshaller = context.createMarshaller();

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
        DOMResult responseResult = new DOMResult();

        while (counter < 3 && !timeToExit) {
            try {

//                response = (JAXBElement<GetPersonResponse>) webServiceTemplate
//                        .marshalSendAndReceive(getPersonRequest, webServiceMessageCallback);

//                DOMResult responseResult = getDomResult(getPersonRequest);

                // 3
                WebServiceMessage request = webServiceTemplate.getMessageFactory().createWebServiceMessage();
                MarshallingUtils.marshal(webServiceTemplate.getMarshaller(), getPersonRequest, request);

                webServiceTemplate.sendSourceAndReceiveToResult(request.getPayloadSource(),
                                                                webServiceMessageCallback,
                                                                responseResult);

                timeToExit = true;
            }
            catch (Exception exc) {
                LOG.error("Loading SOAP failed.", exc);
                if (exc instanceof WSTimeoutException) {
                    counter++;
                }
            }
        }

        return responseResult;
    }

    private DOMResult getDomResult(JAXBElement<GetPerson> getPersonRequest)
            throws IOException, JAXBException {

        WebServiceMessage request = webServiceTemplate.getMessageFactory().createWebServiceMessage();

        // add userId into Header
        SoapHeader soapHeader = ((SoapMessage) request).getSoapHeader();
        JAXBElement<String> userId =
                new JAXBElement<>(new QName("userId"), String.class, SOAP_USER_ID);

        // create a marshaller
        JAXBContext context = JAXBContext.newInstance(String.class);
        Marshaller marshaller = context.createMarshaller();

//        marshaller.marshal(userId, soapHeader.getResult());
//        MarshallingUtils.marshal(webServiceTemplate.getMarshaller(), userId, request);

//        ObjectFactory factory = new ObjectFactory();
//        JAXBElement<String> userId = factory.createUserId(SOAP_USER_ID);
//        header.addAttribute(new QName("userId"), SOAP_USER_ID);
//        MarshallingUtils.marshal(webServiceTemplate.getMarshaller(), userId, request);

        MarshallingUtils.marshal(webServiceTemplate.getMarshaller(), getPersonRequest, request);
//        marshaller.marshal(getPersonRequest, ((SoapMessage) request).getSoapBody().getPayloadResult());

        // marshal the headers into the specified result
        SoapHeaderElement userIdEl =
                soapHeader.addHeaderElement(new QName("http://schemas.xmlsoap.org/soap/envelope/", "userId"));
        userIdEl.setText(SOAP_USER_ID);

        // call the service
        DOMResult result = new DOMResult(); ;
        webServiceTemplate.sendSourceAndReceiveToResult(request.getPayloadSource(), result);

        return result;
    }
}
