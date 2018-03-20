/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsa6_2;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Viktor
 */
@Entity
@Table(name = "KONTAKT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kontakt.findAll", query = "SELECT k FROM Kontakt k")
    , @NamedQuery(name = "Kontakt.findById", query = "SELECT k FROM Kontakt k WHERE k.id = :id")
    , @NamedQuery(name = "Kontakt.findByMail", query = "SELECT k FROM Kontakt k WHERE k.mail = :mail")
    , @NamedQuery(name = "Kontakt.findByTel", query = "SELECT k FROM Kontakt k WHERE k.tel = :tel")})
public class Kontakt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "MAIL")
    private String mail;
    @Column(name = "TEL")
    private String tel;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Osoba osoba;
    
    public Kontakt() {
    }

    public Kontakt(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Osoba getOsoba() {
        return osoba;
    }

    public void setOsoba(Osoba osoba) {
        this.osoba = osoba;
    }
    
    

    public void setId(Long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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
        if (!(object instanceof Kontakt)) {
            return false;
        }
        Kontakt other = (Kontakt) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vsa6_1.Kontakt[ id=" + id + " ]";
    }
    
}
