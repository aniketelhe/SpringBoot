package com.ecommerce.model;



import com.ecommerce.entity.Product;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
	private int id;
	@NotNull(message = "User Name should not be null")
	private String userName;
	@NotNull(message = "Email should not be null")
	private String userEmail;
	@NotNull(message = "Password should not be null")
	private String password;
	    
		private Product product;


	}


