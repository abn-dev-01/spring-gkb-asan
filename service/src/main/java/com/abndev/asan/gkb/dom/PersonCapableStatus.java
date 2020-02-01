package com.abndev.asan.gkb.dom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class PersonCapableStatus {
    private DictUnit capableStatus;
    private String capableDate;
    private String capableEndDate;
    private String capableNumber;
    private String court;

    public PersonCapableStatus() {
    }

    public DictUnit getCapableStatus() {
        return capableStatus;
    }

    public void setCapableStatus(DictUnit capableStatus) {
        this.capableStatus = capableStatus;
    }

    public String getCapableDate() {
        return capableDate;
    }

    public void setCapableDate(String capableDate) {
        this.capableDate = capableDate;
    }

    public String getCapableEndDate() {
        return capableEndDate;
    }

    public void setCapableEndDate(String capableEndDate) {
        this.capableEndDate = capableEndDate;
    }

    public String getCapableNumber() {
        return capableNumber;
    }

    public void setCapableNumber(String capableNumber) {
        this.capableNumber = capableNumber;
    }

    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court;
    }
}
