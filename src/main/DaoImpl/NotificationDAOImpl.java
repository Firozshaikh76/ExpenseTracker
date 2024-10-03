// src/main/java/com/sms/dao/NotificationDAOImpl.java
package com.sms.dao;

import demo.com.expense_tracker.entities.Notifications;
import demo.com.expense_tracker.entities.Hibernateutil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class NotificationDAOImpl implements NotificationDAO {

    @Override
    public void insert(Notifications notification) {
        Transaction transaction = null;
        try (Session session = Hibernateutil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(notification);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        }
    }

    @Override
    public void update(Notifications notification) {
        Transaction transaction = null;
        try (Session session = Hibernateutil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(notification);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        }
    }

    @Override
    public void delete(String notifyId) {
        Transaction transaction = null;
        try (Session session = Hibernateutil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Notifications notification = session.get(Notifications.class, notifyId);
            if (notification != null) {
                session.delete(notification);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        }
    }

    @Override
    public Notifications findById(String notifyId) {
        try (Session session = Hibernateutil.getSessionFactory().openSession()) {
            return session.get(Notifications.class, notifyId);
        }
    }

    @Override
    public List<Notifications> findAll() {
        try (Session session = Hibernateutil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Notifications", Notifications.class).list();
        }
    }
}
