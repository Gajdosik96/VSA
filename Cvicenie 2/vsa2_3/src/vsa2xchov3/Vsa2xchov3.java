/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsa2xchov3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author xrevay
 */
public class Vsa2xchov3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsa2xchov3PU");
        EntityManager em = emf.createEntityManager();
        
        Person.najdiVsetkych(em);
        
    }
    
}
