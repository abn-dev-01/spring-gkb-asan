package com.abndev.asan.gkb.dom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ReturnObject {

    @XmlElement(name = "Person", namespace = "http://gbd.chdb.scb.kz/xml/person")
    private PersonObject personObject;

    public ReturnObject() {
    }

    public PersonObject getPersonObject() {
        return personObject;
    }

    public void setPersonObject(PersonObject personObject) {
        this.personObject = personObject;
    }
}
