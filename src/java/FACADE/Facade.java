/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FACADE;

import DTO.Administrador;
import DTO.Aplicante;
import DTO.BecaAplicante;
import DTO.Becaa;
import NEGOCIO.AñadirAplicante;
import NEGOCIO.MetAdministrador;
import NEGOCIO.MetBecas;
import java.text.ParseException;

/**
 *
 * @author german
 */
public class Facade {
    private AñadirAplicante añadir = new AñadirAplicante();
    private MetAdministrador administrador = new MetAdministrador();
    private MetBecas beca = new MetBecas();
    
    
    public Facade(){};
    
    public void InsertarAplicante(Aplicante apli) throws Exception{ this.añadir.RegistrarAplicante(apli);}
    public Aplicante getAplicante(int ced) {return this.añadir.getAplicante(ced);}
    public Administrador getAdmin(int ced){ return this.administrador.getAdministrador(ced);}
    public void InsertarBeca(Becaa bec) throws Exception{ this.beca.RegistrarBecas(bec);}
    public String getTablaBecas(int codAplicante) throws ParseException{return this.beca.getTablaBecas(codAplicante);}
     public void prueba(BecaAplicante bec) throws Exception{ this.beca.prueba(bec);}
    public String getTablaBecasInicio() throws ParseException{return this.beca.getTablaBecasInicio();}
    public Becaa getBeca(int id){return this.beca.getBeca(id);}
    public void RegistrarBecasAplicante(BecaAplicante apli) throws Exception{this.beca.RegistrarBecasAplicantes(apli);}
     public String getTablaPendientes(int codAplicante) throws ParseException{return this.beca.getTablaPendientes(codAplicante);}
    
    
}
