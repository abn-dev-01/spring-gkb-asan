package com.abndev.asan.gkb.soap;

import com.abndev.asan.gkb.person.schema.GetPerson;
import com.abndev.asan.gkb.person.schema.GetPersonResponse;
import com.abndev.asan.gkb.person.schema.ObjectFactory;
import com.abndev.asan.gkb.person.schema.UserIdSoapHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapMessage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.transform.TransformerException;
import java.io.IOException;

@Component
public class GetPersonClient {
    private static final Logger LOG = LoggerFactory.getLogger(GetPersonClient.class);
    @Autowired
    private WebServiceTemplate webServiceTemplate;

    public Object getPerson() {
        ObjectFactory factory = new ObjectFactory();
        GetPerson person = new GetPerson();
        person.setIin("440902700044");
        person.setConsentConfirmed(true);

        JAXBElement<GetPerson> getPersonRequest = factory.createGetPerson(person);

        JAXBElement<GetPersonResponse> response =
                (JAXBElement<GetPersonResponse>) webServiceTemplate
                        .marshalSendAndReceive(getPersonRequest, new WebServiceMessageCallback() {
                            @Override
                            public void doWithMessage(WebServiceMessage message)
                                    throws IOException, TransformerException {
                                try {
                                    // get the header from the SOAP message
                                    SoapHeader soapHeader = ((SoapMessage) message).getSoapHeader();

                                    // create the header element
                                    ObjectFactory factory = new ObjectFactory();
                                    UserIdSoapHeaders userIdSoapHeader = factory.createUserIdSoapHeaders();
                                    userIdSoapHeader.setUserId("781fceae-563c-4c19-a6c7-4fd0217f0be2");

                                    JAXBElement<UserIdSoapHeaders> headers = factory.createUserId(userIdSoapHeader);

                                    // create a marshaller
                                    JAXBContext context = JAXBContext.newInstance(UserIdSoapHeaders.class);
                                    Marshaller marshaller = context.createMarshaller();

                                    // marshal the headers into the specified result
                                    marshaller.marshal(headers, soapHeader.getResult());

                                }
                                catch (Exception e) {
                                    LOG.error("error during marshalling of the SOAP headers", e);
                                }
                            }
                        });

        return response.getValue().getReturn();
    }
}
