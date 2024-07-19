package com.js.checkapi.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.js.checkapi.vo.Member;

@Component
public interface MemberMapper {
    public List<Member> getMemberList();

    public Member getMemberOne(Long memberid);

    public Member getMemberByEmail(String email);

    public int isExistEmail(String email);

    public void saveMember(Member member);
}
