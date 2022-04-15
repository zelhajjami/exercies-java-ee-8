<%-- 
    Document   : login
    Created on : 19 juil. 2018, 11:34:15
    Author     : booth10-mgr2
--%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="entete.html" />

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <%!
           boolean verifie(String login, String password) {
            return (login!=null && login.equals("fabien6668")
                && password!=null && password.equals("moncomptetwitter"));
        }
     %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login JSP Page</title>
    </head>
    <body>
        <jsp:useBean class="biz.ei6.Personne" id="utilisateur" scope="session" />
        <jsp:setProperty name="utilisateur" property="*"/>
        
        <c:set var="compteur" value="42"/>
         
        <h1>Vérification de l'utilisateur</h1>
        <%
            if (utilisateur.verifie()) {

            Map<String, String> lesNoms = new HashMap<>();
   
            lesNoms.put( "Fabien", "Brissonneau");
            lesNoms.put("Corinne", "Bazin");
            lesNoms.put("Michel", "Lefaucheur");
            lesNoms.put("Marie", "Bazin");
            
            application.setAttribute("noms", lesNoms);

            
            Cookie ck = new Cookie("login",utilisateur.getNomComplet());
            response.addCookie(ck);
            
        %>
        
        <jsp:forward page="index.html"/>
        
        <%} else {
        %>
        Nombre d'utilisateurs <%=application.getAttribute("nbUtilisateurs")%>
        
         <div>Dis moi si tu as le droit de passer ici ...</div>
        <form action="login.jsp" method="POST">
            <input type="text" name="login" value="fabien6668"/>
            <input type="text" name="password" value="moncomptetwitter"/>
            <input type="submit"/>
        </form>
        <%
            }
        %>
    </body>
</html>
