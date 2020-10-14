package com.andevs.crudmvc.model.repository.tutorias;

import com.andevs.crudmvc.model.entities.Tutorias;

import java.util.List;

public interface ITutoriasRepository {
    List<Tutorias> findAll();
}
