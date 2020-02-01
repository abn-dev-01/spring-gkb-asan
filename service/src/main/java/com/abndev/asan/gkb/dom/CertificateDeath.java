package com.abndev.asan.gkb.dom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Entity
@Table(name = "certificate_death")
@XmlAccessorType(XmlAccessType.FIELD)
public class CertificateDeath {

    @Id
    @Column(length = 32)
    private String number;
    @Column(name = "issue_organisation", length = 32)
    private String issueOrganisation;
    @Column(name = "begin_date", length = 32)
    private String beginDate;

    public CertificateDeath() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CertificateDeath{");
        sb.append("number='").append(number).append('\'');
        sb.append(", issueOrganisation='").append(issueOrganisation).append('\'');
        sb.append(", beginDate='").append(beginDate).append('\'');
        sb.append('}');
        return sb.toString();
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
