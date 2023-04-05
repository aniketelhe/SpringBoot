package com.ecommerce.model;

import java.time.LocalDate;

import com.ecommerce.entity.User;

import jakarta.validation.constraints.NotNull;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDTO {
	 private int id;
	 @NotNull(message = "Amount should not be null")
	 private double amount;
	 @NotNull(message = "Payment Date should not be null")
	    private LocalDate paymentDate;


	    
	    private User user;
		
		 
}
