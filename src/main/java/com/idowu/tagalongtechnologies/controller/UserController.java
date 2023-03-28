package com.idowu.tagalongtechnologies.controller;

import com.idowu.tagalongtechnologies.dto.request.UserRequestDto;
import com.idowu.tagalongtechnologies.dto.response.UserResponseDto;
import com.idowu.tagalongtechnologies.entity.User;
import com.idowu.tagalongtechnologies.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class UserController {
    private final UserService userService;
    @PostMapping("/postData")
    public ResponseEntity<?> postData(@RequestBody @Valid UserRequestDto userDto) throws Exception {
            log.info("Inside postData of UserController");
            try {
                UserResponseDto user = userService.saveUser(userDto);
                Map<String, Object> response = new HashMap<>();
                log.info("Returning an empty Map");
                return new ResponseEntity<>(user, HttpStatus.CREATED);
            } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("/getData")
    public ResponseEntity<?> getData(@RequestParam String email, @RequestParam String password) {
        log.info("Inside getData of UserController");
        try {
            UserResponseDto response = userService.getDataWithEmailAndPassword(email, password);
            log.info("Returning an empty Map");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }


}
