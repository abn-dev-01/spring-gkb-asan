package com.abndev.asan.gkb.dom;

import com.abndev.asan.gkb.dom.dict.DictUnit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Entity
@Table(name = "person_info")
//@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonInfo {

    @Id
    @Column(length = 16, nullable = false)
    private String iin;

    @Column
    private String surname;
    @Column
    private String name;
    @Column
    private String patronymic;
    @Column
    private String birthDate;
    @Column
    private String deathDate;

    private DictUnit gender;
//    private DictUnit nationality;
//    private DictUnit citizenship;
//    private DictUnit lifeStatus;
//    private CertificateUnit birthCertificate;
//    private CertificateUnit deathCertificate;
//
//    private BirthPlace birthPlace;
//    private RegAddress regAddress;
//    private PersonCapableStatus personCapableStatus;
//    private MissingStatus missingStatus;
//    private DisappearStatus disappearStatus;
//    private ExcludeStatus excludeStatus;
//    private RepatriationStatus repatriationStatus;
//
//    //    private List<Document> documents;
//    private Documents documents;
//    private RegAddress addresses;

    private Boolean removed;

    public PersonInfo() {
    }

    public String getIin() {
        return iin;
    }

    public void setIin(String iin) {
        this.iin = iin;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(String deathDate) {
        this.deathDate = deathDate;
    }

    public Boolean getRemoved() {
        return removed;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }

//    public Persons getPersons() {
//        return persons;
//    }
//
//    public void setPersons(Persons persons) {
//        this.persons = persons;
//    }

}
