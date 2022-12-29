package com.cg.bookstore.service;

import java.util.List;

import com.cg.bookstore.dto.CustomerDto;
import com.cg.bookstore.entity.Customer;

public interface ICustomerService {

	public CustomerDto createCustomer(CustomerDto customerdto);
	public List<Customer> listCustomers();

	public Customer updateCustomer(Customer c);

	Customer viewCustomer(int c);
	void deleteCustomer(int c);

	
}
