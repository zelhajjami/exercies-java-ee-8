<%-- 
    Document   : login
    Created on : 19 juil. 2018, 11:34:15
    Author     : booth10-mgr2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <h1>Vérification de l'utilisateur</h1>
        <%
            if (verifie(request.getParameter("login"),request.getParameter("password"))) {

            getServletContext().setAttribute("pn1", "Fabien");
            getServletContext().setAttribute("n1", "Brissonneau");
            getServletContext().setAttribute("pn2", "Corinne");
            getServletContext().setAttribute("n2", "Bazin");
            getServletContext().setAttribute("pn3", "Michel");
            getServletContext().setAttribute("n3", "Lefaucheur");
            getServletContext().setAttribute("pn4", "Marie");
            getServletContext().setAttribute("n4", "Bazin");

            request.getSession().setAttribute("utilisateur", "Fabien Brissonneau");
                    
            RequestDispatcher rs = request.getRequestDispatcher("index.html");
            rs.forward(request, response);
        } else {
        %>
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
