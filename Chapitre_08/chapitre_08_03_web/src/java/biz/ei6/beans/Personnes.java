/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.ei6.beans;

import biz.ei6.ParticipantsRemote;
import biz.ei6.Personne;
import java.util.ArrayList;
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
        return participants.getParticipants();
    }
     
    
   
}
