/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

/**
 * REST Web Service
 *
 * @author Viktor
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of rest.GenericResource
     * @return an instance of java.lang.String
     */
    // Skuste v browseri: http://localhost:8080/vsa9_1/webresources/generic
    @GET
    @Produces("text/plain")
    public String getText() {
        return "toto je root";
    }

    // Skuste v browseri: http://localhost:8080/vsa9_1/webresources/generic/child
    @GET
    @Path("/child")
    @Produces("text/plain")
    public String getChild() {
        //TODO return proper representation object
        return "Janko";
    }

    // Skuste v browseri: http://localhost:8080/vsa9_1/webresources/generic/meno/Robo
    @GET
    @Path("meno/{name: [A-Z].*}")
    @Produces("text/plain")
    public String getName(@PathParam("name") String name) {
        //TODO return proper representation object
        return "Ahoj " + name;
    }

    // Skuste v browseri: http://localhost:8080/vsa9_1/webresources/generic/par?meno=Jano
    @GET
    @Path("par")
    @Produces("text/plain")
    public String getParName(@QueryParam("meno") String name) {
        //TODO return proper representation object
        return "Hello " + name;
    }
    
    // Skuste v browseri: http://localhost:8080/vsa9_1/webresources/generic/num?cislo=333
    @GET
    @Path("/num")
    @Produces("text/plain")
    public String getText(@DefaultValue("1111") @QueryParam("cislo") int num) {
        //TODO return proper representation object
        return "poslali ste cislo " + num;
    }

    
    // Skuste v browseri: http://localhost:8080/vsa9_1/webresources/generic/hlavicka
    @GET
    @Path("hlavicka")
    @Produces("text/html")
    public String getHeader(@Context HttpHeaders hh) {
        MultivaluedMap<String, String> headerParams = hh.getRequestHeaders();
        //Map<String, Cookie> pathParams = hh.getCookies();
        String resp = "";
        for(String key : headerParams.keySet()) {
            resp = resp + key + " = " + headerParams.getFirst(key) + "<br/>";
        }
        return resp;
    }


    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/plain")
    public void putText(String content) {
    }
}
