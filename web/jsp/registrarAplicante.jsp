<%-- 
    Document   : newjsp
    Created on : 19/05/2021, 01:57:21 PM
    Author     : german
--%>

<%@page import="DTO.Administrador"%>
<%@page import="DAO.AdministradorJpaController"%>
<%@page import="DAO.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="../css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <link rel="stylesheet" href="../css/style.css"/>
    </head>
   <body class="bg-success">
        <div class="jumbotron bg-light">
  <h1 class="display-4 text-muted">Sigue Creciendo!</h1>
  <h2 class="lead text-capitalize font-weight-bold">"La educacion es nuestro pasaporte para el futuro, porque el manana pertenece a la gente que se prepara para el hoy".-Malcolm X.</h2>
 
  <p class="lead">
   <ul class="nav">
  <li class="nav-item">
    <a class="nav-link text-primary" href="../index.html">Regresar</a>
  </li>
</ul>
 
  
</div>
        <div class="container">
           
        <br>
<div class="container" style="max-width: 650px; min-width: 400px;">
  <div class="card">
    <h2 class="card-header text-center">formulario de Registro</h2>
    <div class="card-body">
      <form id="myForm" action="../NuevoAplicante2" method="post">
        <div class="form-group">
          <legend>Datos de la Cuenta</legend>
          <label for="cedula">Cedula</label>
          <input type="number" class="form-control" id="cedula" name="cedula" placeholder="Cedula" required>
          <label for="primer_nom">Primer Nombre</label>
          <input type="text" class="form-control" id="primer_nom" name="primerN" placeholder="primer nombre" required>
          <label for="segundo_nom">Segundo Nombre</label>
          <input type="text" class="form-control" id="segundo_nom" name="segundoN" placeholder="segundo nombre" required>
          <label for="primer_ape">Primer Apellido</label>
          <input type="text" class="form-control" id="primer_ape" name="primerA" placeholder="primer apellido" required>
          <label for="segundo_ape">Segundo Apellido</label>
          <input type="text" class="form-control" id="segundo_ape" name="segundA" placeholder="segundo apellido" required>
          <label for="fecha">Fecha Nacimiento</label>
          <input type="date" class="form-control" id="fecha" name="fecha" required>
          <label for="celular">Numero Celular</label>
          <input type="number" class="form-control" id="celular" name="celular" placeholder="numero celular" required>
          <label for="email">Correo Electronico:</label>
          <input type="email" class="form-control" id="email" name="email" placeholder="nombre@ejemplo.com" required>
          <label for="Pass">Contraseña:</label>
          <input type="password" class="form-control" id="pass" name="pass" placeholder="Contraseña" required>
          
         
        </div>
          <br/>
        
        <input type="submit" class="btn btn-success" id="boton" value="Registrar">
        <input type="reset" class="btn btn-danger" id="boton" value="Reiniciar">
      </form>
    </div>
  </div>
</div>      </div>
    </body>
    <script src="../js/validar.js" />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>

</html>
