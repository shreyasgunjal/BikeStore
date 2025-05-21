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

    public String addCustomer(Customer customer) {
        if(customerDao.existsById((int)customer.getCustomerId()))
        {
            return "ID already exists";
        }

        customerDao.save(customer);
        return "success";
    }

    public String updateCustomer(Customer customer, Integer id) {
        Optional<Customer> existingCustomer = customerDao.findById(id);
        if (existingCustomer.isPresent()) {
            if (customer.getFirstName() == null || customer.getFirstName().trim().isEmpty()) {
                return "failed: category name is null or empty";
            }

            Customer updatedCustomer = existingCustomer.get();
            updatedCustomer.setCity(customer.getCity());
            updatedCustomer.setEmail(customer.getEmail());
            updatedCustomer.setFirstName(customer.getFirstName());
            updatedCustomer.setLastName(customer.getLastName());
            updatedCustomer.setPhone(customer.getPhone());
            updatedCustomer.setState(customer.getState());
            updatedCustomer.setStreet(customer.getStreet());
            updatedCustomer.setZipCode(customer.getZipCode());

            customerDao.save(updatedCustomer);
            return "Updated Successfully!";
        }else
        {
            return "failed to update";
        }
        
    }

    public String deleteCustomer(Integer id) {
        
        if (customerDao.existsById(id)) {
            customerDao.deleteById(id);
            return "Deleted Successfully";
        }

        return "Failed to delete/ID not present";
    }




}
