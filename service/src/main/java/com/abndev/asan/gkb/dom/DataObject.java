package com.abndev.asan.gkb.dom;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "data")
public class DataObject {
//    @GeneratedValue(strategy = GenerationType.TABLE)
//    private Integer gid;

    @Id
    @Column(name = "message_id", length = 48)
    @XmlElement(name = "messageId")
    private String messageId;

    @Column(name = "message_date", length = 48)
    @XmlElement(name = "messageDate")
    private String messageDate;

    @Column(name = "request_id", length = 48)
    @XmlElement(name = "requestId")
    private String requestId;

    //    @Column(name = "sender")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "sender_id")   // field, created in this table
    @XmlElement(name = "sender")
    private SenderOrm sender;

    //    @Column(name = "receiver")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "receiver_id")   // field, created in this table
    @XmlElement(name = "receiver")
    private ReceiverOrm receiverOrm;

    //    @Column(name = "message_result")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "message_result_id")   // field, created in this table
    @XmlElement(name = "messageResult")
    private MessageResult messageResult;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "persons_id")   // field, created in this table
//    @Transient
    @XmlElement(name = "persons")
    private Persons persons;

    public DataObject() {
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(String messageDate) {
        this.messageDate = messageDate;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public SenderOrm getSender() {
        return sender;
    }

    public void setSender(SenderOrm sender) {
        this.sender = sender;
    }

    public ReceiverOrm getReceiverOrm() {
        return receiverOrm;
    }

    public void setReceiverOrm(ReceiverOrm receiverOrm) {
        this.receiverOrm = receiverOrm;
    }

    public MessageResult getMessageResult() {
        return messageResult;
    }

    public void setMessageResult(MessageResult messageResult) {
        this.messageResult = messageResult;
    }

    public Persons getPersons() {
        return persons;
    }

    public void setPersons(Persons persons) {
        this.persons = persons;
    }
}
