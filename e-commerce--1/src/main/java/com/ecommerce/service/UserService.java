package com.ecommerce.service;

import java.util.List;


import com.ecommerce.entity.User;
import com.ecommerce.model.UserDTO;

public interface UserService {
	String createUser(User user);
	UserDTO  getUserById(int id);
	List<UserDTO> getAllUser();
	UserDTO updateUser(int id, User user);
	String deleteUserById(int id);
	void deleteAllUsers();
	List<UserDTO> findByUserName(String UserName);
    List<UserDTO> findByUserEmail(String email);
}
