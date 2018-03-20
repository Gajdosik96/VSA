/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsa2xchov;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author xrevay
 */
public class Vsa2xchov {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsa2xchovPU");
        EntityManager em = emf.createEntityManager();
       
        em.getTransaction().begin();
        
        Clovek c1 = new Clovek();
        c1.setMeno("Peter");
        c1.setNarodena(new Date());
        c1.setVaha((float)98.2);
        c1.setVyska((float)185.4);
        
        em.persist(c1);
        
        Clovek c2 = new Clovek();
        c2.setMeno("Jana");
        c2.setNarodena(new Date());
        c2.setVaha((float)68.2);
        c2.setVyska((float)155.4);
        em.persist(c2);
        
        Clovek c3 = new Clovek();
        c3.setMeno("Andrea");
        c3.setNarodena(new Date());
        c3.setVaha((float)65.8);
        c3.setVyska((float)164.4);
        em.persist(c3);
        
        em.getTransaction().commit();
        
    }
    
}
