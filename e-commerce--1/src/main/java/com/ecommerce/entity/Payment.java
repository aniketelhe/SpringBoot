package com.ecommerce.entity;

import java.time.LocalDate;

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

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Payment")
@ToString
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 30, nullable=false)

    private LocalDate paymentDate;
    @Column(length = 50)
    private double amount;
    
    @ManyToOne
    @JoinColumn
    
    private User user;
  
    @Builder

	public Payment(int id, LocalDate paymentDate, double amount) {
		super();
		this.id = id;
		this.paymentDate = paymentDate;
		this.amount = amount;
		
		
	}


	
	}
   
    


