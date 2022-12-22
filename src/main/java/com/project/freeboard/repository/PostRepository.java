package com.project.freeboard.repository;

import com.project.freeboard.domain.ContentType;
import com.project.freeboard.domain.entity.MemberEntity;
import com.project.freeboard.domain.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface PostRepository extends JpaRepository<PostEntity, Long> {
    Optional<PostEntity> findBySubject(String subject); // 일치하는 제목으로 찾기
    //Optional<PostEntity> findBySubjectIn(String subject); // 파라미터가 포함되는 내용으로 찾기
    Optional<PostEntity> findByContentType(ContentType type); // 타입으로 찾기
    Optional<PostEntity> findByWriter(MemberEntity writer);
}
