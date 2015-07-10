package com.tut.customer.dao;

import java.util.List;

import com.tut.customer.model.Customer;

public interface CustomerDAO {
	
	void addCustomer(Customer customer);
	List<Customer> listCustomer();
	void deleteCustomer(int customerId);

}
