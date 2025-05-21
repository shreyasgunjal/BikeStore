package com.springboot.bike_store.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bike_store.entity.Customer;
import com.springboot.bike_store.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class customerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("allCustomers")
    public ResponseEntity<List<Customer>> getCustomers()
    {
        return customerService.getCustomers();
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Customer>> getCustomer(@PathVariable Integer id)
    {
        return customerService.getCustomer(id);
    }

    @PostMapping("addCustomer")
    public String addCustomer(@RequestBody Customer customer)
    {
        return customerService.addCustomer(customer);
    }

    @PutMapping("edit/{id}")
    public String updateCustomer(@RequestBody Customer customer, @PathVariable Integer id)
    {
        return customerService.updateCustomer(customer, id);
    }

    @DeleteMapping("delete/{id}")
    public String deleteCustomer(@PathVariable Integer id)
    {
        return customerService.deleteCustomer(id);
    }
    
}
