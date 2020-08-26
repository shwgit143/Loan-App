package com.grit.loan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grit.loan.model.Customer;

//<table name and primary key data type>
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("select c from Customer c where c.interestRate between 13 and 14 and c.status is null")
	List<Customer> getDataForRole2();	
}
