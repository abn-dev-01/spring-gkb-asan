package com.abndev.asan.gkb.dom.dict;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "status")
public class Status {

    @Id
    @Column(unique = true, length = 16, name = "code")
    @XmlElement(name = "code")
    private String code;

    @Column(name = "message", length = 255)
    @XmlElement(name = "message")
    private String message;

    public Status() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
