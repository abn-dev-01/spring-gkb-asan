package com.abndev.asan.gkb.dom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class RegAddress {
    private DictUnit country;
    private DictUnit district;
    private DictUnit region;
    private ForeignData foreignData;
    private String city;
    private String street;
    private String building;
    private String corpus;
    private String flat;
    private String beginDate;
    private String endDate;
    //    private AddressStatus addressStatus;
    //    private AddressInvalidity invalidity;
    private String arCode;

    public RegAddress() {
    }

    public DictUnit getCountry() {
        return country;
    }

    public void setCountry(DictUnit country) {
        this.country = country;
    }

    public DictUnit getDistrict() {
        return district;
    }

    public void setDistrict(DictUnit district) {
        this.district = district;
    }

    public DictUnit getRegion() {
        return region;
    }

    public void setRegion(DictUnit region) {
        this.region = region;
    }

    public ForeignData getForeignData() {
        return foreignData;
    }

    public void setForeignData(ForeignData foreignData) {
        this.foreignData = foreignData;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getCorpus() {
        return corpus;
    }

    public void setCorpus(String corpus) {
        this.corpus = corpus;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
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

    public String getArCode() {
        return arCode;
    }

    public void setArCode(String arCode) {
        this.arCode = arCode;
    }
}
