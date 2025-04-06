package com.springboot.bike_store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bike_store.Brand;
import com.springboot.bike_store.dao.BrandDao;

@Service
public class BrandService {

    @Autowired
    BrandDao brandDao;

    public List<Brand> getBrands() {
        return brandDao.findAll();
    }

}
