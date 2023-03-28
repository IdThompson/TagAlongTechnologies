package com.idowu.tagalongtechnologies.service.implementation;

import com.idowu.tagalongtechnologies.dto.request.UserRequestDto;
import com.idowu.tagalongtechnologies.dto.response.UserResponseDto;
import com.idowu.tagalongtechnologies.entity.User;
import com.idowu.tagalongtechnologies.exceptions.BadRequestException;
import com.idowu.tagalongtechnologies.exceptions.NotFoundException;
import com.idowu.tagalongtechnologies.repository.UserRepository;
import com.idowu.tagalongtechnologies.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public UserResponseDto saveUser(UserRequestDto userDto) throws Exception {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        try {
            userRepository.save(user);
        } catch (Exception e) {
            throw new BadRequestException("Bad request");
        }
        return new UserResponseDto();
    }

    @Override
    public UserResponseDto getDataWithEmailAndPassword(String email, String password) {
        Optional<User> checkedUser = userRepository.findByEmailAndPassword(email, password);
//        User user = checkedUser.orElseThrow(()->new NotFoundException("User not found"));
        return new UserResponseDto();
    }


}
