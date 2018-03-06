/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uloha1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Viktor
 */
public class Uloha1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        load("data.csv");
    }
    
    public static void load(String csv) throws FileNotFoundException, IOException
    {
        String line;
	BufferedReader br = new BufferedReader(new FileReader(csv));
        ArrayList<String> tovar = new ArrayList<String>();
        
        while ((line = br.readLine()) != null) {
            String s[] = line.split(";");
            
            if(s.length == 2){
                if(!tovar.contains(s[0])){
                    tovar.add(s[0]);

                    Double cena = Double.parseDouble(s[1]);
                    
                    Tovar buff = new Tovar();
                    buff.setNazov(s[0].trim());
                    buff.setCena(cena);
                    
                    persist(buff);
                }
            }
            //
        }              
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("uloha1PU");
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
