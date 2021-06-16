/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author german
 */
@Entity
@Table(name = "administrador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a")
    , @NamedQuery(name = "Administrador.findByCedula", query = "SELECT a FROM Administrador a WHERE a.cedula = :cedula")
    , @NamedQuery(name = "Administrador.findByContrase\u00f1a", query = "SELECT a FROM Administrador a WHERE a.contrase\u00f1a = :contrase\u00f1a")
    , @NamedQuery(name = "Administrador.findByPrimerNombre", query = "SELECT a FROM Administrador a WHERE a.primerNombre = :primerNombre")
    , @NamedQuery(name = "Administrador.findBySegundoNombre", query = "SELECT a FROM Administrador a WHERE a.segundoNombre = :segundoNombre")
    , @NamedQuery(name = "Administrador.findByPrimerApellido", query = "SELECT a FROM Administrador a WHERE a.primerApellido = :primerApellido")
    , @NamedQuery(name = "Administrador.findBySegundoApellido", query = "SELECT a FROM Administrador a WHERE a.segundoApellido = :segundoApellido")
    , @NamedQuery(name = "Administrador.findByCorreoElectronico", query = "SELECT a FROM Administrador a WHERE a.correoElectronico = :correoElectronico")})
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Cedula")
    private Integer cedula;
    @Basic(optional = false)
    @Column(name = "contrase\u00f1a")
    private int contraseña;
    @Basic(optional = false)
    @Column(name = "primer_nombre")
    private String primerNombre;
    @Basic(optional = false)
    @Column(name = "segundo_nombre")
    private String segundoNombre;
    @Basic(optional = false)
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Basic(optional = false)
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Basic(optional = false)
    @Column(name = "correo_electronico")
    private String correoElectronico;

    public Administrador() {
    }

    public Administrador(Integer cedula) {
        this.cedula = cedula;
    }

    public Administrador(Integer cedula, int contraseña, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String correoElectronico) {
        this.cedula = cedula;
        this.contraseña = contraseña;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.correoElectronico = correoElectronico;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public int getContraseña() {
        return contraseña;
    }

    public void setContraseña(int contraseña) {
        this.contraseña = contraseña;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DTO.Administrador[ cedula=" + cedula + " ]";
    }
    
}
