//package com.abndev.asan.gkb.soap;
////
////import com.sun.xml.internal.ws.runtime.config.ObjectFactory;
////import org.springframework.ws.WebServiceMessage;
////import org.springframework.ws.client.core.WebServiceMessageCallback;
////import org.springframework.ws.soap.SoapHeader;
////import org.springframework.ws.soap.SoapMessage;
////
////import javax.xml.bind.JAXBContext;
////import javax.xml.bind.JAXBElement;
////import javax.xml.bind.Marshaller;
////
////public class SOAPHeaderCallback
////        implements WebServiceMessageCallback {
////
////    @Override
////    public void doWithMessage(WebServiceMessage message) {
////        try {
////            SoapHeader soapHeader = ((SoapMessage) message).getSoapHeader();
////            ObjectFactory factory = new ObjectFactory();
////            AuthSoapHeaders authSoapHeaders = factory.createAuthSoapHeaders();
////            authSoapHeaders.setUsername("testuser");
////            authSoapHeaders.setPassword("testpass");
////            JAXBElement headers =
////                    factory.createAuthSoapHeaders(AuthSoapHeaders);
////            JAXBContext context = JAXBContext.newInstance(AuthSoapHeaders.class);
////            Marshaller marshaller = context.createMarshaller();
////            marshaller.marshal(authSoapHeaders, soapHeader.getResult());
////        }
////        catch (Exception e) {
////            logger.error("error during marshalling of the SOAP headers", e);
////        }
////    }
////});
////
////        }
////
////        }