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
@Table(name = "Repatriation_Status")
@XmlAccessorType(XmlAccessType.FIELD)
public class RepatriationStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @XmlTransient
    private Integer gid;

    @Column
    private Boolean repatriate;
    @Column(name = "begin_date")
    private String beginDate;
    @Column(name = "begin_end")
    private String endDate;

    public RepatriationStatus() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RepatriationStatus{");
        sb.append("gid=").append(gid);
        sb.append(", repatriate=").append(repatriate);
        sb.append(", beginDate='").append(beginDate).append('\'');
        sb.append(", endDate='").append(endDate).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
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
