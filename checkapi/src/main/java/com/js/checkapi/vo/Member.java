package com.js.checkapi.vo;

import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.js.checkapi.dto.JoinRequestDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Member {
    private Long memberid;
    private String email;
    private String password;
    private String nickname;
    private Blob profileimg;
    private LocalDateTime joindate;
    private Boolean social;
    private String role;


    public static Member toMember(JoinRequestDTO joinRequestDTO, PasswordEncoder passwordEncoder) {
        Member member = Member.builder()
        .email(joinRequestDTO.getEmail())
        .password(passwordEncoder.encode(joinRequestDTO.getPassword()))
        .nickname(joinRequestDTO.getNickname())
        .social(false)
        .build();

        member.setRole("USER");

        return member;
    }
}
