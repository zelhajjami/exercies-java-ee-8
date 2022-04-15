<%-- 
    Document   : gererLesPersonnes
    Created on : 19 juil. 2018, 12:31:34
    Author     : booth10-mgr2
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Locale"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page isELIgnored="false"%>

<jsp:include page="entete.html" />

<!--
pageScope
requestScope
sessionScope
applicationScope
param
paramValues
header
headerValues
initParam
cookie
pageContext
-->

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${formation}</title>
    </head>
    <body>
        ${sessionScope.utilisateur.nomComplet}
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
        //request.setAttribute("cookieNom",cookieNom);
        %>
         <h1>Utilisateur connecté : ${utilisateur["nomComplet"]}</h1>
         <h2><%=aujourdhui()%></h2>
         <h2>${cookie["login"].value}</h2>
         
        <%
            if (request.getMethod().equals("GET")) {
            
        %>    
          <table>
            <tr><th><%=prenomTitre%></th><th><%=nomTitre%></th></tr>
            
            <c:forEach items="${noms}" var="personne">
            <tr>
                <td>${personne.key}</td>
                <td>${personne.value}</td>
            </tr>
            </c:forEach>
            
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
