/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsa5_3;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Viktor
 */
public class Vsa5_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create();
        
        modify();
    }
    
    public static void modify()
    {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsa5_3PU");
        EntityManager em = emf.createEntityManager();
        
        Dokument base = em.find(Dokument.class, 1L);
        
        if(base != null)
        {
            
            em.getTransaction().begin();
            em.remove(base.getPodkapitoly().get(0));
            em.getTransaction().commit();

            //System.out.println(""+base.getPodkapitoly().get(0).getNazov());    
        }
        
        em.close();
    }
    
    public static void create()
    {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsa5_3PU");
        EntityManager em = emf.createEntityManager();
        
        Dokument base = new Dokument();
        base.setNazov("Test");
        base.setText("Bol raz jeden test, a tam sa diali ukrutné veci...");
        
        Dokument kap1 = new Dokument();
        kap1.setNazov("Kap1");
        Dokument kap2 = new Dokument();
        kap2.setNazov("Kap2");
        Dokument kap3 = new Dokument();
        kap3.setNazov("Kap3");
        
        
        Dokument kap1_1 = new Dokument();
        kap1_1.setNazov("Kap1_1");
        Dokument kap1_2 = new Dokument();
        kap1_2.setNazov("Kap1_2");
        Dokument kap1_3 = new Dokument();
        kap1_3.setNazov("Kap1_3");
        
        base.setPodkapitoly(new ArrayList());
        base.getPodkapitoly().add(kap1);
        base.getPodkapitoly().add(kap2);
        base.getPodkapitoly().add(kap3);
        
        kap1.setPodkapitoly(new ArrayList());
        kap1.getPodkapitoly().add(kap1_1);
        kap1.getPodkapitoly().add(kap1_2);
        kap1.getPodkapitoly().add(kap1_3);
        
        em.getTransaction().begin();
        
        em.persist(base);
        em.persist(kap1);
        em.persist(kap2);
        em.persist(kap3);
        em.persist(kap1_1);
        em.persist(kap1_2);
        em.persist(kap1_3);
        
        em.getTransaction().commit();
        em.close();
    }

    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsa5_3PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    
    
}
