package com.project.freeboard.domain.dto;

import com.project.freeboard.domain.entity.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private String name;


    public String getDto(CategoryEntity entity) {
        return entity.getName();
    }

    public List<String> getDto(List<CategoryEntity> entity) {
        List<String> dtoList = new ArrayList<>();
        for(CategoryEntity categoryEntity : entity) {
            dtoList.add(getDto(categoryEntity));
        }

        return dtoList;
    }
}
