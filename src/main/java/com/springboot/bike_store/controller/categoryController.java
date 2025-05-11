package com.springboot.bike_store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bike_store.entity.Category;
import com.springboot.bike_store.service.CategoryService;

@RestController
@RequestMapping("/category")
public class categoryController {
    
    @Autowired
    CategoryService categoryService;

    @GetMapping("c")
    public ResponseEntity<List<Category>> getCategories()
    {
        return categoryService.getCategories();
    }
}
