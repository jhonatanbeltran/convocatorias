<%-- 
    Document   : InicioAdmin
    Created on : 20/05/2021, 07:33:36 AM
    Author     : german
--%>

<%@page import="DTO.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css"/>
    </head>
     <%
        Administrador editar=(Administrador)(request.getSession().getAttribute("user"));
       String saludo= "Hola! " + editar.getPrimerNombre() + " " + editar.getPrimerApellido();
       String codUser=("")+(editar.getCedula());
        %>
    <body class="bg-success">
  <div class="jumbotron bg-light">
  <h1 class="display-4 text-muted"> <%=saludo%>...</h1>
  <h2 class="lead text-capitalize font-weight-bold">"La educacion es nuestro pasaporte para el futuro, porque el manana pertenece a la gente que se prepara para el hoy".-Malcolm X.</h2>
 
  <p class="lead">
   <ul class="nav">
  <li class="nav-item">
    <a class="nav-link text-primary" href="#">Evaluar</a>
  </li>
  <li class="nav-item">
    <a class="nav-link text-primary" href="jsp/Crearbeca.jsp?user=<%=codUser%>">Registrar Beca</a>
  </li>
   <li class="nav-item">
    <a class="nav-link text-primary" href="CerrarSesionServlet">Cerrar Sesion</a>
  </li>
</ul>
  
    </div>
        
        <div class="main-bg ">
            <div class="container">
    <div class="row justify-content-center mt-5">
      <div class="col-lg-4 col-md-6 col-sm-6">
        <div class="card shadow">
          <div class="card-title text-center border-bottom">
            <h2 class="p-3">DATOS</h2>
          </div>
          <div class="card-body">
            <form >
                <%
                String nombres=  editar.getPrimerNombre() + " " + editar.getSegundoNombre();
                 String apellidos=  editar.getPrimerApellido() + " " + editar.getSegundoApellido();
                 String correo = editar.getCorreoElectronico();
                %>
              <div class="mb-4">
                <label for="nombres" class="form-label">Nombres</label>
                <br>
                <label   name="nombres" id="nombres" class="form-label"><%=nombres%></label>
              </div>
              <div class="mb-4">
                <label for="apellidos" class="form-label">Apellidos</label>
                <br>
                <label  name="apellidos" id="apellidos" class="form-label"><%=apellidos%></label>
               
              </div>
                <div class="mb-4">
                <label for="correo" class="form-label">Correo</label>
                <br>
                <label  name="correo" id="correo" class="form-label"><%=correo%></label>
               
              </div>
              
              
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
            
            
        </div>
        
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>

</html>
