package com.abndev.asan.gkb.dom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class RepatriationStatus {
    private Boolean repatriate;
    private String beginDate;
    private String endDate;

    public RepatriationStatus() {
    }

    public Boolean getRepatriate() {
        return repatriate;
    }

    public void setRepatriate(Boolean repatriate) {
        this.repatriate = repatriate;
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
}
