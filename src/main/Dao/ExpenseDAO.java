package com.sms.dao;

import demo.com.expense_tracker.entities.Expense;
import java.util.List;

public interface ExpenseDAO {
    void insert(Expense expense);
    void update(Expense expense);
    void delete(String expenseId);
    Expense findById(String expenseId);
    List<Expense> findAll();
}
