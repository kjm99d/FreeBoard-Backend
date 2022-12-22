package com.project.freeboard.runner;

import com.project.freeboard.domain.entity.CategoryEntity;
import com.project.freeboard.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
@RequiredArgsConstructor
public class CategoryRunner implements CommandLineRunner {
    private final CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        final String strClassName = new Object(){}.getClass().getEnclosingClass().getName();
        System.out.println(">>> " + strClassName + " Start !");

        categoryRepository.save(new CategoryEntity("Category1"));
        categoryRepository.save(new CategoryEntity("Category2"));
        categoryRepository.save(new CategoryEntity("Category3"));
    }
}
