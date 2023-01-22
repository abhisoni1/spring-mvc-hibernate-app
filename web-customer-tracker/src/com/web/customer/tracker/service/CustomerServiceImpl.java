package com.web.customer.tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.customer.tracker.DAO.CustomerDAO;
import com.web.customer.tracker.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomersList() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveNewCustomer(Customer customer) {
		
		customerDAO.saveCustomer(customer);
		
	}

	@Override
	@Transactional
	public Customer getCustomer(int customerId) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomerById(customerId);
	}

	@Override
	@Transactional
	public void delete(int customerId) {
		customerDAO.deleteCustomerById(customerId);
		
	}

}
