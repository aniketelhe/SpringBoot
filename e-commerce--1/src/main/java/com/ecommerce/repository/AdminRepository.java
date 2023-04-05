package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.Admin;

	
	public interface AdminRepository extends JpaRepository<Admin, Integer>{

		List<Admin> findByemail(String email);

		List<Admin> findBypassword(String password);

	

}
