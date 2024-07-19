package com.js.checkapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.js.checkapi.mapper.MemberMapper;
import com.js.checkapi.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Configuration
@RequiredArgsConstructor
@Log4j2
public class MybatisConfig {
    private final MemberMapper memberMapper;

    @Bean
    public MemberRepository memberRepository() {
        log.info("MyBatisMemberRepository Config");
        return new MemberRepository(memberMapper);
    }
}
