package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ecommerce.entity.User;

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Integer> {


	List<User> findByUserEmail(String UserEmail);

	List<User> findByUserName(String userName);


	
	
	
}
