package com.abndev.asan.gkb.dom;

import com.abndev.asan.gkb.dom.dict.MessageResultDict;
import com.abndev.asan.gkb.dom.dict.ReceiverDict;
import com.abndev.asan.gkb.dom.dict.SenderDict;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

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
    private SenderDict sender;

    //    @Column(name = "receiver")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "receiver_id")   // field, created in this table
    @XmlElement(name = "receiver")
    private ReceiverDict receiverDict;

    //    @Column(name = "message_result")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "message_result_id")   // field, created in this table
    @XmlElement(name = "messageResultDict")
    private MessageResultDict messageResultDict;

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

    public SenderDict getSender() {
        return sender;
    }

    public void setSender(SenderDict sender) {
        this.sender = sender;
    }

    public ReceiverDict getReceiverDict() {
        return receiverDict;
    }

    public void setReceiverDict(ReceiverDict receiverDict) {
        this.receiverDict = receiverDict;
    }

    public MessageResultDict getMessageResultDict() {
        return messageResultDict;
    }

    public void setMessageResultDict(MessageResultDict messageResultDict) {
        this.messageResultDict = messageResultDict;
    }

    public Persons getPersons() {
        return persons;
    }

    public void setPersons(Persons persons) {
        this.persons = persons;
    }
}
