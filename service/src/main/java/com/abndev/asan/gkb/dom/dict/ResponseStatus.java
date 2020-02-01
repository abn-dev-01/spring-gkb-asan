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
@Table(name = "response_status")
public class ResponseStatus {

    @Id
    @Column(unique = true, length = 16, name = "code")
    @XmlElement(name = "code")
    private String code;

    @Column(name = "message", length = 255)
    @XmlElement(name = "message")
    private String message;

    public ResponseStatus() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ResponseStatus{");
        sb.append("code='").append(code).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
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
