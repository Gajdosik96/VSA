/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uloha1;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Viktor
 */
@Entity
@Table(name = "TOVAR")
@NamedQueries({
    @NamedQuery(name = "Tovar.findAll", query = "SELECT t FROM Tovar t")
    , @NamedQuery(name = "Tovar.findById", query = "SELECT t FROM Tovar t WHERE t.id = :id")
    , @NamedQuery(name = "Tovar.findByNazov", query = "SELECT t FROM Tovar t WHERE t.nazov = :nazov")
    , @NamedQuery(name = "Tovar.findByCena", query = "SELECT t FROM Tovar t WHERE t.cena = :cena")})
public class Tovar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "NAZOV")
    private String nazov;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CENA")
    private Double cena;

    public Tovar() {
    }

    public Tovar(Long id) {
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

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
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
        if (!(object instanceof Tovar)) {
            return false;
        }
        Tovar other = (Tovar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uloha1.Tovar[ id=" + id + " ]";
    }
    
}
