/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsa5_2;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Viktor
 */
public class Vsa5_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    //    create();
        // UPOZORNENIE, Create a Read nemoze byt v jednom behu programu, pretoze to potom cache-uje veci a nefachci to
        // Najskr vytvorit tabulky, potom s nimi pracovat!
        //read("os3");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsa5_2PU");
        EntityManager em = emf.createEntityManager();
        Osoba o = em.find(Osoba.class, 103L);
        if(o != null)
        {
            release(o);
        }
        em.close();
    }
    
    public static void release(Osoba o)
    { 
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsa5_2PU");
        EntityManager em = emf.createEntityManager();
        Osoba fnd = em.find(Osoba.class, o.getId());
        if(fnd != null)
        {
            em.getTransaction().begin();
            em.remove(fnd);
            em.getTransaction().commit();
        }
        em.close();
    }
    
    public static void read(String meno)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsa5_2PU");
        EntityManager em = emf.createEntityManager();
        
        Query q = em.createNamedQuery("Osoba.findByMeno", Osoba.class);
        
        q.setParameter("meno", meno);
         Osoba o = null;
        try{
            o = (Osoba)q.getSingleResult();
        }catch(javax.persistence.NoResultException e)
        {
            System.err.println("Osoba nenajdena");
             
            em.close();
            return;
        }
        if(o != null)
        {
            System.out.println(o.getMeno());
            System.err.println(o.getCvicenia().isEmpty());
            for(Predmet p : o.getCvicenia())
            {
                System.out.println("["+o.getMeno()+"] Civici: "+p.getNazov()+" Prednasajuci predmetu: "+p.getPrednasajuci().getMeno());
            }
        } else {
           
        }
        
        em.close();

    }
    
     public static void create() {

        Osoba o1 = new Osoba();
        o1.setMeno("os1");
        
        
        Osoba o2 = new Osoba();
        o2.setMeno("os2");
        
        
        Osoba o3 = new Osoba();
        o3.setMeno("os3");
        
        Predmet p1 = new Predmet();
        p1.setNazov("Pred1");
        p1.setPrednasajuci(o1);
        
        p1.setCviciaci(new ArrayList<>());
        p1.getCviciaci().add(o3);
        
        Predmet p2 = new Predmet();
        p2.setNazov("Pred2");
        
        p2.setCviciaci(new ArrayList<>());
        p2.getCviciaci().add(o2);
        p2.getCviciaci().add(o3);
        
        p2.setPrednasajuci(o2);
        
        
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsa5_2PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {

            em.persist(o1);
            em.persist(o2);
            em.persist(o3);
            em.persist(p1);
            em.persist(p2);

            em.getTransaction().commit();
            em.clear();

            System.out.println(p2.getCviciaci().size());

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

    }
    
}
