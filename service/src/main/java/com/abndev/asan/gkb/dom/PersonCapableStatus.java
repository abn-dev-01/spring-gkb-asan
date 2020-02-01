package com.abndev.asan.gkb.dom;

import com.abndev.asan.gkb.dom.dict.CapableStatusDict;

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
@Table(name = "person_capa_status")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonCapableStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @XmlTransient
    private Integer gid;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "capable_Status_id")   // field, created in this table
    private CapableStatusDict capableStatusDict;

    @Column(name = "capable_date")
    private String capableDate;
    @Column(name = "capable_end_date")
    private String capableEndDate;
    @Column(name = "capable_number")
    private String capableNumber;
    @Column(name = "court")
    private String court;

    public PersonCapableStatus() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PersonCapableStatus{");
        sb.append("gid=").append(gid);
        sb.append(", capableStatusDict=").append(capableStatusDict);
        sb.append(", capableDate='").append(capableDate).append('\'');
        sb.append(", capableEndDate='").append(capableEndDate).append('\'');
        sb.append(", capableNumber='").append(capableNumber).append('\'');
        sb.append(", court='").append(court).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public CapableStatusDict getCapableStatusDict() {
        return capableStatusDict;
    }

    public void setCapableStatusDict(CapableStatusDict capableStatusDict) {
        this.capableStatusDict = capableStatusDict;
    }

    public String getCapableDate() {
        return capableDate;
    }

    public void setCapableDate(String capableDate) {
        this.capableDate = capableDate;
    }

    public String getCapableEndDate() {
        return capableEndDate;
    }

    public void setCapableEndDate(String capableEndDate) {
        this.capableEndDate = capableEndDate;
    }

    public String getCapableNumber() {
        return capableNumber;
    }

    public void setCapableNumber(String capableNumber) {
        this.capableNumber = capableNumber;
    }

    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court;
    }


}
