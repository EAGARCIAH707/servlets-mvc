package com.andevs.crudmvc.model.dao.profesor;

import com.andevs.crudmvc.model.entities.Profesor;
import com.andevs.crudmvc.model.repository.profesor.IProfesorRepository;
import com.andevs.crudmvc.model.repository.profesor.ProfesorRepository;

public class ProfesorDao implements IProfesorDao {
    private IProfesorRepository profesorRepository;

    public ProfesorDao() {
        this.profesorRepository = new ProfesorRepository();
    }

    @Override
    public Boolean createTeacher(String name, String idNumber) {
        try {
            if (name != null && idNumber != null) {
                Profesor profesor = new Profesor(name, idNumber);
                return profesorRepository.save(profesor);
            } else {
                return Boolean.FALSE;
            }

        } catch (Exception e) {
        }
        return Boolean.FALSE;
    }
}
