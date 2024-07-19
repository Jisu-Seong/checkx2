package com.js.checkapi.vo;

import java.sql.Blob;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Member {
    private Long memberid;
    private String email;
    private String password;
    private String nickname;
    private Blob profileimg;
    private LocalDateTime joindate;

}
