package com.abndev.asan.gkb;

import com.abndev.asan.gkb.soap.SOAPConnector;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class Config {

    public static final String SOAP_SERVICE_URL = "soap.service.url";
    public static final String SOAP_SCHEMA_PACKAGE = "com.abndev.asan.gkb.person.schema";

    /**
     * WebServiceGatewaySupport requires Marshaller and Unmarshaller, which are instances of Jaxb2Marshaller class.
     * It uses {@link #SOAP_SCHEMA_PACKAGE} as base package of the JAXB classes.
     * It will use this package to create the JAXB context.
     * We will use this Jaxb2Marshaller bean as Marshaller/Unmarshaller of SOAPConnector bean.
     *
     * @return
     */
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this is the package name specified in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath(SOAP_SCHEMA_PACKAGE);
        return marshaller;
    }

    @Bean
    public SOAPConnector soapConnector(Jaxb2Marshaller marshaller, @Value(value = SOAP_SERVICE_URL) String soapUrl) {

        if (StringUtils.isEmpty(soapUrl)) {
            throw new RuntimeException("You have to add properties `" + SOAP_SERVICE_URL + "` into application.properties.");
        }
        SOAPConnector client = new SOAPConnector();
        client.setDefaultUri(soapUrl);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
