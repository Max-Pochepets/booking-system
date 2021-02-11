package com.booking.service.dao;

import com.booking.service.model.User;
import java.util.List;
import java.util.Optional;

public interface UserDao {
    void add(User user);

    Optional<User> get(Long id);

    List<User> listUsers();
}
