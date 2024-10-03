// src/main/java/com/sms/dao/IncomeDAO.java
package com.sms.dao;

import demo.com.expense_tracker.entities.Income;
import java.util.List;

public interface IncomeDAO {
    void insert(Income income);
    void update(Income income);
    void delete(String incomeId);
    Income findById(String incomeId);
    List<Income> findAll();
}
