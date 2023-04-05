package com.ecommerce.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ecommerce.converter.UserConverter;
import com.ecommerce.entity.User;
import com.ecommerce.model.UserDTO;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.service.UserService;

@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	private UserService userService; 
	
	@Autowired
	private UserConverter converter;
	
	@MockBean
	private UserRepository userRepository;
	
	@Test
	void testCreateUser()
	{
		User user = User.builder().userName("rani").email("rani36@gmail.com").password("rani").
				build();
		
		Mockito.when(userRepository.save(user)).thenReturn(user);
		assertEquals("User details added successfully!!", userService.createUser(user));
		assertThat(userService.createUser(user)).isEqualTo("User details added successfully!!");
	}
	
	
	@Test
	void testGetAllUsers()
	{
		User user = User.builder().userName("vaibhav").email("vaibhav@gmail.com").password("vaibhav").build();
		
		User user1 = User.builder().userName("Rutwik").email("rutwik@gmail.com").password("rutwik").build();
		
		List<User> list = new ArrayList<>();
		list.add(user1);
		list.add(user);
		
		Mockito.when(userRepository.findAll()).thenReturn(list);
		
		List<UserDTO> dto = userService.getAllUser();
		
		List<User> users= new ArrayList<User>();
		dto.forEach(userDTO->
		users.add(converter.convertDTOToUser(userDTO)));
		
		assertThat(users.get(0).getUserName()).isEqualTo(list.get(0).getUserName());
				
	}
	
	@Test
	void testUpdateUser()
	{
		User user = User.builder().userName("vaibhav").email("vaibhav@gmail.com").password("vaibhav").build();
		
		Optional<User> opUser = Optional.of(user);
		
		Mockito.when(userRepository.findById(user.getId())).thenReturn(opUser);
		
		User u = opUser.get();
		user.setUserName("vaishali");
		
		Mockito.when(userRepository.save(user)).thenReturn(u);
		
		UserDTO dto = userService.updateUser(user.getId(), user);
		assertEquals(dto.getUserName(), u.getUserName());
	}
	
	
	
	 

	}
