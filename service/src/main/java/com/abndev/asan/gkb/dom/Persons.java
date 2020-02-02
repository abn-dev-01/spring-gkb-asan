package com.abndev.asan.gkb.dom;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "persons")
public class Persons {

    @Id
    @SequenceGenerator(name = "persons_seq", allocationSize = 1, sequenceName = "persons_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persons_seq")
    @XmlTransient
    private Integer gid;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "persons_id") // column in the remote table
    @XmlElement(name = "person")
    private List<PersonInfo> personInfos;

    @Column(name = "updated")
    private LocalDateTime updated = LocalDateTime.now();

    @Column(length = 16)
    private String inn;

    public Persons() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Persons{");
        sb.append("gid=").append(gid);
        sb.append(", personInfos=").append(personInfos);
        sb.append(", updated=").append(updated);
        sb.append(", inn='").append(inn).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public List<PersonInfo> getPersonInfos() {
        return personInfos;
    }

    public void setPersonInfos(List<PersonInfo> persons) {
        this.personInfos = persons;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

}
