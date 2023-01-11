package com.project.freeboard.repository;

import com.project.freeboard.AutoAppConfig;
import com.project.freeboard.domain.entity.CategoryEntity;
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
        System.out.println("Clear");
        categoryRepository.deleteAll();
    }

    @Test
    @DisplayName("카테고리 레포지토리 필드가 NULL이 아니다.")
    public void CategoryRepositoryIsNotNull() {
        Assertions.assertThat(categoryRepository).isNotNull();
    }

    @Test
    @DisplayName("카테고리를 3개 추가한 경우, 총 데이터는 3개이다.")
    public void Add3CategoryIsEqauls3() {
        for(int i = 0; i < 3; ++i) {
            categoryRepository.save(new CategoryEntity("Category" + i));
        }

        org.junit.jupiter.api.Assertions.assertEquals(categoryRepository.count(), 3);
    }

    @Test
    @DisplayName("카테고리를 2개 추가한 경우, 총 데이터는 3개가 아니다.")
    public void Add3CategoryIsNotEqauls3() {
        for (int i = 0; i < 2; ++i) {
            categoryRepository.save(new CategoryEntity("Category" + i));
        }

        Assertions.assertThat(categoryRepository.count()).isNotEqualTo(3);
    }

    @Test
    @DisplayName("Category0-2 까지 추가한 후, Board 라는 이름으로 카테고리를 찾으면 isPresent()는 false 이여야한다.")
    public void AddCategory0To2ButFindBoardIsPresentResultIsFalse() {
        for (int i = 0; i < 2; ++i) {
            categoryRepository.save(new CategoryEntity("Category" + i));
        }

        boolean entity = categoryRepository.findByName("Board").isPresent();

        Assertions.assertThat(entity).isEqualTo(false);
    }
}
