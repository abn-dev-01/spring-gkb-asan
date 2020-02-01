package com.abndev.asan.gkb.dom;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DisappearStatus {
    private Boolean disappear;
    private String disappearDate;
    private String disappearEndDate;
    private String disappearNumber;
    private String gpTerritorial;

    public DisappearStatus() {
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
