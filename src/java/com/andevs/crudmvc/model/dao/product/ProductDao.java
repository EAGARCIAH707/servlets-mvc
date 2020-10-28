package com.andevs.crudmvc.model.dao.product;

import com.andevs.crudmvc.model.entities.Producto;
import com.andevs.crudmvc.model.repository.IProductRepository;
import com.andevs.crudmvc.model.repository.ProductRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ProductDao implements IProductDao {

    private final IProductRepository alumnoRepository;

    public ProductDao() {
        alumnoRepository = new ProductRepository();
    }

    @Override
    public Boolean create(Producto producto) {
        return alumnoRepository.save(producto);
    }

    @Override
    public Boolean delete(Integer id) {
        return alumnoRepository.delete(id);
    }

    @Override
    public List<Producto> findAll() {
        List<Producto> list = alumnoRepository.findAll();
        list.sort(Comparator.comparing(Producto::getIdProducto));
        return list;
    }

    private Producto getAttributes(Map<String, String> params) {
        return new Producto();
    }
}
