package com.springboot.bike_store.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.bike_store.dao.CustomerDao;
import com.springboot.bike_store.entity.Customer;

@Service
public class CustomerService {
    
    @Autowired
    CustomerDao customerDao;

    public ResponseEntity<List<Customer>> getCustomers() {
        try {
            return new ResponseEntity<>(customerDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Optional<Customer>> getCustomer(Integer id) {
        try {
            Optional<Customer> existingID = customerDao.findById(id);

            if (existingID.isPresent()) {
                return new ResponseEntity<>(existingID, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(Optional.empty(), HttpStatus.BAD_REQUEST);
    }




}
