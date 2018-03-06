/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsa4_3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Viktor
 */
public class Vsa4_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsa4_3PU");
        EntityManager em = emf.createEntityManager();
        
        Kniha ka = new Kniha();
        ka.setNazov("Uz ma to troska nebavi");
        
        Kniha kb = new Kniha();
        kb.setNazov("Ale ze ani trocha");
        
        Vydavatelstvo v = new Vydavatelstvo();
        v.setAdresa("Zrazu ze daco");
        v.addPublikacia(ka);
        v.addPublikacia(kb);
        
        em.getTransaction().begin();
        em.persist(v);
        em.persist(ka);
        em.persist(kb);
        em.getTransaction().commit();
        em.close();
    }

    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsa4_3PU");
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
