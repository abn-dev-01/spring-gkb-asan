package com.abndev.asan.gkb.dom;

import com.abndev.asan.gkb.person.schema.PersonDetailsResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Body {

    @XmlElement(name = "getPersonResponse", namespace = "http://data.gbd.chdb.scb.kz/")
//    @XmlElement(name = "getPersonResponse", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    private PersonResponse personResponse;

    public Body() {
    }

    public PersonResponse getPersonResponse() {
        return personResponse;
    }

    public void setPersonResponse(PersonResponse personResponse) {
        this.personResponse = personResponse;
    }
}
