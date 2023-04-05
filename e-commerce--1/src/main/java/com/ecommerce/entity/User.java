package com.ecommerce.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="User")
public class User {

    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 30, nullable=false)
    private String userName;
    @Column(length = 50)
    private String userEmail;
    @Column(length = 60)
    private String password;
    
    
    @Builder
	public User(int id, String userName, String email, String password) {
		super();
		this.id = id;
		userName = userName;
		this.userEmail = email;
		this.password = password;
    }
		

    @OneToMany
    private List<Product> product;

	}
  
	
	
    
    
    

    

