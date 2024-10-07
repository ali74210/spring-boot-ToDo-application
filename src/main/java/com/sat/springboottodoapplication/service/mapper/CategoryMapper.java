package com.sat.springboottodoapplication.service.mapper;

import com.sat.springboottodoapplication.DAO.model.Category;
import com.sat.springboottodoapplication.service.DTO.CategoryDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDTO toDto(Category category);
    @InheritInverseConfiguration
    Category toEntity(CategoryDTO categoryDTO);
}

