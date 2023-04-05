package com.ecommerce.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Table
@Entity
@Getter
 @Setter
 @AllArgsConstructor
@NoArgsConstructor
@ToString
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 30, nullable=false)
    private String firstName;
    @Column(length = 50)
    private String lastName;
    @Column(length = 40)
    private String email;
    @Column(length = 60)
    private String password;
    @JoinColumn
	@ManyToOne (cascade= CascadeType.ALL)
	private Product product;
    @JoinColumn
    @ManyToOne
    private User user;
    
    @Builder
	public Admin(int id, String firstName, String lastName, String email, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		
	}

	 
 
	
	}
	

  
    
	

	



