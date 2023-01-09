package com.project.freeboard.repository;

import com.project.freeboard.AutoAppConfig;
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
public class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;

    @BeforeEach
    public void BeforeEachClearRepository() {
        categoryRepository.deleteAll();
    }

    @Test
    @DisplayName("카테고리 레포지토리 필드가 NULL이 아니다.")
    public void CategoryRepositoryIsNotNull() {
        Assertions.assertThat(categoryRepository).isNotNull();
    }
}
