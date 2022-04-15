/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.ei6;

import java.util.List;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

/**
 *
 * @author booth10-mgr2
 */
@Startup
@Singleton
public class Participants implements ParticipantsRemote {

   @PersistenceUnit(unitName="exercicePU")
    private EntityManagerFactory emf;


    @Override
    public List<Personne> getParticipants() {
       
      EntityManager em = emf.createEntityManager();
          
      List<Personne> retval = em.createQuery("SELECT p FROM Personne p").getResultList();
  
      em.close();
        
       return retval;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void ajoute(String prenom, String nom, String mail) {
        Personne pers= new Personne(prenom,nom,mail);
          
        EntityManager em = emf.createEntityManager();
    
        em.getTransaction().begin();
        try {
            em.persist(pers);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
