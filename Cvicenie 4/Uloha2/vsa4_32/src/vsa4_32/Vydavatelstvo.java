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
@Table(name = "VYDAVATELSTVO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vydavatelstvo.findAll", query = "SELECT v FROM Vydavatelstvo v")
    , @NamedQuery(name = "Vydavatelstvo.findById", query = "SELECT v FROM Vydavatelstvo v WHERE v.id = :id")
    , @NamedQuery(name = "Vydavatelstvo.findByAdresa", query = "SELECT v FROM Vydavatelstvo v WHERE v.adresa = :adresa")})
public class Vydavatelstvo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "ADRESA")
    private String adresa;
    @ManyToMany(mappedBy = "vydavatelstvoCollection")
    private Collection<Kniha> knihaCollection;

    public Vydavatelstvo() {
    }

    public Vydavatelstvo(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @XmlTransient
    public Collection<Kniha> getKnihaCollection() {
        return knihaCollection;
    }

    public void setKnihaCollection(Collection<Kniha> knihaCollection) {
        this.knihaCollection = knihaCollection;
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
        if (!(object instanceof Vydavatelstvo)) {
            return false;
        }
        Vydavatelstvo other = (Vydavatelstvo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vsa4_32.Vydavatelstvo[ id=" + id + " ]";
    }
    
}
