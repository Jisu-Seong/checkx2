package com.js.checkapi.repository;

import java.util.List;

import javax.swing.Spring;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.js.checkapi.vo.Member;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
@RunWith(SpringRunner.class)
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void testGetMemberByEmail() {
        String email = "qwer@qwer.com";
        Member member = memberRepository.getMemberByEmail(email);
        log.info("member: " + member.toString());
        Assert.notNull(member, "not null");
    }

    @Test
    void testGetMemberList() {

    }

    @Test
    void testGetMemberOne() {

    }

    @Test
    void testIsExistEmail() {

    }

    @Test
    void testSaveMember() {

    }
}
