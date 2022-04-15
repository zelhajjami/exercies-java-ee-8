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
            return (login != null && login.equals("fabien6668")
                    && password != null && password.equals("moncomptetwitter"));
        }
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login JSP Page</title>
        <link href="//cdn.muicss.com/mui-0.9.39/css/mui.min.css" rel="stylesheet" type="text/css" />
        <script src="//cdn.muicss.com/mui-0.9.39/js/mui.min.js"></script>
    </head>
    <body>
        <jsp:useBean class="biz.ei6.Personne" id="utilisateur" scope="session" />
        <jsp:setProperty name="utilisateur" property="*"/>

        <div class="mui-container mui--text-center">
            <h1>Vérification de l'utilisateur</h1>

            <c:if test="${utilisateur.verifie()}">


                <%
                    Map<String, String> lesNoms = new HashMap<>();

                    lesNoms.put("Fabien", "Brissonneau");
                    lesNoms.put("Corinne", "Bazin");
                    lesNoms.put("Michel", "Lefaucheur");
                    lesNoms.put("Marie", "Bazin");

                    application.setAttribute("noms", lesNoms);

                    Cookie ck = new Cookie("login", utilisateur.getNomComplet());
                    response.addCookie(ck);

                %>

                <jsp:forward page="index.jsp"/>

            </c:if>


            <div class="mui-container">
                <div class="mui-panel">
                    <div>Dis moi si tu as le droit de passer ici ...</div>
                    <form class="mui-form" action="login.jsp">
                        <div class="mui-textfield">
                            <input type="text" name="login" value="fabien6668"/>
                        </div>
                        <div class="mui-textfield">
                            <input type="text" name="password" value="moncomptetwitter"/>
                        </div>
                        <button  class="mui-btn mui-btn--raised" type="submit" >Login</button>
                    </form>
                </div>
            </div>

        </div>

    </body>
</html>
