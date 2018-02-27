/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsa3_2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Viktor
 */
public class Vsa3_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsa3_2PU");
        EntityManager em = emf.createEntityManager();
        
        //                              Opakované volanie persist
        /*
        em.getTransaction().begin();
        Osoba os = new Osoba();
        os.setMeno("Anton");
        
        Osoba oss = new Osoba();
        oss.setMeno("Anton");
        
        em.persist(os);
        em.persist(oss);
        
        em.getTransaction().commit();
        */
        
        //  Opakované volanie persist = bez autogenerovaného klúča
        /*
        em.getTransaction().begin();
        
        Osoba os = new Osoba(1L);
        os.setMeno("Peter");
        os.setVaha(55.5);
        os.setVyska(175.5);
        
        Osoba oss = new Osoba(1L);
        oss.setMeno("Andrej");
        oss.setVaha(55.5);
        oss.setVyska(175.5);
        
        em.persist(os);
        em.persist(oss);
        
        em.getTransaction().commit();
        */
        // Vysledok: duplicitne kluce
        //  The statement was aborted because it would have caused a duplicate key value in a unique or primary key constraint or unique index identified by 'SQL180227084438850' defined on 'OSOBA'
       
        
        // persit a merge
        /*
        em.getTransaction().begin();
        
        Osoba os = new Osoba(1L);
        os.setMeno("Peter");
        os.setVaha(55.5);
        os.setVyska(175.5);
        
        Osoba oss = new Osoba(1L);
        oss.setMeno("Andej");
        oss.setVaha(55.5);
        oss.setVyska(175.5);
        
        em.persist(os);
        em.merge(oss);
        
        em.getTransaction().commit();
        */
        // Zmenilo udaje ktore boli zadane pri druhej instancii
        
       
        //clear
        /*
         em.getTransaction().begin();
        Osoba os = new Osoba(1L);
        os.setMeno("Peter");
        
        em.persist(os);
        em.clear(); // Zrusi vsetky doteraz manazovane entity z managera
        
        Osoba oss = new Osoba(1L);
        oss.setMeno("Anton");
        
        em.persist(oss);
        
        em.getTransaction().commit();
        // Prida nam to len poslednu vytvorenu osobu Anton, ktora je manazovana
        */
        
        //detach
        /*
        em.getTransaction().begin();
        Osoba os = new Osoba(1L);
        os.setMeno("Peter");
        
        em.persist(os);
        
        Osoba oss = new Osoba(1L);
        oss.setMeno("Anton");
        
        em.persist(oss);
        
        em.detach(oss);
        
        em.getTransaction().commit();
*/
        
        // Opakované volanie find
/*        
        Osoba o = em.find(Osoba.class, 1L);
        Osoba os = em.find(Osoba.class, 1L);
        
        System.out.println("(o == o): "+(o == os));
   */     
        
        // find a detach
        /*
        Osoba o = em.find(Osoba.class, 1L);
        
        em.detach(o);     
        Osoba os = em.find(Osoba.class, 1L);
        
        System.out.println("(o == o): "+(o == os));
        
        em.close();
*/
        
        
        //JPA kontroler
        
        OsobaJpaController dao = new OsobaJpaController(emf);
        
        Osoba p = new Osoba(1L,"Pipi");
        dao.create(p);
        
        
    }

    
}
