/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.ei6.beans;

import java.net.URI;
import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
/**
 *
 * @author booth10-mgr2
 */

@ClientEndpoint
public class WebsocketClient {
     private Session session;
    private Personnes.Personne p;
    private final String uri="ws://localhost:8080/chapitre_07_03/infos";
    
   public WebsocketClient(Personnes.Personne p){
    this.p=p;
      try{
         WebSocketContainer container=ContainerProvider.getWebSocketContainer();
         container.connectToServer(this, new URI(uri));

      }catch(Exception ex){
            System.out.println("Erreur "+ex);
      }
   }

   @OnOpen
   public void onOpen(Session session){
      this.session=session;
   }

   @OnMessage
   public void onMessage(String message, Session session){
      p.setMail(message);
       System.out.println("message "+message);
   } 
   
   public void sendMessage(String message){
      try {
         session.getBasicRemote().sendText(message);
      } catch (Exception ex) {
        System.out.println("Erreur send message"+ex);      
      }
   }
}
