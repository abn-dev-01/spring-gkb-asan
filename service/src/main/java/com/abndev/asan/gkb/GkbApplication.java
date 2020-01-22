package com.abndev.asan.gkb;

import com.abndev.asan.gkb.soap.GetPersonClient;
import com.abndev.asan.gkb.soap.SOAPConnector;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.ObjectToStringHttpMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.util.Objects;

@SpringBootApplication
public class GkbApplication {

    public static final String SOAP_SERVICE_URL = "soap.service.url";
    public static final String SOAP_SCHEMA_PACKAGE = "com.abndev.asan.gkb.person.schema";

    @Autowired
    private GetPersonClient client;

    public static void main(String[] args) {
        SpringApplication.run(GkbApplication.class, args);
    }


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
    public SOAPConnector soapConnector(
            Jaxb2Marshaller marshaller,
            @Value("${" + SOAP_SERVICE_URL + "}") String soapUrl
    ) {

        if (StringUtils.isEmpty(soapUrl)) {
            throw new RuntimeException("You have to add properties `" + SOAP_SERVICE_URL + "` into application.properties.");
        }
        SOAPConnector client = new SOAPConnector();
        client.setDefaultUri(soapUrl);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

    @Bean
    public WebServiceTemplate webServiceTemplate(@Value("${" + SOAP_SERVICE_URL + "}") String soapUrl) {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(marshaller());
        webServiceTemplate.setUnmarshaller(marshaller());
        webServiceTemplate.setDefaultUri(soapUrl);

        return webServiceTemplate;
    }

    @Bean
    CommandLineRunner lookup(SOAPConnector soapConnector) {
        return args -> {
            String name = "Sajal";//Default Name
            if (args.length > 0) {
                name = args[0];
            }
//            StudentDetailsRequest request = new StudentDetailsRequest();
//            request.setName(name);
//            StudentDetailsResponse response = (StudentDetailsResponse) soapConnector.callWebService(
//                    "http://localhost:8080/service/student-details",
//                    request);

            Object result = client.getPerson();

            System.out.println("Got Response As below ========= : ");
            System.out.println("Result : " + result);
        };
    }

}
