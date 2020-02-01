package com.abndev.asan.gkb.dom;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "documents")
@XmlAccessorType(XmlAccessType.FIELD)
public class Documents {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @XmlTransient
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @XmlElement(name = "document")
    private Set<Document> documents;

    public Documents() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Documents{");
        sb.append("id=").append(id);
        sb.append(", documents=").append(documents);
        sb.append('}');
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }
}
