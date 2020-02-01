package com.abndev.asan.gkb.dom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class CertificateUnit {
    private String number;
    private String issueOrganisation;
    private String beginDate;

    public CertificateUnit() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getIssueOrganisation() {
        return issueOrganisation;
    }

    public void setIssueOrganisation(String issueOrganisation) {
        this.issueOrganisation = issueOrganisation;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }
}
