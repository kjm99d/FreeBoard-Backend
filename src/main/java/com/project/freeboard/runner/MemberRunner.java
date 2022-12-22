package com.project.freeboard.runner;

import com.project.freeboard.domain.entity.MemberEntity;
import com.project.freeboard.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
@RequiredArgsConstructor
public class MemberRunner implements CommandLineRunner {
    private final MemberRepository memberRepository;

    @Override
    public void run(String... args) throws Exception {
        final String strClassName = new Object(){}.getClass().getEnclosingClass().getName();
        System.out.println(">>> " + strClassName + " Start !");


        memberRepository.save(new MemberEntity("userA", "userApassword", "userA@naver.com"));
        memberRepository.save(new MemberEntity("userB", "userBpassword", "userB@naver.com"));
        memberRepository.save(new MemberEntity("userC", "userCpassword", "userC@naver.com"));
    }
}
