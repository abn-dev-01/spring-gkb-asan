package com.abndev.asan.gkb.dom;

import com.abndev.asan.gkb.dom.dict.CountryDict;
import com.abndev.asan.gkb.dom.dict.DictUnit;
import com.abndev.asan.gkb.dom.dict.DistrictDict;
import com.abndev.asan.gkb.dom.dict.RegionDict;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "address_registration")
@XmlAccessorType(XmlAccessType.FIELD)
public class RegAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @XmlTransient
    private Integer gid;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "country_code")   // field, created in this table
    private CountryDict country;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "disctrict_code")   // field, created in this table
    private DistrictDict district;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "region_code")   // field, created in this table
    private RegionDict region;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "foreign_data_id")   // field, created in this table
    private ForeignData foreignData;

    @Column(name = "city", length = 64)
    private String city;
    @Column(length = 128)
    private String street;
    @Column(length = 8)
    private String building;
    @Column(length = 8)
    private String corpus;
    @Column(length = 8)
    private String flat;
    @Column(length = 32)
    private String beginDate;
    @Column(length = 32)
    private String endDate;
    //    private AddressStatus addressStatus;
    //    private AddressInvalidity invalidity;
    @Column(name = "ar_code", length = 32)
    private String arCode;

    public RegAddress() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RegAddress{");
        sb.append("gid=").append(gid);
        sb.append(", country=").append(country);
        sb.append(", district=").append(district);
        sb.append(", region=").append(region);
        sb.append(", foreignData=").append(foreignData);
        sb.append(", city='").append(city).append('\'');
        sb.append(", street='").append(street).append('\'');
        sb.append(", building='").append(building).append('\'');
        sb.append(", corpus='").append(corpus).append('\'');
        sb.append(", flat='").append(flat).append('\'');
        sb.append(", beginDate='").append(beginDate).append('\'');
        sb.append(", endDate='").append(endDate).append('\'');
        sb.append(", arCode='").append(arCode).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public CountryDict getCountry() {
        return country;
    }

    public void setCountry(CountryDict country) {
        this.country = country;
    }

    public DistrictDict getDistrict() {
        return district;
    }

    public void setDistrict(DistrictDict district) {
        this.district = district;
    }

    public RegionDict getRegion() {
        return region;
    }

    public void setRegion(RegionDict region) {
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
