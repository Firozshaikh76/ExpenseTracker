package com.demo.expense_tracker;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import demo.com.expense_tracker.entities.Budget;
import demo.com.expense_tracker.entities.Category;
import demo.com.expense_tracker.entities.Expense;
import demo.com.expense_tracker.entities.Hibernateutil;
import demo.com.expense_tracker.entities.Income;
import demo.com.expense_tracker.entities.Notifications;
import demo.com.expense_tracker.entities.Payment;
import demo.com.expense_tracker.entities.user;


public class App {
    public static void main(String[] args) {
        // Obtain a Hibernate SessionFactory
        SessionFactory factory = Hibernateutil.getSessionFactory();

        // Open a new session
        Session session = factory.openSession();

        // Start a transaction
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            
            // Create User entity
            user newUser = new user("U001", "ashu", "password123", LocalDate.of(2003, 7, 29));
            // Save the user entity
            session.save(newUser);
            
            // Create Category entity
            Category newCategory = new Category("C001", "U001", "recharge", LocalDate.of(2024, 7, 13));
            // Save the Category entity
            session.save(newCategory);
            
            // Create Income entity
            Income newIncome = new Income("I001", "U001", 25000, LocalDate.of(2024, 10, 21));
            // Save the Income entity
            session.save(newIncome);
            
            // Create Payment entity
            Payment newPayment = new Payment("P001", "U001", "Upi" ,LocalDate.of(2024, 7, 14));
            // Save the Payment entity
            session.save(newPayment);
            
            // Create Expense entity
            Expense newExpense = new Expense("E001", "U001","C001", 249 ,LocalDate.of(2024, 7, 14));
            // Save the Expense entity
            session.save(newExpense);
            
            // Create Budget entity
            Budget newBudget = new Budget("B001", "U001", "C001", 17000, LocalDate.of(2024, 10, 22), LocalDate.of(2024, 11, 22));
            // Save the Budget entity
            session.save(newBudget);
            
            // Create Budget entity
            Notifications newNotification = new Notifications("N001", "U001", "249 debited from account", LocalDate.of(2024, 10, 23));
            // Save the Budget entity
            session.save(newNotification);
            
            // Commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // Close the session
            session.close();
        }

        // Close the SessionFactory
        factory.close();
    }
}
