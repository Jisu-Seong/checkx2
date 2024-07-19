package com.js.checkapi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.js.checkapi.vo.Member;

@Mapper
public interface MemberMapper {
    public List<Member> getMemberList();

    public Member getMemberOne(Long memberid);
}
