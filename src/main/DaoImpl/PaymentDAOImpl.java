package com.sms.dao;

import demo.com.expense_tracker.entities.Hibernateutil;
import demo.com.expense_tracker.entities.Payment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class PaymentDAOImpl implements PaymentDAO {
    private SessionFactory sessionFactory = Hibernateutil.getSessionFactory();

    @Override
    public void insert(Payment payment) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(payment);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void update(Payment payment) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(payment);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String paymentId) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Payment payment = session.get(Payment.class, paymentId);
            if (payment != null) {
                session.delete(payment);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Payment findById(String paymentId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Payment.class, paymentId);
        }
    }

    @Override
    public List<Payment> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Payment", Payment.class).list();
        }
    }
}
