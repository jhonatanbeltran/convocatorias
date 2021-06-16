<%-- 
    Document   : Crearbeca
    Created on : 20/05/2021, 03:23:24 PM
    Author     : german
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css"/>
        <title>CREAR BECA</title>
    </head>
    <body class="bg-success">
        <div class="jumbotron bg-light">
  <h1 class="display-4 text-muted">Sigue Creciendo!</h1>
  <h2 class="lead text-capitalize font-weight-bold">"La educacion es nuestro pasaporte para el futuro, porque el manana pertenece a la gente que se prepara para el hoy".-Malcolm X.</h2>
 <%
 String codBeca=request.getParameter("user"); 
 %>
  <p class="lead">
   <ul class="nav">
  <li class="nav-item">
    <a class="nav-link text-primary" href="../Volver?name=0&idUser=<%=codBeca%>">Regresar</a>
  </li>
</ul>
  
</div>
        <div class="container">
            <br>
            <div class="container" style="max-width: 650px; min-width: 400px;">
                <div class="card">
                    <h2 class="card-header text-center">formulario de Registro</h2>
                    <div class="card-body">
                        <form id="myForm" action="../CrearBeca" method="post">
                            <div class="form-group">
                                <legend>Crear Beca</legend>
                                <label for="codigoB">CODIGO BECA</label>
                                <input type="number" class="form-control" id="codigoB" name="codigoB" placeholder="codigo beca" required>
                                <label for="beca_nombre">Nombre Beca</label>
                                <input type="text" class="form-control" id="beca_nombre" name="beca_nombre" placeholder="nombre beca" required>
                                <label for="descripcion">Descripcion de la Beca</label>
                                <br>  
                                <textarea class="form-control" id="descripcion" name="descripcion" placeholder="describe la beca" rows="4" cols="50" required>
              

                                </textarea>


                                <label for="Rubro"> Rubro</label>
                                <input type="text" class="form-control" id="Rubro" name="Rubro" placeholder="Rubro" required>
                                <label for="fechaI">Fecha Inicio</label>
                                <input type="date" class="form-control" id="fechaI" name="fechaI" required>
                                <label for="fechaC">Fecha Cierre</label>
                                <input type="date" class="form-control" id="fechaC" name="fechaC" required>
                                <br>
                                <label for="requisitos"> REQUISITOS</label>
                                <br>  
                                <textarea class="form-control" id="requisitos" name="requisitos" placeholder="requisitos de la beca" rows="4" cols="50" required>
              

                                </textarea>





                            </div>
                            <br/>

                            <input type="submit" class="btn btn-success" id="boton" value="Registrar">
                            
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
