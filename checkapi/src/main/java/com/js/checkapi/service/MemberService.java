package com.js.checkapi.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.js.checkapi.dto.JoinRequestDTO;
import com.js.checkapi.repository.MemberRepository;
import com.js.checkapi.vo.Member;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class MemberService {
    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    public Member getMemberOne(Long memberid) {
        return memberRepository.getMemberOne(memberid);
    }

    public boolean join(JoinRequestDTO joinRequestDTO) {
        int num = memberRepository.isExistEmail(joinRequestDTO.getEmail());
        log.info(num);
        
        if (num == 0) {
            Member member = Member.toMember(joinRequestDTO, passwordEncoder);
            memberRepository.saveMember(member);
            return true;
        } else {
            return false;
        }
    }

}
