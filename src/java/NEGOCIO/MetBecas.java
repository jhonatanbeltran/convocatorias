/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEGOCIO;

import DAO.BecaAplicanteJpaController;
import DAO.BecaaJpaController;
import DAO.Conexion;
import DTO.BecaAplicante;
import DTO.Becaa;
import java.io.Console;
import static java.lang.System.console;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author german
 */
public class MetBecas {

    private List<Becaa>becas;
    private List<BecaAplicante>becaapli;
    public MetBecas() {
         Conexion c=Conexion.getConexion();
          BecaaJpaController pl=new BecaaJpaController(c.getBd());
          this.becas=pl.findBecaaEntities();
          BecaAplicanteJpaController bec=new BecaAplicanteJpaController(c.getBd());
          this.becaapli=bec.findBecaAplicanteEntities();
    }
    
    public void prueba(BecaAplicante bec) throws Exception{
         //crear la conexion
        Conexion c=Conexion.getConexion();
        //llamar los metodos del jpa
       BecaAplicanteJpaController pl=new BecaAplicanteJpaController(c.getBd());
       //registrar el aplicante
        pl.create(bec);
        
       }
    
    //Registrar la beca
     public void RegistrarBecas(Becaa bec) throws Exception{
         //crear la conexion
        Conexion c=Conexion.getConexion();
        //llamar los metodos del jpa
       BecaaJpaController pl=new BecaaJpaController(c.getBd());
       //registrar la beca
        pl.create(bec);
       }
    
     public String getTablaBecas(int codAplicante) throws ParseException 
    {
        
        if(this.becas.isEmpty())
            return "No hay becas en la BD";
        
        String msg="      <li class='nav-item'>";
    
  msg+="\n  <a class='nav-link text-primary' href='Volver?name=1&idUser="+codAplicante+"'>Regresar</a>";
 msg+="\n </li>";
        
          msg+="\n   <li class='nav-item'>";
        msg+=" \n <a class='nav-link text-primary' href='CerrarSesionServlet'>Cerrar Sesion</a>";
        msg+="\n </li>";
        msg+="\n </ul>";
  
         msg+="\n </div>";
         msg+="\n  <div class='main-bg '>";
       msg+="\n    <div class='container'>";
      msg+="\n <h1>Lista de becas</h1>";
       
  msg+="\n   <table id='example' class='display nowrap' style'width:100%'>";
        msg+="\n <thead>";
          msg+="\n   <tr>";
            msg+="\n     <th>CODIGO</th>";
             msg+="\n    <th>NOMBRE</th>";
             
             msg+="\n    <th>ESTADO</th>";
              msg+="\n   <th> APERTURA</th>";
              msg+="\n   <th>CIERRE</th>";
               msg+="\n <th>ACCIONES </th>";
            msg+="\n </tr>";
        msg+="\n </thead>";
        msg+="\n <tbody>";
        
        
       for(Becaa pl:this.becas)
        {
            
        msg+="\n <tr>";
        msg+="\n <td>" + pl.getCodigoBeca()+ "</td>";
        msg+="\n <td>" + pl.getNombre()+ "</td>";
       
        msg+="\n <td>" + pl.getEstado()+ "</td>";
       Date inicio = pl.getFechaInicio();
       SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
       String ini= formateador.format(inicio);
       
        msg+="\n <td>" +ini + "</td>";
        Date cierre = pl.getFechaInicio();
       SimpleDateFormat formate= new SimpleDateFormat("dd-MM-yyyy");
       String cie= formate.format(cierre);
      
        msg+="\n <td>" + cie+ "</td>";
        int codigo=pl.getCodigoBeca();
       msg+="\n <td><a href='Aplicar?name="+codigo+"&name2="+codAplicante+"'>Aplicar</a></td>";
        msg+="\n </tr>";
        }
          
          
         msg+="  </tbody>";
           msg+="\n <tfood>";
          msg+="\n   <tr>";
            msg+="\n     <th>CODIGO</th>";
             msg+="\n    <th>NOMBRE</th>";
            
             msg+="\n    <th>ESTADO</th>";
              msg+="\n   <th> APERTURA</th>";
              msg+="\n   <th>CIERRE</th>";
               msg+="\n <th>ACCIONES </th>";
            msg+="\n </tr>";
        msg+="\n </tfood>";
         msg+="  </table>";
             msg+="<script>";
    msg+="$(document).ready(function() {";
        msg+="$('#example').DataTable( {";
            msg+="dom: 'Bfrtip',";
            msg+="buttons: [";
               msg+="'copy', 'csv', 'excel', 'pdf', 'print'";
            msg+="]";
        msg+="} );";
    msg+="} );";
msg+="</script>";
    return msg;
    }
      public String getTablaBecasInicio() throws ParseException 
    {
        if(this.becas.isEmpty())
            return "No hay becas en la BD";
        
   String msg="      <li class='nav-item'>";
  msg+="\n  <a class='nav-link text-primary' href='./index.html'>Regresar</a>";
 msg+="\n </li>";
        
       
 msg+="\n </ul>";
  
     msg+="\n </div>";
     msg+="\n  <div class='main-bg '>";
       msg+="\n<div class='container'>";
      msg+="\n <h1>Lista de becas</h1>";
       
        msg+="\n   <table id='example' class='display nowrap' style'width:100%'>";
        msg+="\n <thead>";
          msg+="\n   <tr>";
            msg+="\n     <th>CODIGO</th>";
             msg+="\n    <th>NOMBRE</th>";
             
             msg+="\n    <th>ESTADO</th>";
              msg+="\n   <th> APERTURA</th>";
              msg+="\n   <th>CIERRE</th>";
            msg+="\n </tr>";
        msg+="\n </thead>";
        msg+="\n <tbody>";
        
        
       for(Becaa pl:this.becas)
        {
         if(pl.getEstado().equals("Abierta")){   
        msg+="\n <tr>";
          
        msg+="\n <td>" + pl.getCodigoBeca()+ "</td>";
        msg+="\n <td>" + pl.getNombre()+ "</td>";
        
        msg+="\n <td>" + pl.getEstado()+ "</td>";
       Date inicio = pl.getFechaInicio();
       SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
       String ini= formateador.format(inicio);
       Date fechaI= formateador.parse(ini);
        msg+="\n <td>" +ini + "</td>";
        Date cierre = pl.getFechaInicio();
       SimpleDateFormat formate= new SimpleDateFormat("dd-MM-yyyy");
       String cie= formate.format(cierre);
       Date fechacie= formateador.parse(cie);
        msg+="\n <td>" + cie+ "</td>";
       
        msg+="\n </tr>";
         }
        }
          
          
         msg+="  </tbody>";
           msg+="\n <tfood>";
          msg+="\n   <tr>";
            msg+="\n     <th>CODIGO</th>";
             msg+="\n    <th>NOMBRE</th>";
            
             msg+="\n    <th>ESTADO</th>";
              msg+="\n   <th> APERTURA</th>";
              msg+="\n   <th>CIERRE</th>";
            msg+="\n </tr>";
        msg+="\n </tfood>";
         msg+="  </table>";
             msg+="<script>";
    msg+="$(document).ready(function() {";
        msg+="$('#example').DataTable( {";
            msg+="dom: 'Bfrtip',";
            msg+="buttons: [";
               msg+="'copy', 'csv', 'excel', 'pdf', 'print'";
            msg+="]";
        msg+="} );";
    msg+="} );";
msg+="</script>";
        
    return msg;
    }

      public Becaa getBeca(int id){
          Conexion c=Conexion.getConexion();
          BecaaJpaController pl=new BecaaJpaController(c.getBd());
         return pl.findBecaa(id);
      }
      
      
      public void RegistrarBecasAplicantes(BecaAplicante bec) throws Exception{
         //crear la conexion
        Conexion c=Conexion.getConexion();
        //llamar los metodos del jpa
       BecaAplicanteJpaController pl=new BecaAplicanteJpaController(c.getBd());
       //registrar el aplicante
        pl.create(bec);
       }
      
      //modificar para terminar este punto
      public String getTablaPendientes(int codAplicante) throws ParseException 
    { 
        if(this.becas.isEmpty())
            return "No hay becas en la BD";
        
        String msg="      <li class='nav-item'>";
    
  msg+="\n  <a class='nav-link text-primary' href='Volver?name=1&idUser="+codAplicante+"'>Regresar</a>";
 msg+="\n </li>";
        
          msg+="\n   <li class='nav-item'>";
        msg+=" \n <a class='nav-link text-primary' href='CerrarSesionServlet'>Cerrar Sesion</a>";
        msg+="\n </li>";
        msg+="\n </ul>";
  
         msg+="\n </div>";
         msg+="\n  <div class='main-bg '>";
       msg+="\n    <div class='container'>";
      msg+="\n <h1>Lista de becas</h1>";
       
  msg+="\n   <table id='example' class='display nowrap' style'width:100%'>";
        msg+="\n <thead>";
          msg+="\n   <tr>";
            msg+="\n     <th>CODIGO</th>";
             msg+="\n    <th>NOMBRE</th>";            
             msg+="\n    <th>ESTADO</th>";
               msg+="\n <th>EDITAR </th>";
                msg+="\n <th>ELIMINAR </th>";
            msg+="\n </tr>";
        msg+="\n </thead>";
        msg+="\n <tbody>";
        
    
       for(BecaAplicante pl:this.becaapli)
        {
       if((pl.getCodaplicante().getCedula()==codAplicante)&&(pl.getEstado().equals("pendiente")))
       {
            
        msg+="\n <tr>";
        msg+="\n <td>" + pl.getCodbeca().getCodigoBeca()+ "</td>";
        for(Becaa bc:this.becas)
        {
            if(bc.getCodigoBeca()==pl.getCodbeca().getCodigoBeca())
        msg+="\n <td>" + bc.getNombre()+ "</td>";   
        }
        msg+="\n <td>" + pl.getEstado()+ "</td>";      
        
        int codigo=pl.getCodigo();
       msg+="\n <td><a href='Editar?name="+codigo+"'>Editar</a></td>";
        msg+="\n <td><a href='Eliminar?name="+codigo+"'>Eliminar</a></td>";
        msg+="\n </tr>";
       }   
       
    }
          
         msg+="  </tbody>";
           msg+="\n <tfood>";
          msg+="\n   <tr>";
            msg+="\n   <th>CODIGO</th>";
             msg+="\n    <th>NOMBRE</th>";            
             msg+="\n    <th>ESTADO</th>";
               msg+="\n <th>EDITAR </th>";
                msg+="\n <th>ELIMINAR </th>";
            msg+="\n </tr>";
        msg+="\n </tfood>";
         msg+="  </table>";
             msg+="<script>";
    msg+="$(document).ready(function() {";
        msg+="$('#example').DataTable( {";
            msg+="dom: 'Bfrtip',";
            msg+="buttons: [";
               msg+="'copy', 'csv', 'excel', 'pdf', 'print'";
            msg+="]";
        msg+="} );";
    msg+="} );";
msg+="</script>";
    return msg;
    }
      
}
