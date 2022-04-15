/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.ei6;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author booth10-mgr2
 */
@Remote
public interface ParticipantsRemote {

    void ajoute(String prenom, String nom, String mail);

    List<Personne> getParticipants();
    
}
