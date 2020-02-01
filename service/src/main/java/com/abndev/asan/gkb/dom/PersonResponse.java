package com.abndev.asan.gkb.dom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "getPersonResponse", namespace = "http://data.gbd.chdb.scb.kz/")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonResponse {
    @XmlElement(name = "return")
    private ReturnObject returnObject;

    public PersonResponse() {
    }

    public ReturnObject getReturnObject() {
        return returnObject;
    }

    public void setReturnObject(ReturnObject returnObject) {
        this.returnObject = returnObject;
    }
}
