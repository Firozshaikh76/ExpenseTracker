// src/main/java/com/sms/dao/BudgetDAOImpl.java
package com.sms.dao;

import demo.com.expense_tracker.entities.Budget;
import demo.com.expense_tracker.entities.Hibernateutil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BudgetDAOImpl implements BudgetDAO {

    @Override
    public void insert(Budget budget) {
        Transaction transaction = null;
        try (Session session = Hibernateutil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(budget);
            transaction.commit();
            System.out.println("Budget inserted successfully.");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error inserting Budget: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void update(Budget budget) {
        Transaction transaction = null;
        try (Session session = Hibernateutil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(budget);
            transaction.commit();
            System.out.println("Budget updated successfully.");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error updating Budget: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void delete(String budgetId) {
        Transaction transaction = null;
        try (Session session = Hibernateutil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Budget budget = session.get(Budget.class, budgetId);
            if (budget != null) {
                session.delete(budget);
                System.out.println("Budget deleted successfully.");
            } else {
                System.out.println("Budget with ID " + budgetId + " not found.");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error deleting Budget: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public Budget findById(String budgetId) {
        try (Session session = Hibernateutil.getSessionFactory().openSession()) {
            return session.get(Budget.class, budgetId);
        } catch (Exception e) {
            System.err.println("Error finding Budget by ID: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Budget> findAll() {
        try (Session session = Hibernateutil.getSessionFactory().openSession()) {
            Query<Budget> query = session.createQuery("FROM Budget", Budget.class);
            return query.list();
        } catch (Exception e) {
            System.err.println("Error retrieving all Budgets: " + e.getMessage());
            throw e;
        }
    }
}
