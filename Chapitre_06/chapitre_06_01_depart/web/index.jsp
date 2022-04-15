<%-- 
    Document   : index
    Created on : 20 juil. 2018, 15:30:57
    Author     : booth10-mgr2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="entete.html" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="//cdn.muicss.com/mui-0.9.39/css/mui.min.css" rel="stylesheet" type="text/css" />
        <script src="//cdn.muicss.com/mui-0.9.39/js/mui.min.js"></script>
    </head>
    <body>
        <div class="mui-container">
            <div class="mui-panel">
                 <a href="ListerLesPersonnes">Liste des personnes concernées par le tirage</a>
            </div>
            <div class="mui-panel">
                 Créer une nouvelle personne à mettre dans la liste
                <form class="mui-form" action="CreerUnePersonne" method="POST">
                      <div class="mui-textfield">
                    <input type="text" name="prenom" value="le prénom"/>
                      </div>
                      <div class="mui-textfield">
                    <input type="text" name="nom" value="le nom"/>
                      </div>
                       <button  class="mui-btn mui-btn--raised" type="submit" >Créer</button>
                </form>
            </div>
    </body>
</html>
