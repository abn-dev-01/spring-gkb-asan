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
@Table(name = "Missing_Status")
@XmlAccessorType(XmlAccessType.FIELD)
public class MissingStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @XmlTransient
    private Integer gid;

    @Column
    private Boolean missing;
    @Column(name = "missing_date")
    private String missingDate;
    @Column(name = "missing_end_date")
    private String missingEndDate;
    @Column(name = "missing_number")
    private String missingNumber;
//    private GpTerritorial gpTerritorial;

    public MissingStatus() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MissingStatus{");
        sb.append("gid=").append(gid);
        sb.append(", missing=").append(missing);
        sb.append(", missingDate='").append(missingDate).append('\'');
        sb.append(", missingEndDate='").append(missingEndDate).append('\'');
        sb.append(", missingNumber='").append(missingNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Boolean getMissing() {
        return missing;
    }

    public void setMissing(Boolean missing) {
        this.missing = missing;
    }

    public String getMissingDate() {
        return missingDate;
    }

    public void setMissingDate(String missingDate) {
        this.missingDate = missingDate;
    }

    public String getMissingEndDate() {
        return missingEndDate;
    }

    public void setMissingEndDate(String missingEndDate) {
        this.missingEndDate = missingEndDate;
    }

    public String getMissingNumber() {
        return missingNumber;
    }

    public void setMissingNumber(String missingNumber) {
        this.missingNumber = missingNumber;
    }
}
