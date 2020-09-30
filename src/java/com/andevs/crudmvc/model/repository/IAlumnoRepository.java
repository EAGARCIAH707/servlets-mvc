package com.andevs.crudmvc.model.repository;

import com.andevs.crudmvc.model.LoginDto;
import com.andevs.crudmvc.model.entities.Alumno;

import java.util.List;

public interface IAlumnoRepository {

    Boolean save(Alumno alumno);

    Boolean update(Alumno alumno);

    Boolean delete(Integer id);

    Alumno findByDocNumber(Long docNumber);

    Alumno findById(Integer id);

    List<Alumno> findAll();

    Boolean login(LoginDto loginDto);
}
