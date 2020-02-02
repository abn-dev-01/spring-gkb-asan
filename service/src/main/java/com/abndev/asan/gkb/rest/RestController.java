package com.abndev.asan.gkb.rest;

import com.abndev.asan.gkb.Constants;
import com.abndev.asan.gkb.dom.PersonResponse;
import com.abndev.asan.gkb.soap.GetPersonClient;
import com.abndev.asan.gkb.soap.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBResult;
import javax.xml.soap.SOAPException;
import javax.xml.transform.Result;

import static com.abndev.asan.gkb.Constants.MESSAGE_URL;
import static com.abndev.asan.gkb.Constants.REST_ENDPOINT;
import static com.abndev.asan.gkb.Constants.SLASH;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(REST_ENDPOINT)
public class RestController {

    private static final Logger LOG = LoggerFactory.getLogger(RestController.class);

    @Autowired
    private GetPersonClient client;
    @Autowired
    private PersonService personService;

    @PostMapping(SLASH + MESSAGE_URL)
    public Object soapMessage(@RequestBody(required = true) MessageRequest request) {
        try {
            Result result = client.getPerson(request);

            PersonResponse personResponse = (PersonResponse) ((JAXBResult) result).getResult();
            personService.store(personResponse);
        }
        catch (SOAPException exc) {
            LOG.error("SOAP failed.", exc);
            throw new RuntimeException(exc);
        }
        catch (JAXBException exc) {
            LOG.error("JAXB failed.", exc);
            throw new RuntimeException(exc);
        }

        return new Response("OK", false);
    }
}
