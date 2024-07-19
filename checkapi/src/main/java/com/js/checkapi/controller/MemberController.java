package com.js.checkapi.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.js.checkapi.dto.JoinRequestDTO;
import com.js.checkapi.service.MemberService;
import com.js.checkapi.vo.Member;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/auth")
@Log4j2
public class MemberController {
    private final MemberService memberService;

    // @PostMapping("/{memberid}")
    // public ResponseEntity<Member> postMethodName(@PathVariable(name="memberid") Long memberid) {
    //     Member member = memberService.getMemberOne(memberid);
    //     return new ResponseEntity<>(member, HttpStatus.OK);
        
    // }

    @PostMapping("/join")
    public Map<String, String> join(@ModelAttribute JoinRequestDTO joinRequestDTO) {
        String email = joinRequestDTO.getEmail();
        String password = joinRequestDTO.getPassword();
        String nickname = joinRequestDTO.getNickname();
        log.info("=====================================join request info=================================");
        log.info(email);
        log.info(password);
        log.info(nickname);

        if (email.length() == 0 || password.length() == 0 || nickname.length() == 0) {
            return Map.of("MESSAGE", "ERROR");
        }

        boolean result = memberService.join(joinRequestDTO);

        if (result) {
            return Map.of("MESSAGE", "SUCCESS");
        } else {
            return Map.of("MESSAGE", "EXIST");
        }
           
    }
    
}
