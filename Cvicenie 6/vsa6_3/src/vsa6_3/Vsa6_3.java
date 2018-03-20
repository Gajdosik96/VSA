/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsa6_3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Viktor
 */
public class Vsa6_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //create();
        
        //
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsa6_3PU");
        EntityManager em = emf.createEntityManager();
        
        Item i = new Item();
        MyData d = new MyData();
        d.setMyValue(444);
        i.setData(d);
        MyData dd = new MyData();
        dd.setMyValue(555);
        
        MyData ddd = new MyData();
        ddd.setMyValue(888);
        i.addData(dd);
        i.appendData(ddd);
        
        em.getTransaction().begin();
        em.persist(i);

        em.getTransaction().commit();
        em.close();
    }
    

    public static void load()
    {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsa6_3PU");
        EntityManager em = emf.createEntityManager();
        
        Item next = em.find(Item.class, 3L);
        while(next != null)
        {
            System.out.println(next.getId()+": "+next.getData().getMyValue());
            next = next.getNext();
        }
        
        em.close();
    }
    
    public void create()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsa6_3PU");
        EntityManager em = emf.createEntityManager();
        
        MyData d = new MyData();
        d.setMyValue(45);
        
        Item i = new Item();
        i.setData(d);
        
        MyData dd = new MyData();
        dd.setMyValue(55);
        
        Item ii = new Item();
        ii.setData(dd);
        
        ii.setNext(i);
                
        em.getTransaction().begin();
        em.persist(i);
        em.persist(ii);
        em.getTransaction().commit();
        
        em.close();
    }

    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsa6_3PU");
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
