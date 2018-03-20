/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsa2xchov2;

import com.sun.org.apache.bcel.internal.generic.LoadClass;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author xrevay
 */
public class Vsa2xchov2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsa2xchov2PU");
        EntityManager em = emf.createEntityManager();
        
        Clovek.najdiOsobu(2L, em);
        
        Clovek.najdiVsetkych(em);
        
        Clovek.najdiPodlaMena("Peter",em);
        Clovek.najdiPodlaMena("Marko",em);
       
        
        Clovek.opravVahu(80.0,em);
        // TODO code application logic here
    }
    
}
