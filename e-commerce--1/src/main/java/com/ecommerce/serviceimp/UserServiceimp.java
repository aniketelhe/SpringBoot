package com.ecommerce.serviceimp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.converter.UserConverter;
import com.ecommerce.entity.User;
import com.ecommerce.model.UserDTO;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.service.UserService;
import com.ecommerce.exception.ResourceNotFoundException;

@Service
public class UserServiceimp implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter userconvertor;
	
	@Override
	public String createUser(User user) {
		String message=null;
		
		user.setId(user.getId());
		user.setUserName(user.getUserName());
		user.setUserEmail(user.getUserEmail());
		user.setPassword(user.getPassword());
		
		userRepository.save(user);
		if(user != null)
		
			{
				message = "User details added successfully!!";
			}
		
		return message;
	}

	@Override
	public UserDTO getUserById(int id) {
		User user =userRepository.findById(id).get();
		return userconvertor.convertEntityToUserDTO(user);
	}

	
	@Override
	public List<UserDTO> getAllUser() {
		List<User> user=userRepository.findAll();
		List<UserDTO> userDTO = new ArrayList<>();
		for(User u:user) {
			userDTO.add(userconvertor.convertEntityToUserDTO(u));
			
		}
		return userDTO;
		
	}

	@Override
	public UserDTO updateUser(int id, User user) {
		User existinguser=userRepository.findById(id).get();
		
		existinguser.setId(user.getId());
		existinguser.setUserName(user.getUserName());
		existinguser.setUserEmail(user.getUserEmail()
		);
		existinguser.setPassword(user.getPassword());
	
		
		userRepository.save(existinguser);
		
		
		
		return userconvertor.convertEntityToUserDTO(existinguser);
	}
	
	@Override
	public String deleteUserById(int id) throws ResourceNotFoundException
	{
		String msg=null;
		Optional<User> user=userRepository.findById(id);
		if(user.isPresent())
		{
			userRepository.deleteById(id);
		    
			msg = "User deleted successfully!!";
			
		}
		else
		{
			
			throw new ResourceNotFoundException("User","Id", id);
		}
		return msg;
		
		
	}

	@Override
	public void deleteAllUsers() {
		userRepository.deleteAll();
		
	}

	@Override
	public List<UserDTO> findByUserName(String UserName) {
		List<User> user=userRepository.findByUserName(UserName);
		List<UserDTO> usersDTO= new ArrayList<>();
		for(User u: user)
		{
			usersDTO.add(userconvertor.convertEntityToUserDTO(u));
		}
		return usersDTO;
		
		
	}
	

	@Override
	public List<UserDTO> findByUserEmail(String email) {
		List<User> user=userRepository.findByUserEmail(email);
		List<UserDTO> usersDTO= new ArrayList<>();
		for(User u: user)
		{
			usersDTO.add(userconvertor.convertEntityToUserDTO(u));
		}
		return usersDTO;	}

	}
		