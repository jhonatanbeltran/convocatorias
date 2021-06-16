/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEGOCIO;

import DAO.AplicanteJpaController;
import DAO.Conexion;
import DTO.Aplicante;

/**
 *
 * @author german
 */
public class AñadirAplicante {

    public AñadirAplicante() {
    }
    
    
    //Registrar aplicante
     public void RegistrarAplicante(Aplicante apli) throws Exception{
         //crear la conexion
        Conexion c=Conexion.getConexion();
        //llamar los metodos del jpa
       AplicanteJpaController pl=new AplicanteJpaController(c.getBd());
       //registrar el aplicante
        pl.create(apli);
       }
     
     //traer aplicante de cedula ####
     public Aplicante getAplicante(int ced){
        Conexion c=Conexion.getConexion();
       AplicanteJpaController pl=new AplicanteJpaController(c.getBd());
        //llama el metodo encontrar
        return pl.findAplicante(ced);
    }
     
}
