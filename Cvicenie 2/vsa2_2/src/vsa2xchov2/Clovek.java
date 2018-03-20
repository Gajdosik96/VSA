/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsa2xchov2;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

/**
 *
 * @author xrevay
 */
@Entity
@Table(name = "CLOVEK")
@NamedQueries({
    @NamedQuery(name = "Clovek.findAll", query = "SELECT c FROM Clovek c"),
    @NamedQuery(name = "Clovek.findById", query = "SELECT c FROM Clovek c WHERE c.id = :id"),
    @NamedQuery(name = "Clovek.findByMeno", query = "SELECT c FROM Clovek c WHERE c.meno = :meno"),
    @NamedQuery(name = "Clovek.findByNarodena", query = "SELECT c FROM Clovek c WHERE c.narodena = :narodena"),
    @NamedQuery(name = "Clovek.findByVaha", query = "SELECT c FROM Clovek c WHERE c.vaha = :vaha"),
    @NamedQuery(name = "Clovek.findByVyska", query = "SELECT c FROM Clovek c WHERE c.vyska = :vyska"),
    @NamedQuery(name = "Clovek.fixVaha", query = "UPDATE Clovek c SET c.vaha = :vaha WHERE c.vaha IS NULL")})
public class Clovek implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "MENO")
    private String meno;
    @Column(name = "NARODENA")
    @Temporal(TemporalType.DATE)
    private Date narodena;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VAHA")
    private Double vaha;
    @Column(name = "VYSKA")
    private Double vyska;

    public Clovek() {
    }

    public Clovek(Long id) {
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

    public Date getNarodena() {
        return narodena;
    }

    public void setNarodena(Date narodena) {
        this.narodena = narodena;
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
    
    public static void najdiOsobu(Long id,EntityManager em)
    {
         Clovek b = em.find(Clovek.class, id);
         
         if(b != null)
         {
             System.out.println(b.toString());
         } else {
             System.err.println("Osoba s id "+id+" neexistuje");
         }
        /* 
         all.setParameter("id", id);
         
         for (Clovek o: all.getResultList()) {
         
         }*/
         
    }
    
    public static void najdiVsetkych(EntityManager em)
    {
        TypedQuery<Clovek> all = em.createNamedQuery("Clovek.findAll", Clovek.class);
        
        for(Clovek o: all.getResultList())
        {
             System.out.println(o.toString());
        }
    }
    
    public static void najdiPodlaMena(String meno, EntityManager em)
    {
        TypedQuery<Clovek> clv = em.createNamedQuery("Clovek.findByMeno", Clovek.class);
        clv.setParameter("meno", meno);
        
        try{
            Clovek b = clv.getSingleResult();
            System.out.println(b.toString());
        } catch(javax.persistence.NoResultException e)
        {
             System.err.println("Osoba s menom "+meno+" neexistuje");
        }

    }
    
    public static void opravVahu(Double vaha,EntityManager em){    
        TypedQuery<Clovek> clv = em.createNamedQuery("Clovek.fixVaha", Clovek.class);
        clv.setParameter("vaha", vaha);
        em.getTransaction().begin();
        clv.executeUpdate();
        em.getTransaction().commit();
        
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
        return "vsa2xchov2.Clovek[ id=" + id + ", meno="+meno+", narodena="+narodena+", vaha="+vaha+", vyska="+vyska+" ]";
    }
    
}
