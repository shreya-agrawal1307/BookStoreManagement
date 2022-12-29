package com.cg.bookstore.service;


 

import java.util.List;
import java.util.Optional;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookstore.dto.CustomerDto;
import com.cg.bookstore.entity.Customer;
//import com.cg.bookstore.exception.BookNotFoundException;
import com.cg.bookstore.exception.CustomerNotFoundException;
import com.cg.bookstore.repository.ICustomerRepository;

@Service
public class ICustomerServiceImpl implements ICustomerService{

 

    @Autowired
    private ICustomerRepository icustomerRepository;

    @Override
    public CustomerDto createCustomer(CustomerDto customerdto) {
    	Customer customer = new Customer();
    	customer.setFullName(customerdto.getFullName());
    	customer.setCustomerId(customerdto.getCustomerId());
    	customer.setPassword(customerdto.getPassword());
    	customer.setMobileNumber(customerdto.getMobileNumber());
    	customer.setEmail(customerdto.getEmail());
    	customer.setRegisterOn(customerdto.getRegisterOn());
    	
        Customer newCustomer=icustomerRepository.save(customer);
        CustomerDto newDto = new CustomerDto();
        newDto.setCustomerId(newCustomer.getCustomerId());
        newDto.setFullName(newCustomer.getFullName());
        newDto.setMobileNumber(newCustomer.getMobileNumber());
        newDto.setPassword(newCustomer.getPassword());
        newDto.setRegisterOn(newCustomer.getRegisterOn());
        newDto.setEmail(newCustomer.getEmail());
        return newDto ;
    }

 

    @Override
    public List<Customer> listCustomers() {

        return icustomerRepository.findAll();
    }

 

    @Override
    public void deleteCustomer(int c) {
        Optional<Customer> optionalCustomer= icustomerRepository.findById(c);
        if(optionalCustomer.isEmpty()) {
            throw new CustomerNotFoundException("customer not found with id :"+c);
        }
        icustomerRepository.deleteById(c);
    }

 

    @Override
    public Customer updateCustomer(Customer c) {
        Optional<Customer> optionalBook= icustomerRepository.findById(c.getCustomerId());
        if(optionalBook.isEmpty()) {
            throw new CustomerNotFoundException("customer not found with id :"+c.getCustomerId());
        }
        Customer updateCustomer=icustomerRepository.save(c);
        return updateCustomer;
    }

 

    @Override
	public Customer viewCustomer(int customerId) {
		Optional<Customer> optionalCustomer= icustomerRepository.findById(customerId);
		if(optionalCustomer.isEmpty()) {
			throw new CustomerNotFoundException("customer not found with id :"+customerId);
		}
		Customer customer=optionalCustomer.get();
		return customer;
	}


 
 
    }
