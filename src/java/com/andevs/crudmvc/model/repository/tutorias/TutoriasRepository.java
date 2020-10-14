package com.andevs.crudmvc.model.repository.tutorias;

import com.andevs.crudmvc.model.configuration.PersistenceConfig;
import com.andevs.crudmvc.model.entities.Tutorias;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TutoriasRepository implements ITutoriasRepository {

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
    public List<Tutorias> findAll() {
        try {
            initSession();
            List<Tutorias> result = session.createCriteria(Tutorias.class).list();
            return result;
        } catch (HibernateException e) {
            exceptionHandler(e);
        } catch (Exception e) {
            System.out.println("Error in findAll() " + e.getMessage());
        } finally {
            session.close();
        }
        return new ArrayList<>();
    }

    private void exceptionHandler(HibernateException e) {
        session.getTransaction().rollback();
        System.out.println("Error in EmployeeRepository ".concat(e.getMessage()));
    }
}
