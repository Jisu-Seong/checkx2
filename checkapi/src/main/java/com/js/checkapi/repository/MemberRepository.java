package com.js.checkapi.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.js.checkapi.mapper.MemberMapper;
import com.js.checkapi.vo.Member;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberRepository implements MemberMapper{

    private final MemberMapper memberMapper;

    @Override
    public List<Member> getMemberList() {
        return memberMapper.getMemberList();
    }

    @Override
    public Member getMemberOne(Long memberid) {
        return memberMapper.getMemberOne(memberid);
    }

    @Override
    public int isExistEmail(String email) {
        return memberMapper.isExistEmail(email);
    }

    @Override
    public void saveMember(Member member) {
        memberMapper.saveMember(member);
    }

    @Override
    public Member getMemberByEmail(String email) {
        return memberMapper.getMemberByEmail(email);
    }

    
    
}
