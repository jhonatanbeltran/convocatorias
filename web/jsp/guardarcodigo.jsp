<%-- 
    Document   : guardarcodigo
    Created on : 20/05/2021, 09:52:55 PM
    Author     : german
--%>

<%@page import="DTO.Administrador"%>
<%@page import="DTO.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <body>
        <h1>Hello World!</h1>
        
         <table border="1">
<tr>
<td>id</td>
<td>nombre</td>
<td>apellido</td>
<td>correo</td>
</tr>
        <%
              Administrador editar=(Administrador)(request.getSession().getAttribute("Usuario"));
           
//LinkedList<Contacto> lista = ConsultaAgenda.getContactos();
//for (int i=0;i<lista.size();i++)
//{

   out.println("<tr>");
   out.println("<td>"+editar.getCedula()+"</td>");
   out.println("<td>"+editar.getPrimerNombre()+"</td>");
   out.println("<td>"+editar.getPrimerApellido()+"</td>");
   out.println("<td>"+editar.getCorreoElectronico()+"</td>");
   out.println("</tr>");
//}

%>
</table>
    </body>
</html>
