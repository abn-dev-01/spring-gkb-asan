package com.abndev.asan.gkb.dom.dict;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "dict_Document_Type")
public class DocumentTypeDict {

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

    @Column(name = "change_date", length = 32, nullable = true)
    @XmlElement(name = "changeDate")
    private String changeDate;

    public DocumentTypeDict() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(getClass().getSimpleName() + "{");
        sb.append("code='").append(code).append('\'');
        sb.append(", nameRu='").append(nameRu).append('\'');
        sb.append(", nameKz='").append(nameKz).append('\'');
        sb.append(", changeDate='").append(changeDate).append('\'');
        sb.append('}');
        return sb.toString();
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
