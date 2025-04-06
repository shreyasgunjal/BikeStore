package com.springboot.bike_store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bike_store.Brand;
import com.springboot.bike_store.service.BrandService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RestController
@RequestMapping("/api")
public class brandController {

    @Autowired
    BrandService brandService;

    @GetMapping("brand")
    public List<Brand> getBrands()
    {
        return brandService.getBrands();
    }

    @PersistenceContext
private EntityManager entityManager;
@GetMapping("/check-schema")
public String getSchema() {
    String schema = (String) entityManager
        .createNativeQuery("SELECT DATABASE()")
        .getSingleResult();
    return "Current database: " + schema;
}


}

