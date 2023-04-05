package com.ecommerce.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.ecommerce.entity.User;
import com.ecommerce.model.UserDTO;
@Component
public class UserConverter {
	//converts from user entity to userDTO

			public UserDTO convertEntityToUserDTO(User user) {
				UserDTO userDTO = new UserDTO();
				if(user!=null)
				{
					BeanUtils.copyProperties(user, userDTO);
				}
				return userDTO;
			}
			//converts from userDTO to user entity
			public User  convertDTOToUser(UserDTO userDTO)
			{
				User user = new User();
				if(userDTO!= null) {
					BeanUtils.copyProperties(userDTO, user);
					
				}
				return user;
			
			}}	
