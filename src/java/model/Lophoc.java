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
@Table(name = "t_classes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lophoc.findAll", query = "SELECT l FROM Lophoc l"),
    @NamedQuery(name = "Lophoc.findById", query = "SELECT l FROM Lophoc l WHERE l.id = :id"),
    @NamedQuery(name = "Lophoc.findByName", query = "SELECT l FROM Lophoc l WHERE l.name = :name")})
public class Lophoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "classId")
    private Collection<SinhVien> sinhvienCollection;

    public Lophoc() {
    }

    public Lophoc(Integer id) {
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
    public Collection<SinhVien> getSinhvienCollection() {
        return sinhvienCollection;
    }

    public void setSinhvienCollection(Collection<SinhVien> sinhvienCollection) {
        this.sinhvienCollection = sinhvienCollection;
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
        if (!(object instanceof Lophoc)) {
            return false;
        }
        Lophoc other = (Lophoc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Lophoc[ id=" + id + " ]";
    }
    
}
