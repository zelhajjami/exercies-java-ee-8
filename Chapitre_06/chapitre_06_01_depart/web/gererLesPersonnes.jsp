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
        <link href="//cdn.muicss.com/mui-0.9.39/css/mui.min.css" rel="stylesheet" type="text/css" />
        <script src="//cdn.muicss.com/mui-0.9.39/js/mui.min.js"></script>
    </head>
    <body>

        <jsp:useBean class="biz.ei6.Personne" id="utilisateur" scope="session" />

        <div class="mui-container">
            <div class="mui-panel">
                <h1>Utilisateur connecté : ${utilisateur["nomComplet"]}</h1>

                <c:choose>
                    <c:when test="${pageContext.request.method=='GET'}">
                        <table class="mui-table mui-table--bordered">
                            <tr><th>Prénom</th><th>Nom</th></tr>
                                    <c:forEach items="${noms}" var="personne">
                                <tr>
                                    <td>${personne.key}</td>
                                    <td>${personne.value}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:when>
                    <c:otherwise>
                        <div>Enregistrement bien pris en compte</div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </body>
</html>
