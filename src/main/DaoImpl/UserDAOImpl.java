package com.sms.dao;

import demo.com.expense_tracker.entities.Hibernateutil;
import demo.com.expense_tracker.entities.user;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAOImpl implements UserDAO {
    private SessionFactory sessionFactory = Hibernateutil.getSessionFactory();

    @Override
    public void insert(user user) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void update(user user) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String userId) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            user user = session.get(user.class, userId);
            if (user != null) {
                session.delete(user);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public user findById(String userId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(user.class, userId);
        }
    }

    @Override
    public List<user> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from user", user.class).list();
        }
    }
}
