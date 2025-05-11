package com.springboot.bike_store.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.bike_store.dao.CategoryDao;
import com.springboot.bike_store.entity.Category;

@Service
public class CategoryService {

    @Autowired
    CategoryDao categoryDao;


    public ResponseEntity<List<Category>> getCategories() {
        try 
        {
            return new ResponseEntity<>(categoryDao.findAll(), HttpStatus.OK);
        } catch (Exception ex)
        {
            ex.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }
    
}
