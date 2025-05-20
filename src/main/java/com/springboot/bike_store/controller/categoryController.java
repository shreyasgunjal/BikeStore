package com.springboot.bike_store.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bike_store.entity.Category;
import com.springboot.bike_store.service.CategoryService;

@RestController
@RequestMapping("/category")
public class categoryController {
    
    @Autowired
    CategoryService categoryService;

    @GetMapping("allCategories")
    public ResponseEntity<List<Category>> getCategories()
    {
        return categoryService.getCategories();
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Category>> getCategory(@PathVariable Integer id)
    {
        return categoryService.getCategory(id);
    }

    @PostMapping("addCategory")
    public String addCategory(@RequestBody Category category)
    {
        return categoryService.addCategory(category);
    }

    @PutMapping("edit/{id}")
    public String updateCategory(@PathVariable Integer id, @RequestBody Category category)
    {
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("delete/{id}")
    public String deleteCategory(@PathVariable Integer id)
    {
        return categoryService.deleteCategory(id);
    }
}
