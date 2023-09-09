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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "t_teachers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Giaovien.findAll", query = "SELECT g FROM Giaovien g"),
    @NamedQuery(name = "Giaovien.findById", query = "SELECT g FROM Giaovien g WHERE g.id = :id"),
    @NamedQuery(name = "Giaovien.findByFirstName", query = "SELECT g FROM Giaovien g WHERE g.firstName = :firstName"),
    @NamedQuery(name = "Giaovien.findByLastName", query = "SELECT g FROM Giaovien g WHERE g.lastName = :lastName")})
public class Giaovien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "first_name")
    private String firstName;
    @Size(max = 100)
    @Column(name = "last_name")
    private String lastName;
    @ManyToMany(mappedBy = "giaovienCollection")
    private Collection<Monhoc> monhocCollection;

    public Giaovien() {
    }

    public Giaovien(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlTransient
    public Collection<Monhoc> getMonhocCollection() {
        return monhocCollection;
    }

    public void setMonhocCollection(Collection<Monhoc> monhocCollection) {
        this.monhocCollection = monhocCollection;
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
        if (!(object instanceof Giaovien)) {
            return false;
        }
        Giaovien other = (Giaovien) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Giaovien[ id=" + id + " ]";
    }
    
}
