package com.js.checkapi.dto;

import lombok.Data;

@Data
public class JoinRequestDTO {
    private String email;
    private String password;
    private String nickname;
}
