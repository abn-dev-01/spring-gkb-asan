package com.abndev.asan.gkb.dom;

import com.abndev.asan.gkb.dom.dict.DictUnit;
import com.abndev.asan.gkb.dom.dict.ExcludeStatusDict;

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
@Table(name = "Exclude_Status")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExcludeStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @XmlTransient
    private Integer gid;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "exclude_status_id")   // field, created in this table
    private ExcludeStatusDict excludeStatus;

    @Column(name = "exclude_reason_date")
    private String excludeReasonDate;
    @Column(name = "exclude_date")
    private String excludeDate;
    @Column(name = "exclude_participant")
    private String excludeParticipant;

    public ExcludeStatus() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ExcludeStatus{");
        sb.append("gid=").append(gid);
        sb.append(", excludeStatus=").append(excludeStatus);
        sb.append(", excludeReasonDate='").append(excludeReasonDate).append('\'');
        sb.append(", excludeDate='").append(excludeDate).append('\'');
        sb.append(", excludeParticipant='").append(excludeParticipant).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public void setExcludeStatus(ExcludeStatusDict excludeStatus) {
        this.excludeStatus = excludeStatus;
    }

    public ExcludeStatusDict getExcludeStatus() {
        return excludeStatus;
    }

    public String getExcludeReasonDate() {
        return excludeReasonDate;
    }

    public void setExcludeReasonDate(String excludeReasonDate) {
        this.excludeReasonDate = excludeReasonDate;
    }

    public String getExcludeDate() {
        return excludeDate;
    }

    public void setExcludeDate(String excludeDate) {
        this.excludeDate = excludeDate;
    }

    public String getExcludeParticipant() {
        return excludeParticipant;
    }

    public void setExcludeParticipant(String excludeParticipant) {
        this.excludeParticipant = excludeParticipant;
    }
}
