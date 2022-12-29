package com.cg.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookstore.entity.Customer;
@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

	//Customer create(Customer c);

	//public Customer createCustomer(Customer c);
	//public List<Customer> listCustomers();
	//public Customer deleteCustomer(Customer c);
	//public Customer updateCustomer(Customer c);
	//public Customer viewCustomer(Customer c);

}
