/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsa5_1;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Viktor
 */
public class Vsa5_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        create();
        read();
    }
    
    public static void create() {
        
       /// a) 
        Kniha k1 = new Kniha();
        k1.setId(333L);
        k1.setNazov("Uvod do teorie automatov");

        Kniha k2 = new Kniha();
        k2.setNazov("Algoritmy a datove struktury");
        
        Osoba o1 = new Osoba();
        o1.setMeno("Hopcroft");
        o1.setDielo(new ArrayList<>());
        o1.getDielo().add(k1);
        o1.getDielo().add(k2);

        Osoba o2 = new Osoba();
        o2.setMeno("Ullman");
        o2.setDielo(new ArrayList<>());
        o2.getDielo().add(k1);
        o2.getDielo().add(k2);

        Osoba o3 = new Osoba();
        o3.setMeno("Aho");
        o3.setDielo(new ArrayList<>());
        o3.getDielo().add(k2);
        
        // + b)
        o1.setDielo(new ArrayList<>());
        o1.getDielo().add(k1);
        o1.getDielo().add(k2);

        o2.setDielo(new ArrayList<>());
        o2.getDielo().add(k1);
        o2.getDielo().add(k2);

        o3.setDielo(new ArrayList<>());
        o3.getDielo().add(k2);
        
        // c)
        
         // + b)

        //o3.getDielo().add(k1);


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsa5_1PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {

            em.persist(k1);
            em.persist(k2);
            em.persist(o1);
            em.persist(o2);
            em.persist(o3);

            em.getTransaction().commit();
            em.clear();

            System.out.println(k1.getAutor().size());

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

    }

    public static void read() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsa5_1PU");
        EntityManager em = emf.createEntityManager();
        
        Osoba a = em.find(Osoba.class, 3L);
        
        //Kniha k = em.find(Kniha.class, 333L);
        System.out.println(a.getMeno());
        System.out.println(a.getDielo().size());
    }

    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsa5_1PU");
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
