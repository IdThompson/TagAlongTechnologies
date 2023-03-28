package com.idowu.tagalongtechnologies.dto.response;

import lombok.*;

import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {
    private HashMap<String, Object> response = new HashMap<>();
}
