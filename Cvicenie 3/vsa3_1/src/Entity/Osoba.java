/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Viktor
 */
@Entity
@Table(name = "OSOBA")
@NamedQueries({
    @NamedQuery(name = "Osoba.findAll", query = "SELECT o FROM Osoba o")
    , @NamedQuery(name = "Osoba.findById", query = "SELECT o FROM Osoba o WHERE o.id = :id")
    , @NamedQuery(name = "Osoba.findByMeno", query = "SELECT o FROM Osoba o WHERE o.meno = :meno")
    , @NamedQuery(name = "Osoba.findByVaha", query = "SELECT o FROM Osoba o WHERE o.vaha = :vaha")
    , @NamedQuery(name = "Osoba.findByVyska", query = "SELECT o FROM Osoba o WHERE o.vyska = :vyska")
    , @NamedQuery(name = "Osoba.fixOsobaVaha", query = "UPDATE Osoba o SET o.vaha = 80.0 WHERE o.vaha IS NULL")})
public class Osoba implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "MENO")
    private String meno;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VAHA")
    private Double vaha;
    @Column(name = "VYSKA")
    private Double vyska;

    public Osoba() {
    }

    public Osoba(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public Double getVaha() {
        return vaha;
    }

    public void setVaha(Double vaha) {
        this.vaha = vaha;
    }

    public Double getVyska() {
        return vyska;
    }

    public void setVyska(Double vyska) {
        this.vyska = vyska;
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
        if (!(object instanceof Osoba)) {
            return false;
        }
        Osoba other = (Osoba) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Osoba[ id=" + id + " ]";
    }
    
}
