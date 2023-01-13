package com.project.freeboard.service;

import com.project.freeboard.domain.entity.CategoryEntity;
import com.project.freeboard.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryEntity> getAllCategory() {
        return categoryRepository.findAll();
    }
}
