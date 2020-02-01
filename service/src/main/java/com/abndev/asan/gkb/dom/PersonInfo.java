package com.abndev.asan.gkb.dom;

import com.abndev.asan.gkb.dom.dict.GenderDict;
import com.abndev.asan.gkb.dom.dict.LifeStatusDict;
import com.abndev.asan.gkb.dom.dict.NationalityDict;
import com.abndev.asan.gkb.dom.dict.CitizenshipDict;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

    @Column
    private Boolean removed;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "gender_id")   // field, created in this table
    private GenderDict gender;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "nationality_id")   // field, created in this table
    private NationalityDict nationality;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "citizenship_id")   // field, created in this table
    private CitizenshipDict citizenship;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "life_status_id")   // field, created in this table
    private LifeStatusDict lifeStatus;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "birth_сertificate_id")   // field, created in this table
    private CertificateBirth birthCertificate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "deatch_сertificate_id")   // field, created in this table
    private CertificateDeath deathCertificate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "birth_place_id")   // field, created in this table
    private BirthPlace birthPlace;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "reg_address_id")   // field, created in this table
    private RegAddress regAddress;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "person_cap_status_id")   // field, created in this table
    private PersonCapableStatus personCapableStatus;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "missing_status_id")   // field, created in this table
    private MissingStatus missingStatus;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "disappear_status_id")   // field, created in this table
    private DisappearStatus disappearStatus;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "exclude_status_id")   // field, created in this table
    private ExcludeStatus excludeStatus;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "repatriation_status_id")   // field, created in this table
    private RepatriationStatus repatriationStatus;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "exclude_status_id")   // field, created in this table
    private Documents documents;

    //    private RegAddress addresses;

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

    public GenderDict getGender() {
        return gender;
    }

    public void setGender(GenderDict gender) {
        this.gender = gender;
    }

    public NationalityDict getNationality() {
        return nationality;
    }

    public void setNationality(NationalityDict nationality) {
        this.nationality = nationality;
    }

    public CitizenshipDict getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(CitizenshipDict citizenship) {
        this.citizenship = citizenship;
    }

    public LifeStatusDict getLifeStatus() {
        return lifeStatus;
    }

    public void setLifeStatus(LifeStatusDict lifeStatus) {
        this.lifeStatus = lifeStatus;
    }

    public CertificateBirth getBirthCertificate() {
        return birthCertificate;
    }

    public void setBirthCertificate(CertificateBirth birthCertificate) {
        this.birthCertificate = birthCertificate;
    }

    public CertificateDeath getDeathCertificate() {
        return deathCertificate;
    }

    public void setDeathCertificate(CertificateDeath deathCertificate) {
        this.deathCertificate = deathCertificate;
    }

    public BirthPlace getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(BirthPlace birthPlace) {
        this.birthPlace = birthPlace;
    }

    public RegAddress getRegAddress() {
        return regAddress;
    }

    public void setRegAddress(RegAddress regAddress) {
        this.regAddress = regAddress;
    }

    public PersonCapableStatus getPersonCapableStatus() {
        return personCapableStatus;
    }

    public void setPersonCapableStatus(PersonCapableStatus personCapableStatus) {
        this.personCapableStatus = personCapableStatus;
    }

    public MissingStatus getMissingStatus() {
        return missingStatus;
    }

    public void setMissingStatus(MissingStatus missingStatus) {
        this.missingStatus = missingStatus;
    }

    public DisappearStatus getDisappearStatus() {
        return disappearStatus;
    }

    public void setDisappearStatus(DisappearStatus disappearStatus) {
        this.disappearStatus = disappearStatus;
    }

    public ExcludeStatus getExcludeStatus() {
        return excludeStatus;
    }

    public void setExcludeStatus(ExcludeStatus excludeStatus) {
        this.excludeStatus = excludeStatus;
    }

    public RepatriationStatus getRepatriationStatus() {
        return repatriationStatus;
    }

    public void setRepatriationStatus(RepatriationStatus repatriationStatus) {
        this.repatriationStatus = repatriationStatus;
    }

    public Documents getDocuments() {
        return documents;
    }

    public void setDocuments(Documents documents) {
        this.documents = documents;
    }
}
