package com.springboot.bike_store.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.bike_store.dao.BrandDao;
import com.springboot.bike_store.entity.Brand;

@Service
public class BrandService {

    @Autowired
    BrandDao brandDao;

    public ResponseEntity<List<Brand>> getBrands() {
        try
        {
            return new ResponseEntity<>(brandDao.findAll(), HttpStatus.OK);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }

        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Optional<Brand>> getBrand(Integer id) {

            Optional<Brand> existing = brandDao.findById(id);
            if(existing.isPresent())
            {
                return new ResponseEntity<>(existing, HttpStatus.OK);
            }else
            {
                return new ResponseEntity<>(Optional.empty(),HttpStatus.NOT_FOUND);
            }
        
    }

    public String addBrand(Brand brand) {
        brandDao.save(brand);
        return "success";
    }

    public String updateBrand(Integer id, Brand brand) {
        Optional<Brand> existing = brandDao.findById(id); 
        if(existing.isPresent()) {
            if (brand.getBrand_name() == null || brand.getBrand_name().trim().isEmpty()) {
                return "failed: brand name is null or empty";
            }
    
            Brand toupdate = existing.get();
            toupdate.setBrand_name(brand.getBrand_name());
            brandDao.save(toupdate);
            return "success";
        } else 
        {
            return "failed";
        }
    }
    
    public String deleteBrand(Integer id)
    {
        if(brandDao.existsById(id))
        {
            brandDao.deleteById(id);
            return "successfully deleted";
        }else
        {
            return "ID not present";
        }
    }


}
