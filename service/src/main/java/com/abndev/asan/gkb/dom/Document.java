package com.abndev.asan.gkb.dom;

import com.abndev.asan.gkb.dom.dict.DictUnit;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

//@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Document {
    private DictUnit type;
    private String number;
    private String beginDate;
    private String endDate;
    private DictUnit issueOrganization;
    private DictUnit status;
    private String surname;
    private String name;
    private String patronymic;
    private String birthDate;

    public Document() {
    }

    public DictUnit getType() {
        return type;
    }

    public void setType(DictUnit type) {
        this.type = type;
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

    public DictUnit getIssueOrganization() {
        return issueOrganization;
    }

    public void setIssueOrganization(DictUnit issueOrganization) {
        this.issueOrganization = issueOrganization;
    }

    public DictUnit getStatus() {
        return status;
    }

    public void setStatus(DictUnit status) {
        this.status = status;
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
}
