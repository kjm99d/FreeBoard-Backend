package com.project.freeboard.controller;

import com.project.freeboard.domain.dto.CategoryDto;
import com.project.freeboard.domain.entity.CategoryEntity;
import com.project.freeboard.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
//@RequestMapping("/api/category/{category_id}")
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/list")
    public ResponseEntity<Object> getCategoryList() {

        List<CategoryEntity> categoryList = categoryService.getAllCategory();
        List<String> categories = new CategoryDto().getDto(categoryList);

        ResponseEntity response = new ResponseEntity<>(categories, null, HttpStatus.OK);

        return response;
    }

}
