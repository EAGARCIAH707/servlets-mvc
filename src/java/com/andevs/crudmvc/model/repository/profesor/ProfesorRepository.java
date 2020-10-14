package com.andevs.crudmvc.model.repository.profesor;

import com.andevs.crudmvc.model.configuration.PersistenceConfig;
import com.andevs.crudmvc.model.entities.Profesor;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProfesorRepository implements IProfesorRepository {

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
    public Boolean save(Profesor profesor) {
        try {
            initSession();
            Integer id = (Integer) session.save(profesor);
            commitTransaction();
            if (id != null && id > 0) {
                return Boolean.TRUE;
            }
        } catch (Exception e) {
            System.out.println("Error in save : " + e);
        } finally {
            session.close();
        }
        return Boolean.FALSE;
    }
}
