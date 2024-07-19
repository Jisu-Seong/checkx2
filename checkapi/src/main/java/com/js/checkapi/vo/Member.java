package com.js.checkapi.vo;

import java.sql.Blob;
import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.js.checkapi.dto.JoinRequestDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Member {
    private Long memberid;
    private String email;
    private String password;
    private String nickname;
    private Blob profileimg;
    private LocalDateTime joindate;

    public static Member toMember(JoinRequestDTO joinRequestDTO, PasswordEncoder passwordEncoder) {
        Member member = Member.builder()
        .email(joinRequestDTO.getEmail())
        .password(joinRequestDTO.getPassword())
        .nickname(joinRequestDTO.getNickname())
        .build();
        return member;
    }

    
}
