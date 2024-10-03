// src/main/java/com/sms/dao/BudgetDAO.java
package com.sms.dao;

import demo.com.expense_tracker.entities.Budget;
import java.util.List;

public interface BudgetDAO {
    void insert(Budget budget);
    void update(Budget budget);
    void delete(String budgetId);
    Budget findById(String budgetId);
    List<Budget> findAll();
}
