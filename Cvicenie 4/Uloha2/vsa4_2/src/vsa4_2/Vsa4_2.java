/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsa4_2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Viktor
 */
public class Vsa4_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsa4_2PU");
        EntityManager em = emf.createEntityManager();
        
        Vydavatelstvo v = new Vydavatelstvo();
        v.setAdresa("Ilkovičova 27/4");
        
        Kniha ka = new Kniha();
        ka.setNazov("Java Essentials 801");
        ka.setVydavatel(v);
        
        Kniha kb = new Kniha();
        kb.setNazov("Java Pro 901");
        kb.setVydavatel(v);
        
        // Upraceme DB od minulej ulohy
        
       /* try {
        em.getTransaction().begin();
        em.createNativeQuery("drop table KNIHA_OSOBA").executeUpdate();
        em.createNativeQuery("drop table OSOBA").executeUpdate();
        em.createNativeQuery("drop table KNIHA").executeUpdate();
        em.createNativeQuery("drop table VYDAVATELSTVO").executeUpdate();
        em.getTransaction().commit();
        }catch(Exception e)
        {
            System.err.println("Netreba mazat");
        }*/
       
        
        em.getTransaction().begin();
        em.persist(v);
        em.persist(ka);
        em.persist(kb);
        em.getTransaction().commit();
        
    }

    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsa4_2PU");
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
