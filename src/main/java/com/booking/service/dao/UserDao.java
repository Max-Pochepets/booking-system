package com.booking.service.dao;

import com.booking.service.model.User;
import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();
}
