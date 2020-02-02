package com.abndev.asan.gkb.dom;

import com.abndev.asan.gkb.dom.dict.DictUnit;
import com.abndev.asan.gkb.dom.dict.DocumentStatusDict;
import com.abndev.asan.gkb.dom.dict.DocumentTypeDict;
import com.abndev.asan.gkb.dom.dict.IssueOrganizationDict;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "Document_Details")
@XmlAccessorType(XmlAccessType.FIELD)
public class Document {
    @Id
    @SequenceGenerator(name = "docs_det_seq", allocationSize = 1, sequenceName = "docs_det_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "docs_det_seq")
    @XmlTransient
    private Integer gid;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "document_type_id")   // field, created in this table
    private DocumentTypeDict type;

    @Column(name = "number", length = 32)
    private String number;
    @Column(name = "begin_date", length = 32)
    private String beginDate;
    @Column(name = "end_date", length = 32)
    private String endDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "issue_org_id")   // field, created in this table
    private IssueOrganizationDict issueOrganization;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "doc_status_id")   // field, created in this table
    private DocumentStatusDict status;

    @Column(length = 64)
    private String surname;
    @Column(length = 64)
    private String name;
    @Column(length = 64)
    private String patronymic;
    @Column(name = "birth_date", length = 32)
    private String birthDate;

    public Document() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Document{");
        sb.append("gid=").append(gid);
        sb.append(", type=").append(type);
        sb.append(", number='").append(number).append('\'');
        sb.append(", beginDate='").append(beginDate).append('\'');
        sb.append(", endDate='").append(endDate).append('\'');
        sb.append(", issueOrganization=").append(issueOrganization);
        sb.append(", status=").append(status);
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", patronymic='").append(patronymic).append('\'');
        sb.append(", birthDate='").append(birthDate).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public void setType(DocumentTypeDict type) {
        this.type = type;
    }

    public DocumentTypeDict getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public IssueOrganizationDict getIssueOrganization() {
        return issueOrganization;
    }

    public void setIssueOrganization(IssueOrganizationDict issueOrganization) {
        this.issueOrganization = issueOrganization;
    }

    public DocumentStatusDict getStatus() {
        return status;
    }

    public void setStatus(DocumentStatusDict status) {
        this.status = status;
    }


}
