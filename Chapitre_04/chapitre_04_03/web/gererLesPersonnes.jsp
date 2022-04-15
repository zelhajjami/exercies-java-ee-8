<%-- 
    Document   : gererLesPersonnes
    Created on : 19 juil. 2018, 12:31:34
    Author     : booth10-mgr2
--%>

<%@page import="java.util.Locale"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="entete.html" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= config.getInitParameter("formation")%></title>
    </head>
    <body>
        <jsp:useBean class="biz.ei6.Personne" id="utilisateur" scope="session" />
        <%! 
            String prenomTitre="Prénom";
            String nomTitre="Nom";
            
            String aujourdhui() {
                LocalDate ld = LocalDate.now();
                return ld.format(DateTimeFormatter.ofPattern("dd MM yyyy", Locale.FRANCE));
            }
        
            String cookieNom ="";
        %>
        
        <%
        Cookie[] cks = request.getCookies();
        if(cks !=null){
            for(Cookie ck : cks) {
                if(ck.getName().equals("login")) {
                    cookieNom = ck.getValue();
                }
            }
        }
        %>
         <h1>Utilisateur connecté : <%= utilisateur.getNomComplet() %></h1>
         <h2><%=aujourdhui()%></h2>
         <h2><%=cookieNom%></h2>
         
        <%
            if (request.getMethod().equals("GET")) {
            
        %>    
          <table>
            <tr><th><%=prenomTitre%></th><th><%=nomTitre%></th></tr>
            <tr>
                <td><%=application.getAttribute("pn1")%></td>
                <td><%=application.getAttribute("n1")%></td>
            </tr>
            <tr>
                <td><%=application.getAttribute("pn2")%></td>
                <td><%=application.getAttribute("n2")%></td>
            </tr>
            <tr>
                <td><%=application.getAttribute("pn3")%></td>
                <td><%=application.getAttribute("n3")%></td>
            </tr>
            <tr>
                <td><%=application.getAttribute("pn4")%></td>
                <td><%=application.getAttribute("n4")%></td>
            </tr>
          </table>
         <%       
            } else {
         %>
         <div>Enregistrement bien pris en compte</div>
         <%
             }
         %>
    </body>
</html>
