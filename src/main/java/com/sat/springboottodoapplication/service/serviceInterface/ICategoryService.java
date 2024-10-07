package com.sat.springboottodoapplication.service.serviceInterface;

import com.sat.springboottodoapplication.DAO.model.Category;
import com.sat.springboottodoapplication.service.DTO.CategoryDTO;

import java.util.List;

public interface ICategoryService {
    List<CategoryDTO> getAllCategories();
    CategoryDTO getCategoryById(Long id);
    CategoryDTO saveCategory (CategoryDTO categoryDTO);
    CategoryDTO updateCategory (CategoryDTO categoryDTO);
    void deleteCategoryById (Long id);
}
