/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.ei6.beans;


import biz.ei6.ParticipantsRemote;
import biz.ei6.Personne;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author booth10-mgr2
 */
@Named("personnes")
@ApplicationScoped
public class Personnes {

    @EJB
    private ParticipantsRemote participants;


  
    public List<Personne> getNoms() {
        List<Personne> liste = participants.getParticipants();
        System.out.println("Taille de la liste récupérée "+liste.size());
        
        return liste;
    }
     
    public void ajoute() {
        participants.ajoute(prenom, nom, mail);
    }
    
    
    private String nom;
    private String prenom;
    private String mail;

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }
   
}
