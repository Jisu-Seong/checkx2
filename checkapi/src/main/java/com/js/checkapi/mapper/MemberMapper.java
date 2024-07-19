package com.js.checkapi.mapper;

import java.util.List;

import com.js.checkapi.vo.Member;

public interface MemberMapper {
    public List<Member> getMemberList();

    public Member getMemberOne(Long memberid);

    public int isExistEmail(String email);

    public void saveMember(Member member);
}
