/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsa4_32;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Viktor
 */
@Entity
@Table(name = "KNIHA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kniha.findAll", query = "SELECT k FROM Kniha k")
    , @NamedQuery(name = "Kniha.findById", query = "SELECT k FROM Kniha k WHERE k.id = :id")
    , @NamedQuery(name = "Kniha.findByNazov", query = "SELECT k FROM Kniha k WHERE k.nazov = :nazov")})
public class Kniha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAZOV")
    private String nazov;
    @JoinTable(name = "VYDAVATELSTVO_KNIHA", joinColumns = {
        @JoinColumn(name = "PUBLIKACIA_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "VYDAVATELSTVO_ID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Vydavatelstvo> vydavatelstvoCollection;

    public Kniha() {
    }

    public Kniha(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    @XmlTransient
    public Collection<Vydavatelstvo> getVydavatelstvoCollection() {
        return vydavatelstvoCollection;
    }

    public void setVydavatelstvoCollection(Collection<Vydavatelstvo> vydavatelstvoCollection) {
        this.vydavatelstvoCollection = vydavatelstvoCollection;
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
        if (!(object instanceof Kniha)) {
            return false;
        }
        Kniha other = (Kniha) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vsa4_32.Kniha[ id=" + id + " ]";
    }
    
}
