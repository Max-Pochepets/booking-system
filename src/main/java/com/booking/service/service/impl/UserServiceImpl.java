package com.booking.service.service.impl;

import com.booking.service.dao.UserDao;
import com.booking.service.model.User;
import com.booking.service.service.UserService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public User get(Long id) {
        return userDao.get(id).orElseThrow(() -> new RuntimeException("There is no user by id "
                                                                + id + "."));
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
}
