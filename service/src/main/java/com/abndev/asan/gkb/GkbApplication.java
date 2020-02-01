package com.abndev.asan.gkb;

import com.abndev.asan.gkb.dom.PersonResponse;
import com.abndev.asan.gkb.person.schema.Person;
import com.abndev.asan.gkb.soap.GetPersonClient;
import com.abndev.asan.gkb.soap.PersonService;
import com.abndev.asan.gkb.soap.SOAPConnector;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ws.client.core.WebServiceTemplate;

import javax.xml.bind.util.JAXBResult;
import javax.xml.transform.Result;

@SpringBootApplication
@EnableTransactionManagement
public class GkbApplication {

    public static final String SOAP_SERVICE_URL = "soap.service.url";
    public static final String SOAP_SCHEMA_PACKAGE = "com.abndev.asan.gkb.person.schema";
    private static final Logger LOG = LoggerFactory.getLogger(GkbApplication.class);
    //    public static final String PROXY_HOST = "37.228.68.27";
//    public static final String PROXY_HOST = "92.46.58.110"; // 48144
//    public static final String PROXY_HOST = "185.48.149.6"; // 8080

    @Autowired
    private GetPersonClient client;
    @Autowired
    private PersonService personService;

    //    @Value("${soap.client.user.name}")
    private String userName;

    //    @Value("${soap.client.user.password}")
    private String userPassword;

    private boolean proxyEnable;

    public static void main(String[] args) {
        SpringApplication.run(GkbApplication.class, args);
    }

    public GkbApplication(
            @Value("${soap.client.user.name}") String userName,
            @Value("${soap.client.user.password}") String userPassword,
            @Value("${soap.client.proxy.enable}") Boolean proxyEnable
    ) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.proxyEnable = proxyEnable;
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
        // this is the package name specified in the <generatePackage> specified in pom.xml
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
        // set a HttpComponentsMessageSender which provides support for basic authentication
//        webServiceTemplate.setMessageSender(httpComponentsMessageSender());

        return webServiceTemplate;
    }

//    @Bean
//    public WebServiceMessageSender myMsgSender() {
//        HttpComponentsMessageSender msgSender = new HttpComponentsMessageSender() {
//            @Override
//            protected HttpContext createContext(URI uri) {
//                HttpHost target = new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme());
//
//                // Create AuthCache instance
//                AuthCache authCache = new BasicAuthCache();
//                // Generate BASIC scheme object and add it to the local
//                // auth cache
//                BasicScheme basicAuth = new BasicScheme();
//                authCache.put(target, basicAuth);
//
//                // Add AuthCache to the execution context
//                HttpClientContext localContext = HttpClientContext.create();
//                localContext.setAuthCache(authCache);
//
//                return localContext;
//            }
//        };
//
//        return msgSender;
//    }

    @Bean
    CommandLineRunner lookup(SOAPConnector soapConnector) {
        return args -> {
            String name = "Sajal";//Default Name
            if (args.length > 0) {
                name = args[0];
            }
            Result result = client.getPerson();

            PersonResponse personResponse = (PersonResponse) ((JAXBResult) result).getResult();
            personService.store(personResponse);


            System.out.println("Got Response As below ========= : ");
            System.out.println("Result : " + result);
        };
    }

}
