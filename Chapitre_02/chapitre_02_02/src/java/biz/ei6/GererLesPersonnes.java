/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.ei6;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author booth10-mgr2
 */
public class GererLesPersonnes extends HttpServlet {

  

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
             response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Liste des personnes à prendre en compte</title>");            
            out.println("</head>");
            out.println("<body>");
           
            out.println("<table>");
            
            out.println("<tr>"); 
            out.println("<th>Prénom</th>");
            out.println("<th>Nom</th>");
            out.println("</tr>");
            
            out.println("<tr>"); 
            out.println("<td>Fabien</td>");
            out.println("<td>Brissonneau</td>");

            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Corinne</td>");
            out.println("<td>Bazin</td>");

            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Michel</td>");
            out.println("<td>Lefaucheur</td>");
     
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Marie</td>");
            out.println("<td>Bazin</td>");

            out.println("</tr>");
            out.println("</table>");
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Liste des personnes à prendre en compte</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("Enregistrement bien pris en compte");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
