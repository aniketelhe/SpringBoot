package com.ecommerce.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 30, nullable=false)

    private String productName;
    @Column(length = 50)
    private String description;
    @Column(length = 60)
    private double price;
    
    
    @ManyToOne
    private User user;
    
    
    
    @Builder
	public Product(int id, String productname, String description, double price) {
		super();
		this.id = id;
		this.productName = productname;
		this.description = description;
		this.price = price;
	}
}
	


