package com.ecommerce.service;

import java.util.List;

import com.ecommerce.entity.Admin;
import com.ecommerce.model.AdminDTO;

public interface AdminService {
	String createAdmin( Admin  admin);
	AdminDTO getAdminById(int id); 
	List<AdminDTO> getAllAdmin();  
	AdminDTO updateAdmin(int id, Admin admin); 
	List<AdminDTO> findByemail(String email) ;
	void deleteAllAdmin();
	String deleteAllAdminBYID(int id);
	List<AdminDTO> findBypassword(String password);
}
