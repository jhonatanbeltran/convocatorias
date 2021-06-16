<%-- 
    Document   : Crearbeca
    Created on : 20/05/2021, 03:23:24 PM
    Author     : german
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="DTO.Becaa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
          <%
        Becaa editar=(Becaa)(request.getSession().getAttribute("user"));
        String codAplicante=(String)request.getSession().getAttribute("codAplicante");
            int codB=editar.getCodigoBeca();
           String nombreB=editar.getNombre();
           String descripcion=editar.getDescripcion();
           String rubro=editar.getRubro();
           Date fechaI =editar.getFechaInicio();
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String ini= sdf.format(fechaI);
           Date fechaF =editar.getFechaCierre();
            String fin= sdf.format(fechaF);
           Date fechar =editar.getFechaRegistro();
            String registrada= sdf.format(fechar);
            String requisitos =editar.getRequisitos();
            String estado=editar.getEstado();
        %>
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
 
  <p class="lead">
   <ul class="nav">
  <li class="nav-item">
    <a class="nav-link text-primary" href="VerBecas?id=<%=codAplicante%>">Regresar</a>
  </li>
</ul>
  
</div>
        <div class="container">
            <br>
            <div class="container" style="max-width: 650px; min-width: 400px;">
                <div class="card">
                    <h2 class="card-header text-center">formulario de Registro</h2>
                    <div class="card-body">

           <!-- <input type="number" class="form-control" name="txtNombre" value=<%=codB%> >-->
                        <form id="myForm" action="AplicarBercas?idB=<%=codB%>&idA=<%=codAplicante%>"  method="post" enctype="multipart/form-data">
                            <div class="form-group">
                                <legend>Crear Beca</legend>
                                <label for="codigoB">CODIGO BECA</label>
                                <label class="form-control" id="codigoB" name="codigoB"  value=<%=codB%>><%=codB%></label>
                                
                                <label for="beca_nombre">Nombre Beca</label>
                                <label class="form-control" id="beca_nombre" name="beca_nombre"  ><%=nombreB%></label>
                                <label for="descripcion">Descripcion de la Beca</label>
                                <br>  
                                <textarea class="form-control" id="descripcion" name="descripcion"  rows="4" cols="50" disabled><%=descripcion%></textarea>
                                <label for="Rubro"> Rubro</label>
                                <label class="form-control" id="Rubro" name="Rubro" ><%=rubro%></label>
                                
                                <label for="fechaI">Fecha Inicio</label>
                                <label class="form-control" id="fechaI" name="fechaI" ><%=ini%></label>
                                <label for="fechaC">Fecha Cierre</label>
                                <label class="form-control" id="fechaC" name="fechaC" ><%=fin%></label>
                                <br>
                                <label for="fechaC">Convocatoria Creada</label>
                                <label class="form-control" id="fechar" name="fechar" ><%=registrada%></label>
                                <br>
                                <label for="fechaC">Estado de laConvocatoria</label>
                                <label class="form-control" id="estado" name="estado" ><%=estado%></label>
                                <br>
                                <label for="requisitos"> REQUISITOS</label>
                                <br>  
                                <textarea class="form-control" id="requisitos" name="requisitos"  rows="4" cols="50" disabled><%=requisitos%></textarea>
                                <br>
                                
                            </div>
                          
                            <input type="submit" class="btn btn-success" id="boton" value="SUBIR REQUISITOS">
                            

                            
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
