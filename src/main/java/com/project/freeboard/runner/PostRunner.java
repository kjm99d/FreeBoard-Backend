package com.project.freeboard.runner;

import com.project.freeboard.domain.ContentType;
import com.project.freeboard.domain.entity.CategoryEntity;
import com.project.freeboard.domain.entity.PostEntity;
import com.project.freeboard.repository.CategoryRepository;
import com.project.freeboard.repository.MemberRepository;
import com.project.freeboard.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Profile("!test")
@Order(3)
@Component
@RequiredArgsConstructor
public class PostRunner implements CommandLineRunner {
    private final MemberRepository memberRepository;
    private final CategoryRepository categoryRepository;
    private final PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        final String strClassName = new Object(){}.getClass().getEnclosingClass().getName();
        System.out.println(">>> " + strClassName + " Start !");

        // (CategoryEntity category, MemberEntity writer, boolean secret, String subject, ContentType contentType, String content)
        postRepository.save(new PostEntity(
                categoryRepository.findByName("Category1").get(),
                memberRepository.findByUsername("userA").get(),
                false,
                "Hello World",
                ContentType.TYPE_STRING,
                "abcdefgh"
                ));
    }
}
