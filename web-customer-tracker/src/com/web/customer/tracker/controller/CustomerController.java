package com.web.customer.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.customer.tracker.entity.Customer;
import com.web.customer.tracker.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomer(Model model) {
		
		model.addAttribute("customers", customerService.getCustomersList() );
		
		return "list-customer";
	}
	
	@GetMapping("/showFormForAdd")
	public String addCustomerForm(Model model) {
		
		Customer theCustomer = new Customer();
		
		model.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer")Customer customer) {
		
		customerService.saveNewCustomer(customer);
		
		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int customerId, Model model) {
	
		model.addAttribute("customer", customerService.getCustomer(customerId) );
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int customerId, Model model) {
	
		customerService.delete(customerId);
		
		return "redirect:/customer/list";
	}
	
	
}
