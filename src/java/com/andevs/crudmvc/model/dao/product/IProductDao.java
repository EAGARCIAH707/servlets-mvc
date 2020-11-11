package com.andevs.crudmvc.model.dao.product;

import com.andevs.crudmvc.model.entities.Producto;
import java.util.List;

public interface IProductDao {

    Boolean create(Producto producto);

    Boolean delete(Integer id);

    List<Producto> findAll();
}
