package com.sms.dao;

import demo.com.expense_tracker.entities.Payment;

import java.util.List;

public interface PaymentDAO {
    void insert(Payment payment);
    void update(Payment payment);
    void delete(String paymentId);
    Payment findById(String paymentId);
    List<Payment> findAll();
}
