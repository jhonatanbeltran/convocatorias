/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author german
 */
@Entity
@Table(name = "aplicante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aplicante.findAll", query = "SELECT a FROM Aplicante a")
    , @NamedQuery(name = "Aplicante.findByCedula", query = "SELECT a FROM Aplicante a WHERE a.cedula = :cedula")
    , @NamedQuery(name = "Aplicante.findByContrase\u00f1a", query = "SELECT a FROM Aplicante a WHERE a.contrase\u00f1a = :contrase\u00f1a")
    , @NamedQuery(name = "Aplicante.findByPrimerNombre", query = "SELECT a FROM Aplicante a WHERE a.primerNombre = :primerNombre")
    , @NamedQuery(name = "Aplicante.findBySegundoNombre", query = "SELECT a FROM Aplicante a WHERE a.segundoNombre = :segundoNombre")
    , @NamedQuery(name = "Aplicante.findByPrimerapellido", query = "SELECT a FROM Aplicante a WHERE a.primerapellido = :primerapellido")
    , @NamedQuery(name = "Aplicante.findBySegundoApellido", query = "SELECT a FROM Aplicante a WHERE a.segundoApellido = :segundoApellido")
    , @NamedQuery(name = "Aplicante.findByFechaNacimiento", query = "SELECT a FROM Aplicante a WHERE a.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Aplicante.findByCorreo", query = "SELECT a FROM Aplicante a WHERE a.correo = :correo")
    , @NamedQuery(name = "Aplicante.findByCelular", query = "SELECT a FROM Aplicante a WHERE a.celular = :celular")})
public class Aplicante implements Serializable {

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
    @Column(name = "Primer_apellido")
    private String primerapellido;
    @Basic(optional = false)
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Basic(optional = false)
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "celular")
    private String celular;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codaplicante")
    private List<BecaAplicante> becaAplicanteList;

    public Aplicante() {
    }

    public Aplicante(Integer cedula) {
        this.cedula = cedula;
    }

    public Aplicante(Integer cedula, int contraseña, String primerNombre, String segundoNombre, String primerapellido, String segundoApellido, Date fechaNacimiento, String correo, String celular) {
        this.cedula = cedula;
        this.contraseña = contraseña;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerapellido = primerapellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.celular = celular;
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

    public String getPrimerapellido() {
        return primerapellido;
    }

    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @XmlTransient
    public List<BecaAplicante> getBecaAplicanteList() {
        return becaAplicanteList;
    }

    public void setBecaAplicanteList(List<BecaAplicante> becaAplicanteList) {
        this.becaAplicanteList = becaAplicanteList;
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
        if (!(object instanceof Aplicante)) {
            return false;
        }
        Aplicante other = (Aplicante) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DTO.Aplicante[ cedula=" + cedula + " ]";
    }
    
}
