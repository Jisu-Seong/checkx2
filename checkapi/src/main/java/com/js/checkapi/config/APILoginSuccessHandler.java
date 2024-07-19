package com.js.checkapi.config;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.js.checkapi.repository.MemberRepository;
import com.js.checkapi.vo.Member;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class APILoginSuccessHandler implements AuthenticationSuccessHandler {

    private final MemberRepository memberRepository;

    @Autowired
    public APILoginSuccessHandler(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

                log.info("----------------------------------");
                log.info(authentication);
                log.info("----------------------------------");

                String email = authentication.getName();
                Member member = memberRepository.getMemberByEmail(email);
                
                Gson gson = new Gson();

                Map<String, Object> map = new HashMap<>();
                
                map.put("email", email);
                map.put("nickname", member.getNickname());
                // map.put("joindate", member.getJoindate());
                map.put("profileimg", member.getProfileimg());

                String jsonStr = gson.toJson(map);

                response.setContentType("application/json; charset=UTF-8");
                PrintWriter printWriter = response.getWriter();
                printWriter.println(jsonStr);
                printWriter.close();

            }
    
}
