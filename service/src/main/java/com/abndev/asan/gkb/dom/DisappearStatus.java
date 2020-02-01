package com.abndev.asan.gkb.dom;

import com.sun.org.apache.xpath.internal.operations.Bool;

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
@Table(name = "Disappear_Status")
@XmlAccessorType(XmlAccessType.FIELD)
public class DisappearStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @XmlTransient
    private Integer gid;

    @Column
    private Boolean disappear;
    @Column(name = "disappear_date")
    private String disappearDate;
    @Column(name = "disappear_end_date")
    private String disappearEndDate;
    @Column(name = "disappear_number")
    private String disappearNumber;
    @Column(name = "gp_territorial")
    private String gpTerritorial;

    public DisappearStatus() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DisappearStatus{");
        sb.append("gid=").append(gid);
        sb.append(", disappear=").append(disappear);
        sb.append(", disappearDate='").append(disappearDate).append('\'');
        sb.append(", disappearEndDate='").append(disappearEndDate).append('\'');
        sb.append(", disappearNumber='").append(disappearNumber).append('\'');
        sb.append(", gpTerritorial='").append(gpTerritorial).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Boolean getDisappear() {
        return disappear;
    }

    public void setDisappear(Boolean disappear) {
        this.disappear = disappear;
    }

    public String getDisappearDate() {
        return disappearDate;
    }

    public void setDisappearDate(String disappearDate) {
        this.disappearDate = disappearDate;
    }

    public String getDisappearEndDate() {
        return disappearEndDate;
    }

    public void setDisappearEndDate(String disappearEndDate) {
        this.disappearEndDate = disappearEndDate;
    }

    public String getDisappearNumber() {
        return disappearNumber;
    }

    public void setDisappearNumber(String disappearNumber) {
        this.disappearNumber = disappearNumber;
    }

    public String getGpTerritorial() {
        return gpTerritorial;
    }

    public void setGpTerritorial(String gpTerritorial) {
        this.gpTerritorial = gpTerritorial;
    }
}
