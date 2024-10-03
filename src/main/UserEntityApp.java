// src/main/java/com/demo/expense_tracker/UserConsoleApp.java
package com.demo.expense_tracker;

import com.sms.dao.*;
import demo.com.expense_tracker.entities.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class UserEntityApp {
    // Initialize DAOs
    private static UserDAO userDao = new UserDAOImpl();
    private static PaymentDAO paymentDao = new PaymentDAOImpl();
    private static CategoryDAO categoryDao = new CategoryDAOImpl();
    private static ExpenseDAO expenseDao = new ExpenseDAOImpl();
    private static NotificationDAO notificationDao = new NotificationDAOImpl();
    private static IncomeDAO incomeDao = new IncomeDAOImpl();
    private static BudgetDAO budgetDao = new BudgetDAOImpl(); // Initialize BudgetDAO

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Expense Tracker Application ===");
            System.out.println("Choose an operation:");
            System.out.println("1. User Operations");
            System.out.println("2. Payment Operations");
            System.out.println("3. Category Operations");
            System.out.println("4. Expense Operations");
            System.out.println("5. Notification Operations");
            System.out.println("6. Income Operations");
            System.out.println("7. Budget Operations"); // New Budget Operations Menu
            System.out.println("8. Exit");

            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    userOperations();
                    break;
                case 2:
                    paymentOperations();
                    break;
                case 3:
                    categoryOperations();
                    break;
                case 4:
                    expenseOperations();
                    break;
                case 5:
                    notificationOperations();
                    break;
                case 6:
                    incomeOperations();
                    break;
                case 7:
                    budgetOperations(); // Call Budget Operations
                    break;
                case 8:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    Hibernateutil.shutdown();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to safely get user choice
    private static int getUserChoice() {
        int choice = -1;
        try {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Please enter a valid integer.");
            scanner.nextLine(); // Clear invalid input
        }
        scanner.nextLine(); // Consume newline
        return choice;
    }

    // ===========================
    // User Operations
    // ===========================
    private static void userOperations() {
        while (true) {
            System.out.println("\n--- User Operations ---");
            System.out.println("1. Insert User");
            System.out.println("2. Update User");
            System.out.println("3. Delete User");
            System.out.println("4. Show All Users");
            System.out.println("5. Back to Main Menu");

            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    insertUser();
                    break;
                case 2:
                    updateUser();
                    break;
                case 3:
                    deleteUser();
                    break;
                case 4:
                    showAllUsers();
                    break;
                case 5:
                    return; // Go back to main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void insertUser() {
        System.out.println("\nEnter user details:");
        System.out.print("User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        user newUser = new user();
        newUser.setUserId(userId);
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setDateJoined(LocalDate.now());

        try {
            userDao.insert(newUser);
            System.out.println("User inserted successfully.");
        } catch (Exception e) {
            System.out.println("Failed to insert user: " + e.getMessage());
        }
    }

    private static void updateUser() {
        System.out.print("\nEnter user ID to update: ");
        String userId = scanner.nextLine();
        try {
            user existingUser = userDao.findById(userId);
            if (existingUser == null) {
                System.out.println("User not found.");
                return;
            }

            System.out.print("Enter new username (current: " + existingUser.getUsername() + "): ");
            String username = scanner.nextLine();
            System.out.print("Enter new password: ");
            String password = scanner.nextLine();

            existingUser.setUsername(username);
            existingUser.setPassword(password);

            userDao.update(existingUser);
            System.out.println("User updated successfully.");
        } catch (Exception e) {
            System.out.println("Failed to update user: " + e.getMessage());
        }
    }

    private static void deleteUser() {
        System.out.print("\nEnter user ID to delete: ");
        String userId = scanner.nextLine();
        try {
            userDao.delete(userId);
            System.out.println("User deleted successfully.");
        } catch (Exception e) {
            System.out.println("Failed to delete user: " + e.getMessage());
        }
    }

    private static void showAllUsers() {
        try {
            List<user> users = userDao.findAll();
            System.out.println("\n--- User List ---");
            if (users.isEmpty()) {
                System.out.println("No users found.");
            } else {
                for (user u : users) {
                    System.out.println(u);
                }
            }
        } catch (Exception e) {
            System.out.println("Failed to retrieve users: " + e.getMessage());
        }
    }

    // ===========================
    // Payment Operations
    // ===========================
    private static void paymentOperations() {
        while (true) {
            System.out.println("\n--- Payment Operations ---");
            System.out.println("1. Insert Payment");
            System.out.println("2. Update Payment");
            System.out.println("3. Delete Payment");
            System.out.println("4. Show All Payments");
            System.out.println("5. Back to Main Menu");

            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    insertPayment();
                    break;
                case 2:
                    updatePayment();
                    break;
                case 3:
                    deletePayment();
                    break;
                case 4:
                    showAllPayments();
                    break;
                case 5:
                    return; // Go back to main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void insertPayment() {
        System.out.println("\nEnter payment details:");
        System.out.print("Payment ID: ");
        String paymentId = scanner.nextLine();
        System.out.print("User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Details: ");
        String details = scanner.nextLine();

        Payment newPayment = new Payment();
        newPayment.setPaymentId(paymentId);
        newPayment.setUserId(userId);
        newPayment.setDetails(details);
        newPayment.setDatePayment(LocalDate.now());

        try {
            paymentDao.insert(newPayment);
            System.out.println("Payment inserted successfully.");
        } catch (Exception e) {
            System.out.println("Failed to insert payment: " + e.getMessage());
        }
    }

    private static void updatePayment() {
        System.out.print("\nEnter payment ID to update: ");
        String paymentId = scanner.nextLine();
        try {
            Payment existingPayment = paymentDao.findById(paymentId);
            if (existingPayment == null) {
                System.out.println("Payment not found.");
                return;
            }

            System.out.print("Enter new User ID (current: " + existingPayment.getUserId() + "): ");
            String userId = scanner.nextLine();
            System.out.print("Enter new Details (current: " + existingPayment.getDetails() + "): ");
            String details = scanner.nextLine();

            existingPayment.setUserId(userId);
            existingPayment.setDetails(details);

            paymentDao.update(existingPayment);
            System.out.println("Payment updated successfully.");
        } catch (Exception e) {
            System.out.println("Failed to update payment: " + e.getMessage());
        }
    }

    private static void deletePayment() {
        System.out.print("\nEnter payment ID to delete: ");
        String paymentId = scanner.nextLine();
        try {
            paymentDao.delete(paymentId);
            System.out.println("Payment deleted successfully.");
        } catch (Exception e) {
            System.out.println("Failed to delete payment: " + e.getMessage());
        }
    }

    private static void showAllPayments() {
        try {
            List<Payment> payments = paymentDao.findAll();
            System.out.println("\n--- Payment List ---");
            if (payments.isEmpty()) {
                System.out.println("No payments found.");
            } else {
                for (Payment p : payments) {
                    System.out.println(p);
                }
            }
        } catch (Exception e) {
            System.out.println("Failed to retrieve payments: " + e.getMessage());
        }
    }

    // ===========================
    // Category Operations
    // ===========================
    private static void categoryOperations() {
        while (true) {
            System.out.println("\n--- Category Operations ---");
            System.out.println("1. Insert Category");
            System.out.println("2. Update Category");
            System.out.println("3. Delete Category");
            System.out.println("4. Show All Categories");
            System.out.println("5. Back to Main Menu");

            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    insertCategory();
                    break;
                case 2:
                    updateCategory();
                    break;
                case 3:
                    deleteCategory();
                    break;
                case 4:
                    showAllCategories();
                    break;
                case 5:
                    return; // Go back to main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void insertCategory() {
        System.out.println("\nEnter category details:");
        System.out.print("Category ID: ");
        String categoryId = scanner.nextLine();
        System.out.print("User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Category Name: ");
        String categoryName = scanner.nextLine();

        Category newCategory = new Category();
        newCategory.setCategoryId(categoryId);
        newCategory.setUserId(userId);
        newCategory.setCategoryName(categoryName);
        newCategory.setDateCreate(LocalDate.now());

        try {
            categoryDao.insert(newCategory);
            System.out.println("Category inserted successfully.");
        } catch (Exception e) {
            System.out.println("Failed to insert category: " + e.getMessage());
        }
    }

    private static void updateCategory() {
        System.out.print("\nEnter category ID to update: ");
        String categoryId = scanner.nextLine();
        try {
            Category existingCategory = categoryDao.findById(categoryId);
            if (existingCategory == null) {
                System.out.println("Category not found.");
                return;
            }

            System.out.print("Enter new User ID (current: " + existingCategory.getUserId() + "): ");
            String userId = scanner.nextLine();
            System.out.print("Enter new Category Name (current: " + existingCategory.getCategoryName() + "): ");
            String categoryName = scanner.nextLine();

            existingCategory.setUserId(userId);
            existingCategory.setCategoryName(categoryName);

            categoryDao.update(existingCategory);
            System.out.println("Category updated successfully.");
        } catch (Exception e) {
            System.out.println("Failed to update category: " + e.getMessage());
        }
    }

    private static void deleteCategory() {
        System.out.print("\nEnter category ID to delete: ");
        String categoryId = scanner.nextLine();
        try {
            categoryDao.delete(categoryId);
            System.out.println("Category deleted successfully.");
        } catch (Exception e) {
            System.out.println("Failed to delete category: " + e.getMessage());
        }
    }

    private static void showAllCategories() {
        try {
            List<Category> categories = categoryDao.findAll();
            System.out.println("\n--- Category List ---");
            if (categories.isEmpty()) {
                System.out.println("No categories found.");
            } else {
                for (Category c : categories) {
                    System.out.println(c);
                }
            }
        } catch (Exception e) {
            System.out.println("Failed to retrieve categories: " + e.getMessage());
        }
    }

    // ===========================
    // Expense Operations
    // ===========================
    private static void expenseOperations() {
        while (true) {
            System.out.println("\n--- Expense Operations ---");
            System.out.println("1. Insert Expense");
            System.out.println("2. Update Expense");
            System.out.println("3. Delete Expense");
            System.out.println("4. Show All Expenses");
            System.out.println("5. Back to Main Menu");

            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    insertExpense();
                    break;
                case 2:
                    updateExpense();
                    break;
                case 3:
                    deleteExpense();
                    break;
                case 4:
                    showAllExpenses();
                    break;
                case 5:
                    return; // Go back to main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void insertExpense() {
        System.out.println("\nEnter expense details:");
        System.out.print("Expense ID: ");
        String expenseId = scanner.nextLine();
        System.out.print("User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Category ID: ");
        String categoryId = scanner.nextLine();
        System.out.print("Amount: ");
        int amount = 0;
        try {
            amount = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid amount. Please enter an integer.");
            scanner.nextLine(); // Clear invalid input
            return;
        }
        scanner.nextLine(); // Consume newline

        Expense newExpense = new Expense();
        newExpense.setExpenseId(expenseId);
        newExpense.setUserId(userId);
        newExpense.setCategoryId(categoryId);
        newExpense.setAmount(amount);
        newExpense.setDateExpense(LocalDate.now());

        try {
            expenseDao.insert(newExpense);
            System.out.println("Expense inserted successfully.");
        } catch (Exception e) {
            System.out.println("Failed to insert expense: " + e.getMessage());
        }
    }

    private static void updateExpense() {
        System.out.print("\nEnter expense ID to update: ");
        String expenseId = scanner.nextLine();
        try {
            Expense existingExpense = expenseDao.findById(expenseId);
            if (existingExpense == null) {
                System.out.println("Expense not found.");
                return;
            }

            System.out.print("Enter new User ID (current: " + existingExpense.getUserId() + "): ");
            String userId = scanner.nextLine();
            System.out.print("Enter new Category ID (current: " + existingExpense.getCategoryId() + "): ");
            String categoryId = scanner.nextLine();
            System.out.print("Enter new Amount (current: " + existingExpense.getAmount() + "): ");
            int amount = 0;
            try {
                amount = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid amount. Please enter an integer.");
                scanner.nextLine(); // Clear invalid input
                return;
            }
            scanner.nextLine(); // Consume newline

            existingExpense.setUserId(userId);
            existingExpense.setCategoryId(categoryId);
            existingExpense.setAmount(amount);

            expenseDao.update(existingExpense);
            System.out.println("Expense updated successfully.");
        } catch (Exception e) {
            System.out.println("Failed to update expense: " + e.getMessage());
        }
    }

    private static void deleteExpense() {
        System.out.print("\nEnter expense ID to delete: ");
        String expenseId = scanner.nextLine();
        try {
            expenseDao.delete(expenseId);
            System.out.println("Expense deleted successfully.");
        } catch (Exception e) {
            System.out.println("Failed to delete expense: " + e.getMessage());
        }
    }

    private static void showAllExpenses() {
        try {
            List<Expense> expenses = expenseDao.findAll();
            System.out.println("\n--- Expense List ---");
            if (expenses.isEmpty()) {
                System.out.println("No expenses found.");
            } else {
                for (Expense e : expenses) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println("Failed to retrieve expenses: " + e.getMessage());
        }
    }

    // ===========================
    // Notification Operations
    // ===========================
    private static void notificationOperations() {
        while (true) {
            System.out.println("\n--- Notification Operations ---");
            System.out.println("1. Insert Notification");
            System.out.println("2. Update Notification");
            System.out.println("3. Delete Notification");
            System.out.println("4. Show All Notifications");
            System.out.println("5. Back to Main Menu");

            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    insertNotification();
                    break;
                case 2:
                    updateNotification();
                    break;
                case 3:
                    deleteNotification();
                    break;
                case 4:
                    showAllNotifications();
                    break;
                case 5:
                    return; // Go back to main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void insertNotification() {
        System.out.println("\nEnter notification details:");
        System.out.print("Notification ID: ");
        String notifyId = scanner.nextLine();
        System.out.print("User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Message: ");
        String message = scanner.nextLine();
        System.out.print("Date of Push (YYYY-MM-DD): ");
        LocalDate datePush;
        try {
            datePush = LocalDate.parse(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid date format. Please enter in YYYY-MM-DD format.");
            return;
        }

        Notifications newNotification = new Notifications();
        newNotification.setNotifyId(notifyId);
        newNotification.setUserId(userId);
        newNotification.setMessage(message);
        newNotification.setDatePush(datePush);

        try {
            notificationDao.insert(newNotification);
            System.out.println("Notification inserted successfully.");
        } catch (Exception e) {
            System.out.println("Failed to insert notification: " + e.getMessage());
        }
    }

    private static void updateNotification() {
        System.out.print("\nEnter notification ID to update: ");
        String notifyId = scanner.nextLine();
        try {
            Notifications existingNotification = notificationDao.findById(notifyId);
            if (existingNotification == null) {
                System.out.println("Notification not found.");
                return;
            }

            System.out.print("Enter new User ID (current: " + existingNotification.getUserId() + "): ");
            String userId = scanner.nextLine();
            System.out.print("Enter new Message (current: " + existingNotification.getMessage() + "): ");
            String message = scanner.nextLine();
            System.out.print("Enter new Date of Push (YYYY-MM-DD) (current: " + existingNotification.getDatePush() + "): ");
            LocalDate datePush;
            try {
                datePush = LocalDate.parse(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid date format. Please enter in YYYY-MM-DD format.");
                return;
            }

            existingNotification.setUserId(userId);
            existingNotification.setMessage(message);
            existingNotification.setDatePush(datePush);

            notificationDao.update(existingNotification);
            System.out.println("Notification updated successfully.");
        } catch (Exception e) {
            System.out.println("Failed to update notification: " + e.getMessage());
        }
    }

    private static void deleteNotification() {
        System.out.print("\nEnter notification ID to delete: ");
        String notifyId = scanner.nextLine();
        try {
            notificationDao.delete(notifyId);
            System.out.println("Notification deleted successfully.");
        } catch (Exception e) {
            System.out.println("Failed to delete notification: " + e.getMessage());
        }
    }

    private static void showAllNotifications() {
        try {
            List<Notifications> notifications = notificationDao.findAll();
            System.out.println("\n--- Notification List ---");
            if (notifications.isEmpty()) {
                System.out.println("No notifications found.");
            } else {
                for (Notifications n : notifications) {
                    System.out.println(n);
                }
            }
        } catch (Exception e) {
            System.out.println("Failed to retrieve notifications: " + e.getMessage());
        }
    }

    // ===========================
    // Income Operations
    // ===========================
    private static void incomeOperations() {
        while (true) {
            System.out.println("\n--- Income Operations ---");
            System.out.println("1. Insert Income");
            System.out.println("2. Update Income");
            System.out.println("3. Delete Income");
            System.out.println("4. Show All Incomes");
            System.out.println("5. Back to Main Menu");

            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    insertIncome();
                    break;
                case 2:
                    updateIncome();
                    break;
                case 3:
                    deleteIncome();
                    break;
                case 4:
                    showAllIncomes();
                    break;
                case 5:
                    return; // Go back to main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void insertIncome() {
        System.out.println("\nEnter income details:");
        System.out.print("Income ID: ");
        String incomeId = scanner.nextLine();
        System.out.print("User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Amount: ");
        int amount = 0;
        try {
            amount = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid amount. Please enter an integer.");
            scanner.nextLine(); // Clear invalid input
            return;
        }
        scanner.nextLine(); // Consume newline
        System.out.print("Date of Salary (YYYY-MM-DD): ");
        LocalDate dateSalary;
        try {
            dateSalary = LocalDate.parse(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid date format. Please enter in YYYY-MM-DD format.");
            return;
        }

        Income newIncome = new Income();
        newIncome.setIncomeId(incomeId);
        newIncome.setUserId(userId);
        newIncome.setAmount(amount);
        newIncome.setDateSalary(dateSalary);

        try {
            incomeDao.insert(newIncome);
            System.out.println("Income inserted successfully.");
        } catch (Exception e) {
            System.out.println("Failed to insert income: " + e.getMessage());
        }
    }

    private static void updateIncome() {
        System.out.print("\nEnter income ID to update: ");
        String incomeId = scanner.nextLine();
        try {
            Income existingIncome = incomeDao.findById(incomeId);
            if (existingIncome == null) {
                System.out.println("Income not found.");
                return;
            }

            System.out.print("Enter new User ID (current: " + existingIncome.getUserId() + "): ");
            String userId = scanner.nextLine();
            System.out.print("Enter new Amount (current: " + existingIncome.getAmount() + "): ");
            int amount = 0;
            try {
                amount = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid amount. Please enter an integer.");
                scanner.nextLine(); // Clear invalid input
                return;
            }
            scanner.nextLine(); // Consume newline
            System.out.print("Enter new Date of Salary (YYYY-MM-DD) (current: " + existingIncome.getDateSalary() + "): ");
            LocalDate dateSalary;
            try {
                dateSalary = LocalDate.parse(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid date format. Please enter in YYYY-MM-DD format.");
                return;
            }

            existingIncome.setUserId(userId);
            existingIncome.setAmount(amount);
            existingIncome.setDateSalary(dateSalary);

            incomeDao.update(existingIncome);
            System.out.println("Income updated successfully.");
        } catch (Exception e) {
            System.out.println("Failed to update income: " + e.getMessage());
        }
    }

    private static void deleteIncome() {
        System.out.print("\nEnter income ID to delete: ");
        String incomeId = scanner.nextLine();
        try {
            incomeDao.delete(incomeId);
            System.out.println("Income deleted successfully.");
        } catch (Exception e) {
            System.out.println("Failed to delete income: " + e.getMessage());
        }
    }

    private static void showAllIncomes() {
        try {
            List<Income> incomes = incomeDao.findAll();
            System.out.println("\n--- Income List ---");
            if (incomes.isEmpty()) {
                System.out.println("No incomes found.");
            } else {
                for (Income i : incomes) {
                    System.out.println(i);
                }
            }
        } catch (Exception e) {
            System.out.println("Failed to retrieve incomes: " + e.getMessage());
        }
    }

    // ===========================
    // Budget Operations
    // ===========================
    private static void budgetOperations() {
        while (true) {
            System.out.println("\n--- Budget Operations ---");
            System.out.println("1. Insert Budget");
            System.out.println("2. Update Budget");
            System.out.println("3. Delete Budget");
            System.out.println("4. Show All Budgets");
            System.out.println("5. Back to Main Menu");

            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    insertBudget();
                    break;
                case 2:
                    updateBudget();
                    break;
                case 3:
                    deleteBudget();
                    break;
                case 4:
                    showAllBudgets();
                    break;
                case 5:
                    return; // Go back to main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void insertBudget() {
        System.out.println("\nEnter budget details:");
        System.out.print("Budget ID: ");
        String budgetId = scanner.nextLine();
        System.out.print("User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Category ID: ");
        String categoryId = scanner.nextLine();
        System.out.print("Amount: ");
        int amount = 0;
        try {
            amount = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid amount. Please enter an integer.");
            scanner.nextLine(); // Clear invalid input
            return;
        }
        scanner.nextLine(); // Consume newline
        System.out.print("Date of Start (YYYY-MM-DD): ");
        LocalDate dateStart;
        try {
            dateStart = LocalDate.parse(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid date format. Please enter in YYYY-MM-DD format.");
            return;
        }
        System.out.print("Date of End (YYYY-MM-DD): ");
        LocalDate dateEnd;
        try {
            dateEnd = LocalDate.parse(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid date format. Please enter in YYYY-MM-DD format.");
            return;
        }

        Budget newBudget = new Budget();
        newBudget.setBudgetId(budgetId);
        newBudget.setUserId(userId);
        newBudget.setCategoryId(categoryId);
        newBudget.setAmount(amount);
        newBudget.setDateStart(dateStart);
        newBudget.setDateEnd(dateEnd);

        try {
            budgetDao.insert(newBudget);
            System.out.println("Budget inserted successfully.");
        } catch (Exception e) {
            System.out.println("Failed to insert budget: " + e.getMessage());
        }
    }

    private static void updateBudget() {
        System.out.print("\nEnter budget ID to update: ");
        String budgetId = scanner.nextLine();
        try {
            Budget existingBudget = budgetDao.findById(budgetId);
            if (existingBudget == null) {
                System.out.println("Budget not found.");
                return;
            }

            System.out.print("Enter new User ID (current: " + existingBudget.getUserId() + "): ");
            String userId = scanner.nextLine();
            System.out.print("Enter new Category ID (current: " + existingBudget.getCategoryId() + "): ");
            String categoryId = scanner.nextLine();
            System.out.print("Enter new Amount (current: " + existingBudget.getAmount() + "): ");
            int amount = 0;
            try {
                amount = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid amount. Please enter an integer.");
                scanner.nextLine(); // Clear invalid input
                return;
            }
            scanner.nextLine(); // Consume newline
            System.out.print("Enter new Date of Start (YYYY-MM-DD) (current: " + existingBudget.getDateStart() + "): ");
            LocalDate dateStart;
            try {
                dateStart = LocalDate.parse(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid date format. Please enter in YYYY-MM-DD format.");
                return;
            }
            System.out.print("Enter new Date of End (YYYY-MM-DD) (current: " + existingBudget.getDateEnd() + "): ");
            LocalDate dateEnd;
            try {
                dateEnd = LocalDate.parse(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid date format. Please enter in YYYY-MM-DD format.");
                return;
            }

            existingBudget.setUserId(userId);
            existingBudget.setCategoryId(categoryId);
            existingBudget.setAmount(amount);
            existingBudget.setDateStart(dateStart);
            existingBudget.setDateEnd(dateEnd);

            budgetDao.update(existingBudget);
            System.out.println("Budget updated successfully.");
        } catch (Exception e) {
            System.out.println("Failed to update budget: " + e.getMessage());
        }
    }

    private static void deleteBudget() {
        System.out.print("\nEnter budget ID to delete: ");
        String budgetId = scanner.nextLine();
        try {
            budgetDao.delete(budgetId);
            System.out.println("Budget deleted successfully.");
        } catch (Exception e) {
            System.out.println("Failed to delete budget: " + e.getMessage());
        }
    }

    private static void showAllBudgets() {
        try {
            List<Budget> budgets = budgetDao.findAll();
            System.out.println("\n--- Budget List ---");
            if (budgets.isEmpty()) {
                System.out.println("No budgets found.");
            } else {
                for (Budget b : budgets) {
                    System.out.println(b);
                }
            }
        } catch (Exception e) {
            System.out.println("Failed to retrieve budgets: " + e.getMessage());
        }
    }
}
