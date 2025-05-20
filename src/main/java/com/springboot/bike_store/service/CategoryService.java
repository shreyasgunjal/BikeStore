package com.springboot.bike_store.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


    public ResponseEntity<Optional<Category>> getCategory(Integer id) {
        try {
            Optional<Category> existingid = categoryDao.findById(id);
            if(existingid.isPresent())
            {
                return new ResponseEntity<>(existingid, HttpStatus.OK);
            }
            // else
            // {
            //     return new ResponseEntity<>(Optional.empty(), HttpStatus.NOT_FOUND);
            // }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(Optional.empty(), HttpStatus.BAD_REQUEST);
    }


    public String addCategory(Category category) {
        if (categoryDao.existsById((int)category.getCategory_id())) {
            return "ID already exists!!";
        }

            categoryDao.save(category);
            return "success";
    
    }


    public String updateCategory(Integer id, Category category) {
        Optional<Category> existingcat = categoryDao.findById(id);
        if(existingcat.isPresent())
        {
            if(category.getCategory_name() == null || category.getCategory_name().trim().isEmpty())
            {
                return "failed: category name is null or empty";
            }
            Category updatedcat = existingcat.get();
            updatedcat.setCategory_name(category.getCategory_name());
            categoryDao.save(updatedcat);
            return "Updated Successfully!";
        }else
        {
            return "failed to update";
        }
    }


    public String deleteCategory(Integer id) {
        if (categoryDao.existsById(id)) 
        {
            categoryDao.deleteById(id);
            return "Deleted Successfully";
        }else
        {
            return "ID not present";
        }

    }
    
}
