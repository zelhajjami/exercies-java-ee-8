/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.ei6.beans;


import biz.ei6.ParticipantsRemote;
import biz.ei6.PersonnesRemote;
import javax.inject.Named;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author booth10-mgr2
 */
@Named("utilisateur")
@SessionScoped
public class Utilisateur implements Serializable{

    @EJB
    private PersonnesRemote personnes;

	private static final long serialVersionUID = 1L;
        
        private String login = "fabien6668";
        private String password = "x";
        
        
        
        public String verifie() {
            if(login.equals("fabien6668") && password.equals("x"))
                return "listerLesPersonnes";    
            else
                return "login";
        }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getInfos() {
        return personnes.getInfos();
    }
}
