/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.ei6.beans;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author booth10-mgr2
 */
@Named("personnes")
@ApplicationScoped
public class Personnes {
    static List<Personne> noms = new ArrayList<>();
    public List<Personne> getNoms() {
        return noms;
    }
     
    static {
        
        noms.add(new Personne("Fabien", "Brissonneau"));
        noms.add(new Personne("Corinne", "Bazin"));
        noms.add(new Personne("Michel", "Lefaucheur"));
        noms.add(new Personne("Marie", "Bazin"));
        
    }
       public static class Personne {
        String nom;
        String prenom;
        
        public String getNom() {
            return nom;
        }
        public String getPrenom() {
            return prenom;
        }
        Personne(String p, String n) {
            prenom=p;
            nom=n;
        }
    }
}
