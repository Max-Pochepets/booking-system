package com.booking.service;

import com.booking.service.config.AppConfig;
import com.booking.service.model.User;
import com.booking.service.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        User user = new User();
        user.setName("Bob");
        user.setSurname("Alison");
        userService.add(user);
        userService.listUsers().forEach(System.out::println);
    }
}
