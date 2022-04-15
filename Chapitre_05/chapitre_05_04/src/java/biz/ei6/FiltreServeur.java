/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.ei6;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author booth10-mgr2
 */
public class FiltreServeur implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        PrintWriter out = response.getWriter();
        
        out.println("Filtre actif <br/>");
        
        chain.doFilter(request, response);
        
        
        out.print("Nom du serveur "+request.getServerName()+"<br/>");
        out.print("Port sur le serveur "+request.getServerPort()+"<br/>");
    }
    
}
