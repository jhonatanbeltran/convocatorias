/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEGOCIO;

import DAO.AdministradorJpaController;
import DAO.Conexion;
import DTO.Administrador;

/**
 *
 * @author german
 */
public class MetAdministrador {

    public MetAdministrador() {
    }
    
    
     public Administrador getAdministrador(int ced){
        Conexion c=Conexion.getConexion();
       AdministradorJpaController pl=new AdministradorJpaController(c.getBd());
        //llama el metodo encontrar
        return pl.findAdministrador(ced);
    }
}
