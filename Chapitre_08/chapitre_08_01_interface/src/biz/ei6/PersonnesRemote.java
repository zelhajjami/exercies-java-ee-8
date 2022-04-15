/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.ei6;

import javax.ejb.Remote;

/**
 *
 * @author booth10-mgr2
 */
@Remote
public interface PersonnesRemote {

    String getInfos();
    
}
