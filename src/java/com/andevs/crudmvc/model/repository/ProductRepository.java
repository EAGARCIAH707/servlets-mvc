package com.andevs.crudmvc.model.repository;

import com.andevs.crudmvc.model.configuration.PersistenceConfig;
import com.andevs.crudmvc.model.entities.Producto;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {

    private Session session;
    private Transaction transaction;

    private void initSession() {
        session = PersistenceConfig.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }

    private void commitTransaction() {
        transaction.commit();
    }

    @Override
    public List<Producto> findAll() {
        try {
            initSession();
            List<Producto> employeeList = session.createCriteria(Producto.class).list();
            commitTransaction();
            return employeeList;
        } catch (HibernateException e) {
            // exceptionHandler(e);
        } catch (Exception e) {
            System.out.println("Error in findAll() " + e.getMessage());
        } finally {
            session.close();
        }
        return new ArrayList<>();
    }

    @Override
    public Boolean update(Producto producto) {
        try {
            initSession();
            session.update(producto);
            commitTransaction();
            return Boolean.TRUE;
        } catch (HibernateException e) {
            // exceptionHandler(e);
        } catch (Exception e) {
            System.out.println("Error in findAll() " + e.getMessage());
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Boolean save(Producto producto) {
        try {
            initSession();
            Integer id = (Integer) session.save(producto);
            commitTransaction();
            if (id != null && id > 0) {
                System.out.println("Objeto guardado");
                return Boolean.TRUE;
            }
        } catch (HibernateException e) {
            exceptionHandler(e);
        } catch (Exception e) {
            System.out.println("Error in save() " + e.getMessage());
        } finally {
            session.close();
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean delete(Integer id) {
        try {
            Producto producto = findById(id);
            initSession();
            session.delete(producto);
            commitTransaction();
            return Boolean.TRUE;
        } catch (HibernateException e) {
            exceptionHandler(e);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return Boolean.FALSE;
    }

    @Override
    public Producto findById(Integer id) {
        try {
            initSession();
            return (Producto) session.get(Producto.class, id);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }

        return null;
    }


    private void exceptionHandler(HibernateException e) {
        session.getTransaction().rollback();
        System.out.println("Error in EmployeeRepository ".concat(e.getMessage()));
    }

}
