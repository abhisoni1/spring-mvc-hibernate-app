package com.web.customer.tracker.DAO;

import java.util.List;

import com.web.customer.tracker.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer customer);
	
	public Customer getCustomerById(int customerId);

	public void deleteCustomerById(int customerId);
}
