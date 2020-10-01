/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andevs.crudmvc.model.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author lenovo
 */
@Entity
@Table(name = "tutorias")
@XmlRootElement
/*@NamedQueries({
    @NamedQuery(name = "Tutorias.findAll", query = "SELECT t FROM Tutorias t")})*/
public class Tutorias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "alumno")
    @Transient
    private String alumno;
    @Size(max = 2147483647)
    @Column(name = "dia_hora")
    @Transient
    private String diaHora;
    @Size(max = 50)
    @Column(name = "profesor")
    @Transient
    private String profesor;
    @Id
    @Column(name = "row_number")
    private String rowNumber;

    public Tutorias() {
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public String getDiaHora() {
        return diaHora;
    }

    public void setDiaHora(String diaHora) {
        this.diaHora = diaHora;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(String rowNumber) {
        this.rowNumber = rowNumber;
    }

    @Override
    public String toString() {
        return "Tutorias{"
                + "alumno='" + alumno + '\''
                + ", diaHora='" + diaHora + '\''
                + ", profesor='" + profesor + '\''
                + ", rowNumber='" + rowNumber + '\''
                + '}';
    }
}
