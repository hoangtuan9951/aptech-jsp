/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "t_subjects")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Monhoc.findAll", query = "SELECT m FROM Monhoc m"),
    @NamedQuery(name = "Monhoc.findById", query = "SELECT m FROM Monhoc m WHERE m.id = :id"),
    @NamedQuery(name = "Monhoc.findByName", query = "SELECT m FROM Monhoc m WHERE m.name = :name")})
public class Monhoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @JoinTable(name = "t_subject_teacher", joinColumns = {
        @JoinColumn(name = "subject_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "teacher_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Giaovien> giaovienCollection;
    @OneToMany(mappedBy = "subjectId")
    private Collection<Diemso> diemsoCollection;

    public Monhoc() {
    }

    public Monhoc(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Giaovien> getGiaovienCollection() {
        return giaovienCollection;
    }

    public void setGiaovienCollection(Collection<Giaovien> giaovienCollection) {
        this.giaovienCollection = giaovienCollection;
    }

    @XmlTransient
    public Collection<Diemso> getDiemsoCollection() {
        return diemsoCollection;
    }

    public void setDiemsoCollection(Collection<Diemso> diemsoCollection) {
        this.diemsoCollection = diemsoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Monhoc)) {
            return false;
        }
        Monhoc other = (Monhoc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Monhoc[ id=" + id + " ]";
    }
    
}
