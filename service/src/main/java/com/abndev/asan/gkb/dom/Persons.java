package com.abndev.asan.gkb.dom;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
    @GeneratedValue(strategy = GenerationType.TABLE)
    @XmlTransient
    private Integer gid;

    //    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persons", orphanRemoval = true)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "persons_id") // Column name in the remote Table
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
