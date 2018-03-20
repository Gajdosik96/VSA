/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsa6_1;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Viktor
 */
public class Vsa6_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsa6_1PU");
        EntityManager em = emf.createEntityManager();
        
        Query q = em.createNamedQuery("Osoba.findAll");
        
        List<Osoba> l = q.getResultList();
        
        for(Osoba o : l)
        {
            if(o != null)
            {
                System.out.println(o.getMeno() + " "+o.getPriezvisko()+ ":"+o.getKontaktneUdaje().getMail()); 
            }
        }
        
        em.close();
        
    }

    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsa6_1PU");
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
