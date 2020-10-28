package com.andevs.crudmvc.model.dao.alumno;

import com.andevs.crudmvc.model.entities.Alumno;
import com.andevs.crudmvc.model.repository.AlumnoRepository;
import com.andevs.crudmvc.model.repository.IAlumnoRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class AlumnoDao implements IAlumnoDao {

    private final IAlumnoRepository alumnoRepository;

    public AlumnoDao() {
        alumnoRepository = new AlumnoRepository();
    }

    @Override
    public Boolean create(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    public Boolean update(Alumno alumno) {

        Boolean result = alumnoRepository.update(alumno);
        return result;
    }

    @Override
    public Boolean delete(Integer id) {
      return alumnoRepository.delete(id);
    }

    @Override
    public Alumno findByDocNumber(Long docNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Alumno findById(Integer id) {
        return alumnoRepository.findById(id);
    }

    @Override
    public List<Alumno> findAll() {
        List<Alumno> list = alumnoRepository.findAll();
        list.sort(Comparator.comparing(Alumno::getIdAlumno));
        return list;
    }

    private Alumno getAttributes(Map<String, String> params) {
        return new Alumno();
    }
}
