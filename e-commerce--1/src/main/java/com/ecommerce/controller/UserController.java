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

import com.ecommerce.converter.UserConverter;
import com.ecommerce.model.UserDTO;
import com.ecommerce.service.UserService;
import com.ecommerce.entity.User;

@RestController
@RequestMapping("/User")
public class UserController {
	
	@Autowired
    private UserService userService;
	
	@Autowired
	private  UserConverter userconverter;
	
	@PostMapping("/createUser")
	public String createUser(@RequestBody UserDTO userDTO)
	{
		final User user = userconverter.convertDTOToUser(userDTO);
		return userService.createUser(user);
		
	}
	
	@GetMapping("/getuserById/{id}")
	public UserDTO getUserById(@PathVariable("id")int id)
	{
		return userService.getUserById(id);
	}
	
	@GetMapping("/getAllUser")
	public List<UserDTO> getAllUser(){
		return userService.getAllUser();
	}
	
	@PutMapping("/updateUser/{id}")
	public UserDTO updateUser(@PathVariable("id") int id,
			@RequestBody UserDTO userDTO) {
		User user1 = userconverter.convertDTOToUser(userDTO);
		return userService.updateUser(id , user1);
	}
	
	@DeleteMapping("/deleteUserById/{id}")
	public String deletePaymentById(@PathVariable("id") int id)
	{
		return userService.deleteUserById(id);
	}
	
	@DeleteMapping("/deleteAllUsers")
	public ResponseEntity<String> deleteAllUsers()
	{
		userService.deleteAllUsers();
		return new ResponseEntity<String>("All user details got deleted!",
				HttpStatus.OK);
	}
	
	@GetMapping("/findByUserName/{name}")
	public List<UserDTO> findByUserName(@PathVariable("name") String UserName)
	{
		return userService.findByUserName(UserName);
	}
	@GetMapping("/findByUseremail/{email}")
	public List<UserDTO> getUser(@PathVariable("email") String email)
	{
		return userService.findByUserEmail(email);
	}
	
	}
	






