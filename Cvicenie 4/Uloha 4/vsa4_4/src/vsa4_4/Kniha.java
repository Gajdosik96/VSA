/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsa4_4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Viktor
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Kniha.findAll", query = "SELECT k FROM Kniha k")
    , @NamedQuery(name = "Kniha.findById", query = "SELECT k FROM Kniha k WHERE k.id = :id")
    , @NamedQuery(name = "Kniha.findByIsbn", query = "SELECT k FROM Kniha k WHERE k.isbn = :isbn")
    , @NamedQuery(name = "Kniha.findByNazov", query = "SELECT k FROM Kniha k WHERE k.nazov = :nazov")})

public class Kniha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Vydavatel vydavatel;
    
    
    @ManyToMany(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
      name="AUTOR_KNIHA",
      joinColumns=@JoinColumn(name="KNIHA_ID", referencedColumnName="ID"),
      inverseJoinColumns=@JoinColumn(name="AUTOR_ID", referencedColumnName="ID"))
    private List<Autor> autori;
    
    private String isbn;
    private String nazov;
    
    @OneToMany(mappedBy = "kniha", fetch = FetchType.EAGER)
    private List<Polozka> polozky = new ArrayList<Polozka>();

    public List<Polozka> getPolozky() {
        return polozky;
    }

    public void setPolozky(List<Polozka> polozky) {
        this.polozky = polozky;
    }
    
    

    public Long getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }
    
    

    public void setId(Long id) {
        this.id = id;
    }

    public Vydavatel getVydavatel() {
        return vydavatel;
    }

    public void setVydavatel(Vydavatel vydavatel) {
        this.vydavatel = vydavatel;
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
        return "vsa4_4.Kniha[ id=" + id + " ]";
    }

    public List<Autor> getAutori() {
        return autori;
    }

    public void setAutori(List<Autor> autori) {
        this.autori = autori;
    }
    
}
