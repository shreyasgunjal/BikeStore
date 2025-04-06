package com.springboot.bike_store.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.bike_store.Brand;

@Repository
public interface BrandDao extends JpaRepository<Brand, Integer> {

}
