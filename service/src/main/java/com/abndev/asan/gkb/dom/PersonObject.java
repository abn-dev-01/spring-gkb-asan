package com.abndev.asan.gkb.dom;

import com.abndev.asan.gkb.person.schema.ResponseData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class PersonObject {
    @XmlElement(name = "responseInfo")
    private ResponseInfo responseInfo;

    @XmlElement(name = "responseData")
    private ResponseDataObject responseData;

    public PersonObject() {
    }

    public ResponseInfo getResponseInfo() {
        return responseInfo;
    }

    public void setResponseInfo(ResponseInfo responseInfo) {
        this.responseInfo = responseInfo;
    }

    public ResponseDataObject getResponseData() {
        return responseData;
    }

    public void setResponseData(ResponseDataObject responseData) {
        this.responseData = responseData;
    }
}
