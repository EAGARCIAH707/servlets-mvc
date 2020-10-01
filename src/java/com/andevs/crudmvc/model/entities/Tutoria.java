/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andevs.crudmvc.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lenovo
 */
@Entity
@Table(name = "tutoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tutoria.findAll", query = "SELECT t FROM Tutoria t")
    , @NamedQuery(name = "Tutoria.findByIdTutoria", query = "SELECT t FROM Tutoria t WHERE t.idTutoria = :idTutoria")
    , @NamedQuery(name = "Tutoria.findByDia", query = "SELECT t FROM Tutoria t WHERE t.dia = :dia")
    , @NamedQuery(name = "Tutoria.findByHora", query = "SELECT t FROM Tutoria t WHERE t.hora = :hora")})
public class Tutoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tutoria")
    private Integer idTutoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "dia")
    private String dia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "hora")
    private String hora;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTutoria")
    private List<Cita> citaList;
    @JoinColumn(name = "id_profesor", referencedColumnName = "id_profesor")
    @ManyToOne(optional = false)
    private Profesor idProfesor;

    public Tutoria() {
    }

    public Tutoria(Integer idTutoria) {
        this.idTutoria = idTutoria;
    }

    public Tutoria(Integer idTutoria, String dia, String hora) {
        this.idTutoria = idTutoria;
        this.dia = dia;
        this.hora = hora;
    }

    public Integer getIdTutoria() {
        return idTutoria;
    }

    public void setIdTutoria(Integer idTutoria) {
        this.idTutoria = idTutoria;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @XmlTransient
    public List<Cita> getCitaList() {
        return citaList;
    }

    public void setCitaList(List<Cita> citaList) {
        this.citaList = citaList;
    }

    public Profesor getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Profesor idProfesor) {
        this.idProfesor = idProfesor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTutoria != null ? idTutoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tutoria)) {
            return false;
        }
        Tutoria other = (Tutoria) object;
        if ((this.idTutoria == null && other.idTutoria != null) || (this.idTutoria != null && !this.idTutoria.equals(other.idTutoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.andevs.crudmvc.model.entities.Tutoria[ idTutoria=" + idTutoria + " ]";
    }
    
}
