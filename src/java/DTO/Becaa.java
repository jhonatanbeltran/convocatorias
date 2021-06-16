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
import javax.persistence.Lob;
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
@Table(name = "becaa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Becaa.findAll", query = "SELECT b FROM Becaa b")
    , @NamedQuery(name = "Becaa.findByCodigoBeca", query = "SELECT b FROM Becaa b WHERE b.codigoBeca = :codigoBeca")
    , @NamedQuery(name = "Becaa.findByNombre", query = "SELECT b FROM Becaa b WHERE b.nombre = :nombre")
    , @NamedQuery(name = "Becaa.findByEstado", query = "SELECT b FROM Becaa b WHERE b.estado = :estado")
    , @NamedQuery(name = "Becaa.findByRubro", query = "SELECT b FROM Becaa b WHERE b.rubro = :rubro")
    , @NamedQuery(name = "Becaa.findByFechaInicio", query = "SELECT b FROM Becaa b WHERE b.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Becaa.findByFechaCierre", query = "SELECT b FROM Becaa b WHERE b.fechaCierre = :fechaCierre")
    , @NamedQuery(name = "Becaa.findByFechaRegistro", query = "SELECT b FROM Becaa b WHERE b.fechaRegistro = :fechaRegistro")})
public class Becaa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo_beca")
    private Integer codigoBeca;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Lob
    @Column(name = "requisitos")
    private String requisitos;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "rubro")
    private String rubro;
    @Basic(optional = false)
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @Column(name = "fecha_cierre")
    @Temporal(TemporalType.DATE)
    private Date fechaCierre;
    @Basic(optional = false)
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codbeca")
    private List<BecaAplicante> becaAplicanteList;

    public Becaa() {
    }

    public Becaa(Integer codigoBeca) {
        this.codigoBeca = codigoBeca;
    }

    public Becaa(Integer codigoBeca, String nombre, String descripcion, String requisitos, String estado, String rubro, Date fechaInicio, Date fechaCierre, Date fechaRegistro) {
        this.codigoBeca = codigoBeca;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.requisitos = requisitos;
        this.estado = estado;
        this.rubro = rubro;
        this.fechaInicio = fechaInicio;
        this.fechaCierre = fechaCierre;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getCodigoBeca() {
        return codigoBeca;
    }

    public void setCodigoBeca(Integer codigoBeca) {
        this.codigoBeca = codigoBeca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
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
        hash += (codigoBeca != null ? codigoBeca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Becaa)) {
            return false;
        }
        Becaa other = (Becaa) object;
        if ((this.codigoBeca == null && other.codigoBeca != null) || (this.codigoBeca != null && !this.codigoBeca.equals(other.codigoBeca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DTO.Becaa[ codigoBeca=" + codigoBeca + " ]";
    }
    
}
