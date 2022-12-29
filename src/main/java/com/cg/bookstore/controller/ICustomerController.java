package com.cg.bookstore.controller;

 

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

 

import com.cg.bookstore.service.ICustomerService;
import com.cg.bookstore.dto.CustomerDto;
import com.cg.bookstore.entity.Customer;

 

@RestController
public class ICustomerController {

 

    @Autowired
    private ICustomerService icustomerService;

    @PostMapping("/customer/save")
    public ResponseEntity<CustomerDto> addCustomer(@Valid @RequestBody CustomerDto customerDto) {
        CustomerDto newCustomer = icustomerService.createCustomer(customerDto);
        ResponseEntity<CustomerDto> responseEntity = new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/customer/all")
    public List<Customer> fetchAllCustomers() {
        List<Customer> list = icustomerService.listCustomers();
        return list;
    }

    @GetMapping("/customer/get/{id}")
    public ResponseEntity<Object> fetchBookDetails(@PathVariable("id") int c){
        ResponseEntity<Object> responseEntity=null;
        Customer cust=icustomerService.viewCustomer(c);
        responseEntity=new ResponseEntity<>(cust,HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping("/customer/update")
    public ResponseEntity<Object> modifyBook(@RequestBody Customer c){
        ResponseEntity<Object> responseEntity=null;
            Customer updatedBook=icustomerService.updateCustomer(c);
            responseEntity =new ResponseEntity<>(updatedBook,HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<String> removeCustomer(@PathVariable("id")int c){
        ResponseEntity<String> responseEntity=null;
            icustomerService.deleteCustomer(c);
            responseEntity=new ResponseEntity<>("customer deleted",HttpStatus.OK);
        return responseEntity;
    }

 

}