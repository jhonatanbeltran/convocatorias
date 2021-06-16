<%-- 
    Document   : error
    Created on : 21/10/2020, 08:18:58 PM
    Author     : german
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body class="bg-dark">
        <h1 style="color: red; width: 250%;">ERROR!!!!!</h1>
        <%
        String editar=(String)(request.getSession().getAttribute("editar"));
       
        %>
        
        
        <p>
            <%=editar%>
            
        </p>
        <a href='CerrarSesionServlet'>Cerrar sesión</a>
    </body>
</html>
