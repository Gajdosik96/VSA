/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsa4_4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Viktor
 */
public class Vsa4_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
       //create();
       //load("data3.csv");
       
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsa4_4PU");
        EntityManager em = emf.createEntityManager();
        /*
       Kniha k = em.find(Kniha.class, 30L);
        if(k != null)
        {
            for(Autor a : k.getAutori())
            {
                System.out.println("Autor: "+a.getMeno());
            }
        }
       */
       /*
       Autor a = em.find(Autor.class, 4L);
       
       for(Obchod ob : najdiObchody(a))
       {
            System.out.println(" Obchod "+ob.getNazov());
       }
        */
       em.close();
       
       List<Kniha> knihy = loadAll();
       
       for(Kniha kn : knihy)
       {
           System.out.println(kn.getNazov());
       }
    }
    
    public static List<Kniha> loadAll()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsa4_4PU");
        EntityManager em = emf.createEntityManager();
        
        Query q = em.createNamedQuery("Kniha.findAll");
        
        List<Kniha> out = q.getResultList();
        
        
        em.close();
        
        return out;
    }
    
    public static List<Obchod> najdiObchody(Autor au)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsa4_4PU");
        EntityManager em = emf.createEntityManager();
        List<Obchod> out = new ArrayList<Obchod>();
        if(au != null)
        {
            for(Kniha k : au.getKnihy())
            {
                //k.getId()
                for(Polozka p : k.getPolozky())
                {
                    if(!out.contains(p.getObchod()))
                    {
                        out.add(p.getObchod());
                    }
                }
            }
        }

        em.close();
        return out;
        
    }
    public static void load(String csv) throws FileNotFoundException, IOException
    {
        String line;
	BufferedReader br = new BufferedReader(new FileReader(csv));
        ArrayList<String> datas = new ArrayList<String>();
        
        HashMap<String,Obchod> obchody = new HashMap<String,Obchod>();
        HashMap<String,Kniha> knihy = new HashMap<String,Kniha>();
        HashMap<String,Vydavatel> vydavatelia = new HashMap<String,Vydavatel>();
        HashMap<String,Autor> autori = new HashMap<String,Autor>();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsa4_4PU");
        EntityManager em = emf.createEntityManager();
        
        
        while ((line = br.readLine()) != null) {
            datas.add(line);
            String s[] = line.split(";");

            if(s.length == 6){
                String autor = s[3].trim();
                String isbn = s[0].trim();
                String vyd = s[1].trim();
                String knih = s[2].trim();
                String obchd = s[4].trim();
                Double cen = Double.parseDouble(s[5].trim());
                
                Obchod ob = null;
                
                if(obchody.containsKey(obchd)){
                    ob = obchody.get(obchd);
                } else {
                    ob = new Obchod();
                    ob.setNazov(obchd);
                    obchody.put(obchd, ob);
                 /*   em.getTransaction().begin();
                    em.persist(ob);
                    em.getTransaction().commit();*/
                    
                }
                
                Vydavatel vydav = null;
                
                if(vydavatelia.containsKey(vyd))
                {
                    vydav = vydavatelia.get(vyd);
                } else {
                    vydav = new Vydavatel();
                    vydav.setNazov(vyd);
                    vydavatelia.put(vyd, vydav);
                   /* em.getTransaction().begin();
                    em.persist(vydav);
                    em.getTransaction().commit();*/
                }
                
                Kniha kn = null;
                boolean knnew = false;
                if(knihy.containsKey(isbn))
                {
                    kn = knihy.get(isbn);
                } else {
                    kn = new Kniha();
                    kn.setNazov(knih);
                    kn.setIsbn(isbn);
                    kn.setVydavatel(vydav);
                    kn.setAutori(new ArrayList<>());
                    knihy.put(isbn, kn);
                    knnew = true;
                }
                
                String[] autors = autor.split(",");
                for(String aut : autors)
                {
                    String bf = aut.trim();
                    Autor a = null;
                    if(autori.containsKey(bf))
                    {
                        a = autori.get(bf);
                        //a = em.contains(knihy);
                        //a = em.find(Autor.class, a.getId());
                    } else {
                        a = new Autor();
                        a.setMeno(bf);
                        autori.put(bf, a);
                       /* em.getTransaction().begin();
                        em.persist(a);
                        em.getTransaction().commit();*/
                    }
                    if(!kn.getAutori().contains(a))
                        kn.getAutori().add(a);
                }
               
                if(knnew) 
                {
                    /*
                    em.getTransaction().begin();
                    em.persist(kn);
                    
                    em.getTransaction().commit();*/
                }
                
                Polozka plz = new Polozka();
                plz.setCena(cen);
                plz.setKniha(kn);
                plz.setObchod(ob);    
                
                    em.getTransaction().begin();
                em.persist(plz);
                    em.getTransaction().commit();
            }
            //
        }     
        
        em.close();
    }
    
    public static void create()
    {
         
        Autor a = new Autor();
        a.setMeno("Peter");
        Autor a2 = new Autor();
        a2.setMeno("Pavol");
        Autor a3 = new Autor();
        a3.setMeno("Jana");
        
        Vydavatel v = new Vydavatel();
        v.setNazov("test");
        
        Kniha k = new Kniha();
        k.setNazov("Testovbacia knizka");
        k.setIsbn("65551-56556561");
        k.setVydavatel(v);
        k.setAutori(new ArrayList<>());
        k.getAutori().add(a);
        k.getAutori().add(a2);
        
        Obchod o = new Obchod();
        o.setNazov("Mall");
        
        Polozka p = new Polozka();
        p.setObchod(o);
        p.setKniha(k);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsa4_4PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        em.persist(a);
        em.persist(v);
        em.persist(k);
        em.persist(o);
        em.persist(p);
        
        em.getTransaction().commit();

        //persist(v);
        em.close();
        
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsa4_4PU");
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
