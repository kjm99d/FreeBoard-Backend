package com.project.freeboard.domain.entity;

import com.project.freeboard.domain.ContentType;
import jakarta.persistence.*;

@Entity(name = "POST")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private MemberEntity writer;

    @Column
    private boolean secret; // 비밀글 여부

    @Column
    private String subject;

    @Column
    private ContentType contentType;

    @Column
    private String content;

    // 댓글 .. ?

}
