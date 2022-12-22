package com.project.freeboard.domain.entity;

import com.project.freeboard.domain.ContentType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "POST")
@Getter
@Setter
@NoArgsConstructor
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

    public PostEntity(CategoryEntity category, MemberEntity writer, boolean secret, String subject, ContentType contentType, String content) {
        this.category = category;
        this.writer = writer;
        this.secret = secret;
        this.subject = subject;
        this.contentType = contentType;
        this.content = content;
    }

    // 댓글 .. ?

}
