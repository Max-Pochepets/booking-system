package com.booking.service.service;

import com.booking.service.dto.UserResponseDto;
import com.booking.service.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponseDto toDto(User inputUser) {
        UserResponseDto userDto = new UserResponseDto();
        userDto.setName(inputUser.getName());
        userDto.setSurname(inputUser.getSurname());
        return userDto;
    }

    public User fromDto(UserResponseDto inputUserDto) {
        User user = new User();
        user.setName(inputUserDto.getName());
        user.setSurname(inputUserDto.getSurname());
        return user;
    }
}
