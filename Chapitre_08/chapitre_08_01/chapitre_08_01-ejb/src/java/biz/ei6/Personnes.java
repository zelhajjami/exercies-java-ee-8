/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.ei6;

import javax.ejb.Stateless;

/**
 *
 * @author booth10-mgr2
 */
@Stateless
public class Personnes implements PersonnesRemote {

    @Override
    public String getInfos() {
        return "Formation LinkedIn Learning";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
