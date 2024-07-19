package com.js.checkapi.repository;

import java.util.List;

import com.js.checkapi.mapper.MemberMapper;
import com.js.checkapi.vo.Member;

import lombok.RequiredArgsConstructor;

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
    
}
