package com.sms.dao;

import demo.com.expense_tracker.entities.user;

import java.util.List;

public interface UserDAO {
    void insert(user user);
    void update(user user);
    void delete(String userId);
    user findById(String userId);
    List<user> findAll();
}
