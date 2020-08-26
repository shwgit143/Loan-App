package com.grit.loan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grit.loan.model.User;

public interface UserRepository extends JpaRepository<User, String> {

	User findByIdAndPassword(String id, String passord);

}
