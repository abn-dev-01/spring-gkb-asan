package com.abndev.asan.gkb.dom;

import com.abndev.asan.gkb.dom.dict.CountryDict;
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
@Table(name = "birth_place")
@XmlAccessorType(XmlAccessType.FIELD)
public class BirthPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @XmlTransient
    private Integer gid;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "country_code")   // field, created in this table
    private CountryDict country;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "disctrict_code")   // field, created in this table
    private DistrictDict district;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "region_code")   // field, created in this table
    private RegionDict region;

    @Column(length = 64)
    private String city;
    @Column(name = "birth_te_code_ar", length = 64)
    private String birthTeCodeAR;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "foreign_data_id")   // field, created in this table
    private ForeignData foreignData;

    public BirthPlace() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BirthPlace{");
        sb.append("gid=").append(gid);
        sb.append(", country=").append(country);
        sb.append(", district=").append(district);
        sb.append(", region=").append(region);
        sb.append(", city='").append(city).append('\'');
        sb.append(", birthTeCodeAR='").append(birthTeCodeAR).append('\'');
        sb.append(", foreignData=").append(foreignData);
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
