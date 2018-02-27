/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsa3_1;

import Entity.Osoba;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Viktor
 */
public class Vsa3_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsa3_1PU");
        EntityManager em = emf.createEntityManager();
        
        
        TypedQuery<Osoba> os = em.createNamedQuery("Osoba.findAll", Osoba.class);
        for(Osoba o: os.getResultList())
        {
            System.out.println(o.toString());
        }
        
        TypedQuery<Osoba> bm = em.createNamedQuery("Osoba.findByMeno",Osoba.class);
        bm.setParameter("meno", "Andrea");
        
        System.out.println(bm.getSingleResult().toString());
        
        em.getTransaction().begin();
        
        TypedQuery fix = (TypedQuery) em.createNamedQuery("Osoba.fixOsobaVaha");
        fix.executeUpdate();
        
        em.getTransaction().commit();
        
        em.close();
        // TODO code application logic here
    }

    public void persist(Object object) {

    }
    
}
