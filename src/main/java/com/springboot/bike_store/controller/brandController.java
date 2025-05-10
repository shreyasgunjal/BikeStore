package com.springboot.bike_store.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bike_store.entity.Brand;
import com.springboot.bike_store.service.BrandService;

@CrossOrigin(origins = "http://localhost:3000") 
@RestController
@RequestMapping("/api")
public class brandController {

    @Autowired
    BrandService brandService;

    @GetMapping("brands")
    public ResponseEntity<List<Brand>> getBrands()
    {
        return brandService.getBrands();
    }

    @GetMapping("brand/{id}")
    public ResponseEntity<Optional<Brand>> getBrand(@PathVariable Integer id)
    {
        return brandService.getBrand(id);
    }

    @PostMapping("/brand")
    public String addBrand(@RequestBody Brand brand)
    {
        return brandService.addBrand(brand);
    }

    @PutMapping("/brand/edit/{id}")
    public String updateBrand(@PathVariable Integer id,@RequestBody Brand brand)
    {
        return brandService.updateBrand(id, brand);
    }

    @DeleteMapping("/brand/delete/{id}")
    public String deleteBrand(@PathVariable Integer id)
    {
        return brandService.deleteBrand(id);
    }
}

