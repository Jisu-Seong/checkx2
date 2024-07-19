package com.js.checkapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.js.checkapi.service.MemberService;
import com.js.checkapi.vo.Member;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@Transactional
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/getMemberOne/{memberid}")
    public Member postMethodName(@PathVariable(name="memberid") Long memberid) {
        return memberService.getMemberOne(memberid);
    }
    
}
