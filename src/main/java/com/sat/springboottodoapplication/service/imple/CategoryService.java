package com.sat.springboottodoapplication.service.imple;


import com.sat.springboottodoapplication.DAO.impl.CategoryRepo;
import com.sat.springboottodoapplication.DAO.model.Category;
import com.sat.springboottodoapplication.service.DTO.CategoryDTO;
import com.sat.springboottodoapplication.service.mapper.CategoryMapper;
import com.sat.springboottodoapplication.service.serviceInterface.ICategoryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CategoryService implements ICategoryService {
    
    @Autowired
    private final CategoryRepo categoryRepo;

    @Autowired
    private CategoryMapper categoryMapper;

    public CategoryService(CategoryRepo categoryRepo, CategoryMapper categoryMapper) {
        this.categoryRepo = categoryRepo;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepo.findAll();
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        categories.forEach(category -> {
            categoryDTOS.add(categoryMapper.toDto(category));
        });
        return categoryDTOS;
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        Category category = categoryRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        return categoryMapper.toDto(category);
    }

    @Override
    public CategoryDTO saveCategory(CategoryDTO categoryDTO) {
        categoryRepo.save(categoryMapper.toEntity(categoryDTO));
        return categoryDTO;
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO) {
        Optional<Category> existingCategory = categoryRepo.findById(categoryMapper.toEntity(categoryDTO).getId());
        Category updatedCategory = categoryRepo.save(existingCategory.get());
        return categoryMapper.toDto(updatedCategory);
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepo.deleteById(id);
    }
}
