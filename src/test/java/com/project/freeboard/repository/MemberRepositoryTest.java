package com.project.freeboard.repository;

import com.project.freeboard.AutoAppConfig;
import com.project.freeboard.domain.entity.MemberEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@ActiveProfiles("test")
@SpringBootTest
@ContextConfiguration(classes = AutoAppConfig.class)
public class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void BeforeEach() {
        memberRepository.deleteAll();
    }

    @Test
    @DisplayName("멤버를 3명 추가할 수 있어야한다.")
    void AddMember3() {
        for(int i = 0; i < 3; ++i)
            memberRepository.save(new MemberEntity("Member_"+i, "Member_"+i, "Member_"+i + "@naver.com"));

        final Long memberCount = memberRepository.count();
        Assertions.assertThat(memberCount).isEqualTo(3);
    }
}
