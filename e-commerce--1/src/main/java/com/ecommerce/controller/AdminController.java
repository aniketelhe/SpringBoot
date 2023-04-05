package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Admin;
import com.ecommerce.model.AdminDTO;
import com.ecommerce.service.AdminService;
import com.ecommerce.converter.AdminConverter;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AdminConverter adminConverter;
	
	@PostMapping("/createAdmin")
	public String createAdmin(@Valid @RequestBody AdminDTO adminDTO)
	{
		final Admin Admin=adminConverter.convertDTOToAdmin(adminDTO);
		return adminService.createAdmin(Admin);
	}
	
	@GetMapping("/getAdminById/{id}")
	public AdminDTO getAdminById(@PathVariable("id") int id)
	{
		return adminService.getAdminById(id);
	}
	
	@GetMapping("/getAllAdmin")
	public List<AdminDTO> getAllAdmins(){
		return adminService.getAllAdmin();
	}
	
	@PutMapping("/updateAdmin/{id}")
	public AdminDTO updateAdmin(@PathVariable("id") int id, 
			@Valid @RequestBody AdminDTO adminDTO)
	{
		Admin admin1 =adminConverter.convertDTOToAdmin(adminDTO);
		return adminService.updateAdmin(id, admin1);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public String deleteAllAdminBYID(@PathVariable("id") int id)
	{
		return adminService.deleteAllAdminBYID(id);
	}
	
	@DeleteMapping("/deleteAllAdmin")
	public ResponseEntity<String> deleteAllAdmin()
	{
		adminService.deleteAllAdmin();
		return new ResponseEntity<String>("All book details got deleted!", 
				HttpStatus.OK);
	}
	
	@GetMapping("/findByEmailId/{emailId}")
	public List<AdminDTO> findByEmailId(@PathVariable("name") String email)
	{
		return adminService.findByemail(email);
	}
	
	@GetMapping("/findBypassword/{password}")
	public List<AdminDTO> findBypassword(@PathVariable("name") String password)
	{
		return adminService.findBypassword(password);
	}}
	