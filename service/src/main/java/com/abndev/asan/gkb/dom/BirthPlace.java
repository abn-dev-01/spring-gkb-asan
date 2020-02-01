package com.abndev.asan.gkb.dom;

import com.abndev.asan.gkb.dom.dict.DictUnit;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class BirthPlace {
    private DictUnit country;
    private DictUnit district;
    private DictUnit region;
    private String city;
    private String birthTeCodeAR;
    private ForeignData foreignData;

    public BirthPlace() {
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBirthTeCodeAR() {
        return birthTeCodeAR;
    }

    public void setBirthTeCodeAR(String birthTeCodeAR) {
        this.birthTeCodeAR = birthTeCodeAR;
    }

    public ForeignData getForeignData() {
        return foreignData;
    }

    public void setForeignData(ForeignData foreignData) {
        this.foreignData = foreignData;
    }
}
