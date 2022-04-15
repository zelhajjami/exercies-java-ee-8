/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.ei6;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;


/**
 *
 * @author booth10-mgr2
 */
@Stateless
public class Participants implements ParticipantsRemote {
 
 List<Personne> retval;
 
    @PostConstruct
    public void init() {
        retval = new ArrayList<>() ;
        retval.add(new Personne("Fabien","Brissonneau","fabien.brissonneau@gmail.com"));
        retval.add(new Personne("Corinne","Bazin","corinne.bazin@gmail.com"));
        retval.add(new Personne("Léna","Brissonneau","sans"));
        
        
    }
    @Override
    public List<Personne> getParticipants() {
     
         System.out.println("getparticipants");
           return retval;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void ajoute(String prenom, String nom, String mail) {
        System.out.println("ajoute "+prenom+ ", "+nom);
       retval.add(new Personne(prenom, nom, mail));
    }
}
