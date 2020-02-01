package com.abndev.asan.gkb.dom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class ExcludeStatus {
    private DictUnit excludeStatus;
    private String excludeReasonDate;
    private String excludeDate;
    private String excludeParticipant;

    public ExcludeStatus() {
    }

    public DictUnit getExcludeStatus() {
        return excludeStatus;
    }

    public void setExcludeStatus(DictUnit excludeStatus) {
        this.excludeStatus = excludeStatus;
    }

    public String getExcludeReasonDate() {
        return excludeReasonDate;
    }

    public void setExcludeReasonDate(String excludeReasonDate) {
        this.excludeReasonDate = excludeReasonDate;
    }

    public String getExcludeDate() {
        return excludeDate;
    }

    public void setExcludeDate(String excludeDate) {
        this.excludeDate = excludeDate;
    }

    public String getExcludeParticipant() {
        return excludeParticipant;
    }

    public void setExcludeParticipant(String excludeParticipant) {
        this.excludeParticipant = excludeParticipant;
    }
}
