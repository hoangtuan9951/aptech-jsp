/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "t_marks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diemso.findAll", query = "SELECT d FROM Diemso d"),
    @NamedQuery(name = "Diemso.findById", query = "SELECT d FROM Diemso d WHERE d.id = :id"),
    @NamedQuery(name = "Diemso.findByMark", query = "SELECT d FROM Diemso d WHERE d.mark = :mark"),
    @NamedQuery(name = "Diemso.findByExamDate", query = "SELECT d FROM Diemso d WHERE d.examDate = :examDate")})
public class Diemso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "mark")
    private Integer mark;
    @Column(name = "exam_date")
    @Temporal(TemporalType.DATE)
    private Date examDate;
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    @ManyToOne
    private SinhVien studentId;
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    @ManyToOne
    private Monhoc subjectId;

    public Diemso() {
    }

    public Diemso(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public SinhVien getStudentId() {
        return studentId;
    }

    public void setStudentId(SinhVien studentId) {
        this.studentId = studentId;
    }

    public Monhoc getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Monhoc subjectId) {
        this.subjectId = subjectId;
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
        if (!(object instanceof Diemso)) {
            return false;
        }
        Diemso other = (Diemso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Diemso[ id=" + id + " ]";
    }
    
}
