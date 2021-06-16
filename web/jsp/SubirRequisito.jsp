<%-- 
    Document   : SubirRequisito
    Created on : 24/05/2021, 11:02:43 AM
    Author     : german
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <%
        String codBeca=(String)request.getSession().getAttribute("user");
        String codAplicante=(String)request.getSession().getAttribute("codAplicante");%>
        <title>JSP Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css"/>
    </head>
     <body class="bg-success">
       <div class="jumbotron bg-light">
  <h1 class="display-4 text-muted">Sigue Creciendo!</h1>
  <h2 class="lead text-capitalize font-weight-bold">"La educacion es nuestro pasaporte para el futuro, porque el manana pertenece a la gente que se prepara para el hoy".-Malcolm X.</h2>
 
  <p class="lead">
   <ul class="nav">
  <li class="nav-item">
    <a class="nav-link text-primary" href="VerBecas?id=<%=codAplicante%>">Salir</a>
  </li>
</ul>  
</div>
         <div class="main-bg ">
 
              <div class="container">
    <div class="row justify-content-center mt-5">
      <div class="col-lg-4 col-md-6 col-sm-6">
        <div class="card shadow">
          <div class="card-title text-center border-bottom">
            <h2 class="p-3">Subir Archivo</h2>
          </div>
          <div class="card-body">
            <form action="SubirRequisito?idB=<%=codBeca%>&idA=<%=codAplicante%>" method="post" enctype="multipart/form-data">
              <div class="mb-4">
                <label  class="form-label">Suba los requisitos en un solo archivo comprimido y por nombre debe llevar su documento</label>            
              </div>
              <div class="mb-4">
                <input class="form-control" name="file" type="file" placeholder="Ingresa una imagen" />
              </div>
              <div>
               <select class="form-select" aria-label="Default select example" name="estado">
                 <option value="enviado">Enviar</option>
                 <option value="pendiente">Solo Guardar</option>
                </select>
                  <br>
                  <br>
                  <br>
                  <br>
              </div>
              <div class="d-grid">
                  <button class="btn btn-success" name="action" value="add">Subir y volver a inicio</button>
              <!--  <button type="submit" class="btn text-light main-bg">Login</button>-->
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
