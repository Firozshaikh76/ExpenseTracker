package demo.com.expense_tracker.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernateutil {
	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static SessionFactory buildSessionFactory() {
	try {
	return new
	Configuration().configure("hibernate.cfg.xml").
	addAnnotatedClass(user.class).addAnnotatedClass(Category.class).addAnnotatedClass(Income.class).addAnnotatedClass(Payment.class).addAnnotatedClass(Expense.class).addAnnotatedClass(Budget.class).addAnnotatedClass(Notifications.class).buildSessionFactory();
	
	} catch (Throwable ex) {
	throw new ExceptionInInitializerError(ex);
	}
	}
	public static SessionFactory getSessionFactory() {
	return sessionFactory;
	}
	public static void shutdown() {
		// TODO Auto-generated method stub
		
	}
}
