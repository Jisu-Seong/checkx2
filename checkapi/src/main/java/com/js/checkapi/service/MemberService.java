package com.js.checkapi.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.js.checkapi.repository.MemberRepository;
import com.js.checkapi.vo.Member;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member getMemberOne(Long memberid) {
        return memberRepository.getMemberOne(memberid);
    }

}
