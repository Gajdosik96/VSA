/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsa4_1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Viktor
 */
public class Vsa4_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsa4_1PU");
        EntityManager em = emf.createEntityManager();
        
        Osoba oa = new Osoba("Peter Velký");
        Osoba ob = new Osoba("Antonin Novotný");
        
        Kniha ka = new Kniha("Java Essentials 101");
        ka.addAutor(oa);
        ka.addAutor(ob);
        Kniha kb = new Kniha("Java Advanced 201");
        kb.addAutor(oa);
        kb.addAutor(ob);
        
        em.getTransaction().begin();
        em.persist(oa);
        em.persist(ob);
        em.persist(ka);
        em.persist(kb);
        em.getTransaction().commit();
    }

    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsa4_1PU");
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
