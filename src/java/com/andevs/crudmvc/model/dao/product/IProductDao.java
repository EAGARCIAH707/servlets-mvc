package com.andevs.crudmvc.model.dao.product;

import com.andevs.crudmvc.model.entities.Producto;
import java.util.List;

public interface IProductDao {

    Boolean create(Producto producto);

    Boolean update(Producto producto);

    Boolean delete(Integer id);

    Producto findByDocNumber(Long docNumber);

    Producto findById(Integer docNumber);

    List<Producto> findAll();
}
