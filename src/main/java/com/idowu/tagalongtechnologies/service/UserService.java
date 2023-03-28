package com.idowu.tagalongtechnologies.service;

import com.idowu.tagalongtechnologies.dto.request.UserRequestDto;
import com.idowu.tagalongtechnologies.dto.response.UserResponseDto;
import com.idowu.tagalongtechnologies.entity.User;

public interface UserService {
    UserResponseDto saveUser(UserRequestDto userDto) throws Exception;

    UserResponseDto getDataWithEmailAndPassword(String email, String password);
}
