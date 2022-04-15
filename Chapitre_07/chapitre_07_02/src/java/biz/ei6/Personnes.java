/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.ei6;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author booth10-mgr2
 */

@Path("/personnes")
public class Personnes {
    static List<Personne> lesPersonnes= new ArrayList<>();
    
    @GET
    public List<Personne> getPersonnes() {
        System.out.println("GET les personnes");
        return lesPersonnes;
    }
    
    @POST
    public void ajouteUnePersonne(@FormParam("prenom")String prenom, @FormParam("nom")String nom) {
        lesPersonnes.add(new Personne(prenom,nom));
        System.out.println("Post personne "+prenom+" , "+nom+" size "+lesPersonnes.size());
    }
}
