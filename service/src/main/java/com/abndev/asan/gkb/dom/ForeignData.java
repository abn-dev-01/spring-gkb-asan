package com.abndev.asan.gkb.dom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "Foreign_Data")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForeignData {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @XmlTransient
    private Integer gid;

    @Column(name = "district_name", length = 64)
    private String districtName;
    @Column(name = "region_name", length = 64)
    private String regionName;

    public ForeignData() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ForeignData{");
        sb.append("gid=").append(gid);
        sb.append(", districtName='").append(districtName).append('\'');
        sb.append(", regionName='").append(regionName).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}
