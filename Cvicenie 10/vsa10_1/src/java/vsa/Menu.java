/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Singleton;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Viktor
 */
@Path("menu")
@Singleton
public class Menu {

    @Context
    private UriInfo context;

    private HashMap<Integer,Jedlo> jedla = new HashMap<Integer,Jedlo>();
    /**
     * Creates a new instance of Menu
     */
    public Menu() {
        Jedlo j = new Jedlo();
        j.setCena(55.4);
        j.setNazov("Brav");
        jedla.put(0, j);
    }

    /**
     * Retrieves representation of an instance of vsa.Menu
     * @return an instance of java.lang.String
     */
    @GET  
    @Produces(MediaType.TEXT_PLAIN)
    public String getText() {
        //TODO return proper representation object
        return "serus";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/{id: [0-9].*}")
    public Jedlo getJedno(@PathParam("id") int id){
        return jedla.get(id);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    @Path("/{id: [0-9].*}")
    public Jedlo getJedno(@PathParam("id") int id,Jedlo jed){
        Jedlo jedlo = null;
        if(jedla.containsKey(id))
        {
            jedla.put(id, jed);
            jedlo = jed;
        } else {
            jedla.put(id, jed);
        }
        return jedlo;
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_XML)
    @Path("/{id: [0-9].*}")
    public Jedlo delJedno(@PathParam("id") int id,Jedlo jed){
        Jedlo jedlo = null;
        if(id < jedla.size())
        {
            jedlo = jedla.get(id);
            jedla.remove(id);
        }
        return jedlo;
    }
    
    /**
     * PUT method for updating or creating an instance of Menu
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void putXml(String content) {
    }
}
