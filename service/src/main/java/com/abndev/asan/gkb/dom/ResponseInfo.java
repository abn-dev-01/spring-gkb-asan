package com.abndev.asan.gkb.dom;

import com.abndev.asan.gkb.dom.dict.ResponseStatus;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "response_info")
public class ResponseInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer gid;

    @Column(name = "message_id")
    @XmlElement(name = "messageId")
    private String messageId;

    @Column(name = "correlation_id")
    @XmlElement(name = "correlationId")
    private String correlationId;

    @Column(name = "response_date")
    @XmlElement(name = "responseDate")
    private String responseDate;

    @XmlElement(name = "responseStatus")
//    @Column(name = "responseStatus")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "response_status_id")   // field, created in this table
    private ResponseStatus responseStatus;

    @Column(name = "session_id")
    @XmlElement(name = "sessionId")
    private String sessionId;

    public ResponseInfo() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ResponseInfo{");
        sb.append("messageId='").append(messageId).append('\'');
        sb.append(", correlationId='").append(correlationId).append('\'');
        sb.append(", responseDate='").append(responseDate).append('\'');
        sb.append(", responseStatus=").append(responseStatus);
        sb.append(", sessionId='").append(sessionId).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(String responseDate) {
        this.responseDate = responseDate;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
