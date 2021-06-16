/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author german
 */
@Entity
@Table(name = "beca_aplicante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BecaAplicante.findAll", query = "SELECT b FROM BecaAplicante b")
    , @NamedQuery(name = "BecaAplicante.findByCodigo", query = "SELECT b FROM BecaAplicante b WHERE b.codigo = :codigo")
    , @NamedQuery(name = "BecaAplicante.findByFechaRegistro", query = "SELECT b FROM BecaAplicante b WHERE b.fechaRegistro = :fechaRegistro")})
public class BecaAplicante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Lob
    @Column(name = "rutazip")
    private String rutazip;
    @Basic(optional = false)
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Basic(optional = false)
    @Lob
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "codaplicante", referencedColumnName = "Cedula")
    @ManyToOne(optional = false)
    private Aplicante codaplicante;
    @JoinColumn(name = "codbeca", referencedColumnName = "codigo_beca")
    @ManyToOne(optional = false)
    private Becaa codbeca;

    public BecaAplicante() {
    }

    public BecaAplicante(Integer codigo) {
        this.codigo = codigo;
    }

    public BecaAplicante(Integer codigo, String rutazip, Date fechaRegistro, String estado) {
        this.codigo = codigo;
        this.rutazip = rutazip;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getRutazip() {
        return rutazip;
    }

    public void setRutazip(String rutazip) {
        this.rutazip = rutazip;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Aplicante getCodaplicante() {
        return codaplicante;
    }

    public void setCodaplicante(Aplicante codaplicante) {
        this.codaplicante = codaplicante;
    }

    public Becaa getCodbeca() {
        return codbeca;
    }

    public void setCodbeca(Becaa codbeca) {
        this.codbeca = codbeca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BecaAplicante)) {
            return false;
        }
        BecaAplicante other = (BecaAplicante) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DTO.BecaAplicante[ codigo=" + codigo + " ]";
    }
    
}
