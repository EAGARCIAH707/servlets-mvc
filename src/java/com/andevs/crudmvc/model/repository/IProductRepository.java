package com.andevs.crudmvc.model.repository;

import com.andevs.crudmvc.model.LoginDto;
import com.andevs.crudmvc.model.entities.Producto;

import java.util.List;

public interface IProductRepository {

    Boolean save(Producto producto);

    Boolean update(Producto producto);

    Boolean delete(Integer id);

    Producto findByDocNumber(Long docNumber);

    Producto findById(Integer id);

    List<Producto> findAll();

    Boolean login(LoginDto loginDto);
}
