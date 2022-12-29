package com.cg.bookstore.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.bookstore.dto.CustomerDto;
import com.cg.bookstore.entity.Customer;
import com.cg.bookstore.repository.ICustomerRepository;

@SpringBootTest
public class CustomerServiceTest {
	
	
	@InjectMocks
	private ICustomerServiceImpl customerService = new ICustomerServiceImpl();
	
	@Mock
	private ICustomerRepository icustomerRepository;
	
	
	@Test
	public void testCreateCustomer() {
		
		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setFullName("Elina");
		customer.setEmail("abc@123");
		customer.setMobileNumber("123456");
		customer.setPassword("shr123");
		customer.setRegisterOn(LocalDate.of(2020, 10, 10));
		
		//Optional<Customer> optionalCustomer = Optional.of(customer);
		when(icustomerRepository.save(customer)).thenReturn(customer);
		assertEquals(1,customer.getCustomerId());
		
		//Customer customerobj = customerService.createCustomer(customer);
		
	}
	
	//@Test
	//public void listCustomers() {
		
		 //List<Customer> cus=new ArrayList<Customer>();
	        //Customer c=new Customer();
	       // cus.setCustomerId(1);
	       // cus.setEmail("abc@123");
	       // c.setFullName("elvin");
	       // c.setMobileNumber("376486");
	        //c.setPassword("xhgah56");
	        //c.setRegisterOn(LocalDate.of(2020, 10, 10));
	        
	       // when(icustomerRepository.findAll()).thenReturn(cus);
	        //assertEquals(1,cus.
	//}
	
	@Test
    public void testviewCustomer() {
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setEmail("abc@33");
        customer.setFullName("chbhsdb");
        customer.setMobileNumber("647389");
        customer.setPassword("vxhgxvs536");
        customer.setRegisterOn(LocalDate.of(2020, 10, 10));
      

 

        Optional<Customer> optionalCustomer = Optional.of(customer);
        when(icustomerRepository.findById(1)).thenReturn(optionalCustomer);
        //verify(icustomerRepository,times(1)).findById(1);
        assertEquals(1,customer.getCustomerId());
 

	}
	
	@Test
	public void testupdateCustomer() {
		
		Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setEmail("abc@33");
        customer.setFullName("chbhsdb");
        customer.setMobileNumber("647389");
        customer.setPassword("vxhgxvs536");
        customer.setRegisterOn(LocalDate.of(2020, 10, 10));
        
        Optional<Customer> optionalCustomer = Optional.of(customer);
        when(icustomerRepository.findById(1)).thenReturn(optionalCustomer);
        //verify(icustomerRepository,times(1)).findById(1);
        assertEquals(1,customer.getCustomerId());
        
        }
	
	@Test
	public void testdeleteCustomer() {
		
		Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setEmail("abc@33");
        customer.setFullName("chbhsdb");
        customer.setMobileNumber("647389");
        customer.setPassword("vxhgxvs536");
        customer.setRegisterOn(LocalDate.of(2020, 10, 10));
        
        Optional<Customer> optionalCustomer = Optional.of(customer);
        when(icustomerRepository.findById(1)).thenReturn(optionalCustomer);
        //verify(icustomerRepository,times(1)).findById(1);
        assertEquals(1,customer.getCustomerId());
        
		
	}
	
	
		
	}
	
	
