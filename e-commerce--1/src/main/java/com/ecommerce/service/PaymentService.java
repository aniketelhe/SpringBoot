package com.ecommerce.service;

import java.util.List;

import com.ecommerce.entity.Payment;
import com.ecommerce.model.PaymentDTO;

public interface PaymentService {

	
	String createPayment(Payment pay ,int userid);
	
	PaymentDTO  getPaymentById(int id);
	
	List<PaymentDTO> getAllPayment();
	
	PaymentDTO updatePayment(int id, Payment pay);
	
	String deletePaymentById(int id);
	
	void deleteAllPayments();
	
	List<PaymentDTO> getPaymentByDate(String date);

	

	
}
