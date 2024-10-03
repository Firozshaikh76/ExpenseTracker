package com.sms.dao;

import demo.com.expense_tracker.entities.Category;
import java.util.List;

public interface CategoryDAO {
    void insert(Category category);
    void update(Category category);
    void delete(String categoryId);
    Category findById(String categoryId);
    List<Category> findAll();
}
