package com.abndev.asan.gkb.dom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class MissingStatus {
    private Boolean missing;
    private String missingDate;
    private String missingEndDate;
    private String missingNumber;
//    private GpTerritorial gpTerritorial;

    public MissingStatus() {
    }

    public Boolean getMissing() {
        return missing;
    }

    public void setMissing(Boolean missing) {
        this.missing = missing;
    }

    public String getMissingDate() {
        return missingDate;
    }

    public void setMissingDate(String missingDate) {
        this.missingDate = missingDate;
    }

    public String getMissingEndDate() {
        return missingEndDate;
    }

    public void setMissingEndDate(String missingEndDate) {
        this.missingEndDate = missingEndDate;
    }

    public String getMissingNumber() {
        return missingNumber;
    }

    public void setMissingNumber(String missingNumber) {
        this.missingNumber = missingNumber;
    }
}
