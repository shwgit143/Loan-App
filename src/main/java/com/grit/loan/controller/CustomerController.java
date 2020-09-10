package com.grit.loan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.grit.loan.model.Customer;
import com.grit.loan.model.User;
import com.grit.loan.repository.CustomerRepository;


/*
 * this code is by Ankur 
 */

@Controller
//@RestController
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	@RequestMapping(value = "/login")
	public String login(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value = "/addCustomerData", method = RequestMethod.POST)
	public String addCustomerData(Customer customer) {
		if (customer.getInterestRate() > 14) {
			customer.setStatus("approved");
		}
		customerRepository.save(customer);
		return "success";
	}

	@RequestMapping(value = "/addAnotherCustomer")
	public String addAnotherCustomer(Customer customer) {
		if (customer.getInterestRate() > 14) {
			customer.setStatus("approved");
		}
		customerRepository.save(customer);
		return "success";
	}

	@RequestMapping(value = "/customerDateForRole1", method = RequestMethod.GET)
	public String getCustomersForRole1(Model model) {
		return "customerRole1.html";
	}

	@RequestMapping(value = "/customerDateForRole2", method = RequestMethod.GET)
	public List<Customer> getCustomersForRole2() {

		return customerRepository.findAll();
	}

	public List<Customer> getCustomersForRole3() {

		return null;
	}

	public List<Customer> getCustomersForRole4() {

		return null;
	}

}
