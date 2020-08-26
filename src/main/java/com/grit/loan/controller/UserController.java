package com.grit.loan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.grit.loan.model.Customer;
import com.grit.loan.model.User;
import com.grit.loan.repository.CustomerRepository;
import com.grit.loan.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String checkUserLogin(User user, Model model) {
		User loggedInUser = userRepository.findByIdAndPassword(user.getId(), user.getPassword());
		if (loggedInUser != null) {
			if (loggedInUser.getRole().equals("role1")) {
				model.addAttribute("customerRole1", new Customer());
				model.addAttribute("user",loggedInUser);
				return "customerRole1";
			}
			if (loggedInUser.getRole().equals("role2")) {
				model.addAttribute("user",loggedInUser);
				model.addAttribute("customerRole2",customerRepository.getDataForRole2());
				return "customerRole2";
			}
			if (loggedInUser.getRole().equals("role3")) {
				model.addAttribute("user",loggedInUser);
				model.addAttribute("customerRole3", new Customer());
				return "customerRole3";
			}
			if (loggedInUser.getRole().equals("role4")) {
				model.addAttribute("user",loggedInUser);
				model.addAttribute("customerRole4", new Customer());
				return "customerRole4";
			}
		}
		return "customerError";
	}

	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public List<User> getUser() {
		return userRepository.findAll();
	}
}
