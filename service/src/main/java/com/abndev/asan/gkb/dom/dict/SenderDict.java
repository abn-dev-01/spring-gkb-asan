package com.abndev.asan.gkb.dom.dict;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Dictionary sender.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "dict_sender")
public class SenderDict {

    @Id
    @Column(name = "code", length = 16)
    @XmlElement(name = "code")
    private String code;

    @Column(name = "name_ru", length = 255)
    @XmlElement(name = "nameRu")
    private String nameRu;

    @Column(name = "name_kz", length = 255)
    @XmlElement(name = "nameKz")
    private String nameKz;

    @Column(name = "change_date", length = 32)
    @XmlElement(name = "changeDate")
    private String changeDate;

    public SenderDict() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public String getNameKz() {
        return nameKz;
    }

    public void setNameKz(String nameKz) {
        this.nameKz = nameKz;
    }

    public String getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(String changeDate) {
        this.changeDate = changeDate;
    }
}
