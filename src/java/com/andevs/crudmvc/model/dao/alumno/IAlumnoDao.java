package com.andevs.crudmvc.model.dao.alumno;

import com.andevs.crudmvc.model.entities.Alumno;
import java.util.List;
import java.util.Map;

public interface IAlumnoDao {

    Boolean create(Alumno alumno);

    Boolean update(Map<String, String> properties);

    Boolean delete(Integer id);

    Alumno findByDocNumber(Long docNumber);

    List<Alumno> findAll();
}
