package com.andevs.crudmvc.model.dao.alumno;

import com.andevs.crudmvc.model.entities.Alumno;
import com.andevs.crudmvc.model.repository.AlumnoRepository;
import com.andevs.crudmvc.model.repository.IAlumnoRepository;
import org.hibernate.Query;

import java.util.List;
import java.util.Map;

public class AlumnoDao implements IAlumnoDao {

    private final IAlumnoRepository alumnoRepository;

    public AlumnoDao() {
        alumnoRepository = new AlumnoRepository();
    }

    @Override
    public Boolean create(Map<String, String> params) {
        Alumno alumno = getAttributes(params);
        return alumnoRepository.save(alumno);
    }

    @Override
    public Boolean update(Map<String, String> properties) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Alumno findByDocNumber(Long docNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alumno> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Alumno getAttributes(Map<String, String> params) {
        return new Alumno();
    }
}
