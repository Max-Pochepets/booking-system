package com.booking.service.controller;

import com.booking.service.dto.UserResponseDto;
import com.booking.service.model.User;
import com.booking.service.service.UserMapper;
import com.booking.service.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @ResponseBody
    @GetMapping("/{user_id}")
    public UserResponseDto getUser(@PathVariable("user_id") Long id) {
        return userMapper.toDto(userService.get(id));
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        return userService.listUsers().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/inject")
    public String inject() {
        User[] users = new User[4];
        for (int i = 0; i < users.length; i++) {
            users[i] = new User();
            users[i].setName("User " + i);
            userService.add(users[i]);
        }
        return "Users injected!";
    }
}
