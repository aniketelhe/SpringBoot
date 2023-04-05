package com.ecommerce.model;

import com.ecommerce.entity.User;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
	private int id;
	@NotNull
    private String name;
    private String description;
    private double price;

	private User user;

}
