/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsa4_3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Viktor
 */
@Entity
public class Vydavatelstvo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String adresa;
    
    //@OneToMany
    //@JoinColumn(name="vydavatel_fk")
    private List<Kniha> publikacia = new ArrayList<Kniha>();

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

    public List<Kniha> getPublikacia() {
        return publikacia;
    }

    public void setPublikacia(List<Kniha> publikacia) {
        this.publikacia = publikacia;
    }
    
    public void addPublikacia(Kniha kniha)
    {
        this.publikacia.add(kniha);
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
        return "vsa4_3.Vydavatelstvo[ id=" + id + " ]";
    }
    
}
