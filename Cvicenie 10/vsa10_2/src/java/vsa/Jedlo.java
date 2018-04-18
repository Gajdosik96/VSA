/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsa;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Viktor
 */
@XmlRootElement
public class Jedlo {
    
    private String nazov;
    private double cena;
    
    public Jedlo()
    {
        
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
    
    
    
}
