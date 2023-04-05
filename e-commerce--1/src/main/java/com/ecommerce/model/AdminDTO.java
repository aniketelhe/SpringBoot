package com.ecommerce.model;





import com.ecommerce.entity.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDTO {
	
	private int id;
	@NotNull(message = "Admin Name should not be null")

    private String firstName;
	
    private String lastName;
    @NotNull
    @Email(message = "Admin email should not be null")
    private String email;
    
    private String password;

    private User user;
    
  
}
