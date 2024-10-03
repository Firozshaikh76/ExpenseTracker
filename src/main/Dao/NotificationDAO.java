// src/main/java/com/sms/dao/NotificationDAO.java
package com.sms.dao;

import demo.com.expense_tracker.entities.Notifications;
import java.util.List;

public interface NotificationDAO {
    void insert(Notifications notification);
    void update(Notifications notification);
    void delete(String notifyId);
    Notifications findById(String notifyId);
    List<Notifications> findAll();
}
