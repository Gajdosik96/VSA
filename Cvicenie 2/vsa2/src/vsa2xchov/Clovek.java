/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsa2xchov;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author xrevay
 */
@Entity
public class Clovek implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String meno;

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }
    
    @Temporal(TemporalType.DATE)
    private Date narodena;

    public Date getNarodena() {
        return narodena;
    }

    public void setNarodena(Date narodena) {
        this.narodena = narodena;
    }
 
       private float vyska;

    public float getVyska() {
        return vyska;
    }

    public void setVyska(float vyska) {
        this.vyska = vyska;
    }
 
    private Float vaha;

    public Float getVaha() {
        return vaha;
    }

    public void setVaha(Float vaha) {
        this.vaha = vaha;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Clovek)) {
            return false;
        }
        Clovek other = (Clovek) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vsa2xchov.Clovek[ id=" + id + " ]";
    }
    
}
