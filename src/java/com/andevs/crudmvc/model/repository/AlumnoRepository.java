package com.andevs.crudmvc.model.repository;

import com.andevs.crudmvc.model.LoginDto;
import com.andevs.crudmvc.model.configuration.PersistenceConfig;
import com.andevs.crudmvc.model.entities.Alumno;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AlumnoRepository implements IAlumnoRepository {

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
    public List<Alumno> findAll() {
        try {
            initSession();
            List<Alumno> employeeList = session.createCriteria(Alumno.class).list();
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
    public Boolean save(Alumno alumno) {
        try {
            initSession();
            Integer id = (Integer) session.save(alumno);
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
    public Boolean update(Alumno alumno) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Alumno findByDocNumber(Long docNumber) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Alumno findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Boolean login(LoginDto loginDto) {
        try {
            initSession();
            Query query = session.createSQLQuery("select * from alumno where nombre_usuario = :user and contrasenna = :pass");
            query.setParameter("user", loginDto.getUsername());
            query.setParameter("pass", loginDto.getPassword());
            System.out.println(loginDto.getUsername());
            System.out.println(loginDto.getPassword());
            System.out.println(query);
            List result = query.list();
            transaction.commit();
            if (result.size() > 0) {
                return Boolean.TRUE;
            }
        } catch (Exception e) {
            System.out.println("Error in login " + e.getMessage());
        } finally {
            session.close();
        }
        return Boolean.FALSE;
    }

    private void exceptionHandler(HibernateException e) {
        session.getTransaction().rollback();
        System.out.println("Error in EmployeeRepository ".concat(e.getMessage()));
    }

}
