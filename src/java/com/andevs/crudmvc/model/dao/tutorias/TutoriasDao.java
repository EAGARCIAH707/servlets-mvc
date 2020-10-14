package com.andevs.crudmvc.model.dao.tutorias;

import com.andevs.crudmvc.model.entities.Tutorias;
import com.andevs.crudmvc.model.repository.tutorias.ITutoriasRepository;
import com.andevs.crudmvc.model.repository.tutorias.TutoriasRepository;

import java.util.ArrayList;
import java.util.List;

public class TutoriasDao implements ITutoriasDao {

    private final ITutoriasRepository tutoriasRepository;

    public TutoriasDao() {
        this.tutoriasRepository = new TutoriasRepository();
    }

    @Override
    public List<Tutorias> getAllTutorias() {
        try {
            return tutoriasRepository.findAll();
        } catch (Exception e) {
            System.out.println(e);
        }
        return new ArrayList<>();
    }
}
