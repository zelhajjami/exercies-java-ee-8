/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.ei6;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author booth10-mgr2
 */
@Stateless
public class Participants implements ParticipantsRemote {

    @Override
    public List<Personne> getParticipants() {
       List<Personne> retval = new ArrayList<>() ;
        
        retval.add(new Personne("Fabien","Brissonneau","fabien.brissonneau@gmail.com"));
        retval.add(new Personne("Corinne","Bazin","corinne.bazin@gmail.com"));
        retval.add(new Personne("Léna","Brissonneau","sans"));
        
        return retval;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
