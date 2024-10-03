package com.sms.dao;

import demo.com.expense_tracker.entities.Category;
import demo.com.expense_tracker.entities.Hibernateutil; // Ensure you have this utility class
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {

    @Override
    public void insert(Category category) {
        Transaction transaction = null;
        try (Session session = Hibernateutil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(category);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void update(Category category) {
        Transaction transaction = null;
        try (Session session = Hibernateutil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(category);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String categoryId) {
        Transaction transaction = null;
        try (Session session = Hibernateutil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Category category = session.get(Category.class, categoryId);
            if (category != null) {
                session.delete(category);
                transaction.commit();
                System.out.println("Category deleted successfully.");
            } else {
                System.out.println("Category not found.");
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Category findById(String categoryId) {
        Category category = null;
        try (Session session = Hibernateutil.getSessionFactory().openSession()) {
            category = session.get(Category.class, categoryId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = null;
        try (Session session = Hibernateutil.getSessionFactory().openSession()) {
            Query<Category> query = session.createQuery("FROM Category", Category.class);
            categories = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }
}
