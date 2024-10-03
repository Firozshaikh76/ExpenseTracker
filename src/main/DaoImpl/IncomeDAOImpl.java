// src/main/java/com/sms/dao/IncomeDAOImpl.java
package com.sms.dao;

import demo.com.expense_tracker.entities.Income;
import demo.com.expense_tracker.entities.Hibernateutil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class IncomeDAOImpl implements IncomeDAO {

    @Override
    public void insert(Income income) {
        Transaction transaction = null;
        try (Session session = Hibernateutil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(income);
            transaction.commit();
            System.out.println("Income inserted successfully.");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error inserting Income: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void update(Income income) {
        Transaction transaction = null;
        try (Session session = Hibernateutil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(income);
            transaction.commit();
            System.out.println("Income updated successfully.");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error updating Income: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void delete(String incomeId) {
        Transaction transaction = null;
        try (Session session = Hibernateutil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Income income = session.get(Income.class, incomeId);
            if (income != null) {
                session.delete(income);
                System.out.println("Income deleted successfully.");
            } else {
                System.out.println("Income with ID " + incomeId + " not found.");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error deleting Income: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public Income findById(String incomeId) {
        try (Session session = Hibernateutil.getSessionFactory().openSession()) {
            return session.get(Income.class, incomeId);
        } catch (Exception e) {
            System.err.println("Error finding Income by ID: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Income> findAll() {
        try (Session session = Hibernateutil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Income", Income.class).list();
        } catch (Exception e) {
            System.err.println("Error retrieving all Incomes: " + e.getMessage());
            throw e;
        }
    }
}
