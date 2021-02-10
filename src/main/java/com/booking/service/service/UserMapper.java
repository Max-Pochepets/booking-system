package com.booking.service.service;

import com.booking.service.dto.UserResponseDto;
import com.booking.service.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponseDto toDto(User inputUser) {
        UserResponseDto userDto = new UserResponseDto();
        userDto.setId(inputUser.getId());
        userDto.setName(inputUser.getName());
        userDto.setSurname(inputUser.getSurname());
        return userDto;
    }
}
