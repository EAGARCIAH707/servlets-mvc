package com.andevs.crudmvc.model.dao.alumno;

import com.andevs.crudmvc.model.entities.Alumno;
import java.util.List;

public interface IAlumnoDao {

    Boolean create(Alumno alumno);

    Boolean update(Alumno alumno);

    Boolean delete(Integer id);

    Alumno findByDocNumber(Long docNumber);

    Alumno findById(Integer docNumber);

    List<Alumno> findAll();
}
