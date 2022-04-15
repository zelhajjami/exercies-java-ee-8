/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.ei6;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author booth10-mgr2
 */
@ServerEndpoint("/infos")
public class Utilisateur {
    
    @OnMessage
    public String getInfos(String prenom) {
        if(prenom.equalsIgnoreCase("fabien"))
            return "fabien.brissonneau@gmail.com";
        else
            return "";
    }
    
}
