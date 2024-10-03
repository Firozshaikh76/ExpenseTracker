package com.sms.dao;

import demo.com.expense_tracker.entities.Expense;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import demo.com.expense_tracker.entities.*;
import java.util.List;

public class ExpenseDAOImpl implements ExpenseDAO {

    @Override
    public void insert(Expense expense) {
        Transaction transaction = null;
        try (Session session = Hibernateutil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(expense);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void update(Expense expense) {
        Transaction transaction = null;
        try (Session session = Hibernateutil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(expense);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String expenseId) {
        Transaction transaction = null;
        try (Session session = Hibernateutil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Expense expense = session.get(Expense.class, expenseId);
            if (expense != null) {
                session.delete(expense);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Expense findById(String expenseId) {
        Expense expense = null;
        try (Session session = Hibernateutil.getSessionFactory().openSession()) {
            expense = session.get(Expense.class, expenseId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return expense;
    }

    @Override
    public List<Expense> findAll() {
        List<Expense> expenses = null;
        try (Session session = Hibernateutil.getSessionFactory().openSession()) {
            Query<Expense> query = session.createQuery("FROM Expense", Expense.class);
            expenses = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return expenses;
    }
}
