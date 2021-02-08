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
        String name = "";
        for (int i = 0; i < users.length; i++) {
            users[i] = new User();
            switch (i) {
                case 0:
                case 3: {
                    name += "A";
                    break;
                }
                case 1:
                case 2: {
                    name += "B";
                    break;
                }
                default: break;
            }
            users[i].setName(name);
            userService.add(users[i]);
        }
        return "Users injected!";
    }
}
