package com.abndev.asan.gkb.dom;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Set;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "persons")
public class Persons {

    @Id
    @SequenceGenerator(name = "persons_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persons_seq")
    @XmlTransient
    private Integer gid;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @XmlElement(name = "person")
    private Set<PersonInfo> personInfos;

    public Persons() {
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Set<PersonInfo> getPersonInfos() {
        return personInfos;
    }

    public void setPersonInfos(Set<PersonInfo> persons) {
        this.personInfos = persons;
    }
}
