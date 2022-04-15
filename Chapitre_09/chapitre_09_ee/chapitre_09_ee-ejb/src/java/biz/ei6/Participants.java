/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.ei6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author booth10-mgr2
 */
@Startup
@Singleton
public class Participants implements ParticipantsRemote {

    @Resource(lookup = "jdbc/participantsDS")
    private DataSource dataSource;

    @PostConstruct
    public void init() {
        System.out.println("initialisation de bean");

        try (Connection connexion = dataSource.getConnection();) {

            PreparedStatement ps = connexion.prepareStatement("CREATE TABLE  participants("
                    + "                                             PERSON_ID INT NOT NULL GENERATED ALWAYS AS IDENTITY\n"
                    + "	CONSTRAINT ID_PK PRIMARY KEY, prenom VARCHAR(255), nom VARCHAR(255), mail VARCHAR(255))");
            ps.executeUpdate();
            ps.close();
            System.out.println("init et connecté");

        } catch (SQLException ex) {
            Logger.getLogger(Participants.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<Personne> getParticipants() {

        System.out.println("getparticipants");
        List<Personne> retval = new ArrayList<>();
        try (Connection connexion = dataSource.getConnection();) {

            PreparedStatement ps = connexion.prepareStatement("SELECT prenom, nom, mail FROM participants");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Personne p = new Personne(rs.getString("prenom"), rs.getString("nom"), rs.getString("mail"));
                retval.add(p);
            }

            ps.close();
        } catch (Exception ex) {
            Logger.getLogger(Participants.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retval;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void ajoute(String prenom, String nom, String mail) {
        System.out.println("ajoute " + prenom + ", " + nom);
        try (Connection connexion = dataSource.getConnection();) {

            PreparedStatement ps = connexion.prepareStatement("INSERT INTO participants(prenom, nom , mail ) VALUES(?,?,?)");
            ps.setString(1, prenom);
            ps.setString(2, nom);
            ps.setString(3, mail);

            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            Logger.getLogger(Participants.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
