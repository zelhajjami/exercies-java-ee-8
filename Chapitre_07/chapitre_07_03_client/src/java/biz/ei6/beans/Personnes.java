/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.ei6.beans;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
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

        getInfos();

        return noms;
    }

      private String getMail(final Personne p) {
          String mail="";
       
          WebsocketClient wb = new WebsocketClient(p);
          wb.sendMessage(p.getPrenom());
          
        return mail;
    }
      
    private void getInfos() {
        noms.clear();
        try {
            URL urlWs = new URL("http://localhost:8080/chapitre_07_02/rest/personnes/");

            URLConnection c = urlWs.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
            String inputLine = in.readLine();
            in.close();

            JsonParser parser = new JsonParser();

            JsonArray tableau = parser.parse(inputLine).getAsJsonArray();

            for (JsonElement jo : tableau) {
                JsonObject p = jo.getAsJsonObject();
                Personne personne = new Personne(p.get("prenom").getAsString(), p.get("nom").getAsString());
                noms.add(personne);
                
                 personne.setMail(getMail(personne));
            }

        } catch (Exception io) {
            System.out.println("Erreur dans la récupération des données");
        }
    }

    public static class Personne {

        String nom;
        String prenom;
        String mail;
        
        public String getMail() {
            return mail;
        }
        
        public String getNom() {
            return nom;
        }

        public String getPrenom() {
            return prenom;
        }

         public void setMail(String str) {
            mail=str;
            
        }
         
        Personne(String p, String n) {
            prenom = p;
            nom = n;
        }
    }
}
