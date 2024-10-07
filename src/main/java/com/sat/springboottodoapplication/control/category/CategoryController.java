package com.sat.springboottodoapplication.control.category;

import com.sat.springboottodoapplication.service.DTO.CategoryDTO;
import com.sat.springboottodoapplication.service.serviceInterface.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping(path = "/category/v1")
public class CategoryController {

    @Autowired
    private ICategoryService icategoryService;

    /**
     * This method is called when a GET request is made
     * URL: localhost:8080/category/v1/
     * Purpose: Fetches all the categories in the category table
     * @return List of categories
     */
    @GetMapping("/")
    public ResponseEntity<List<CategoryDTO>> getAllCategories(){
        return ResponseEntity.ok().body(icategoryService.getAllCategories());
    }

    /**
     * This method is called when a GET request is made
     * URL: localhost:8080/category/v1/1 (or any other id)
     * Purpose: Fetches category with the given id
     * @param id - category id
     * @return category with the given id
     */
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id)
    {
        return ResponseEntity.ok().body(icategoryService.getCategoryById(id));
    }

    /**
     * This method is called when a POST request is made
     * URL: localhost:8080/category/v1/
     * Purpose: Save a Category entity
     * @param category - Request body is a Category entity
     * @return Saved Category entity
     */
    @PostMapping("")
    public ResponseEntity<CategoryDTO> saveCategory(@RequestBody CategoryDTO category)
    {
        return ResponseEntity.ok().body(icategoryService.saveCategory(category));
    }

    /**
     * This method is called when a PUT request is made
     * URL: localhost:8080/category/v1/
     * Purpose: Update a Category entity
     * @param category - Category entity to be updated
     * @return Updated Category
     */
    @PutMapping("/")
    public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO category)
    {
        return ResponseEntity.ok().body(icategoryService.updateCategory(category));
    }

    /**
     * This method is called when a PUT request is made
     * URL: localhost:8080/category/v1/1 (or any other id)
     * Purpose: Delete a Category entity
     * @param id - category's id to be deleted
     * @return a String message indicating category record has been deleted successfully
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable Long id)
    {
        icategoryService.deleteCategoryById(id);
        return ResponseEntity.ok().body("Deleted category successfully");
    }

}
