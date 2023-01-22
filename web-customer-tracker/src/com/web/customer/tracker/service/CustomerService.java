package com.web.customer.tracker.service;

import java.util.List;

import com.web.customer.tracker.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomersList();
	
	public void saveNewCustomer(Customer customer);
	
	public Customer getCustomer(int customerId);

	public void delete(int customerId);
}
