package com.ecommerce.serviceimp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Payment;
import com.ecommerce.model.PaymentDTO;
import com.ecommerce.repository.PaymentRepository;
import com.ecommerce.service.PaymentService;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.converter.PaymentConverter;
@Service
public class PaymentServiceimp implements PaymentService  {
	@Autowired
	private PaymentRepository paymentrepository;
	@Autowired
	private PaymentConverter paymentconverter;

	@Override
	public String createPayment(Payment pay ,int userid){
		String message = null;
		pay.setId(pay.getId());
		pay.setAmount(pay.getAmount());
		pay.setPaymentDate(pay.getPaymentDate());
		pay.setId(pay.getId());
		paymentrepository.save(pay);
		if(pay != null)
		{
			message="Payment details added successfully";
		}		
		return message;
	}
		
		
	@Override
	public PaymentDTO getPaymentById(int id) {
		Payment pay = paymentrepository.findById(id).get();
		return paymentconverter.convertEntityToPaymentConverter(pay);
	}


	@Override
	public List<PaymentDTO> getAllPayment() {
		List<Payment> pay=paymentrepository.findAll();
		List<PaymentDTO> payDTO = new ArrayList<>();
		
		for(Payment p:pay) {
			payDTO.add(paymentconverter.convertEntityToPaymentConverter(p));
			
		}
	
		return payDTO;
	}

	@Override
	public PaymentDTO updatePayment(int id, Payment pay) {
		Payment ext = paymentrepository.findById(id).get();
		ext.setAmount(pay.getAmount());
		ext.setPaymentDate(pay.getPaymentDate());
		
		paymentrepository.save(ext);
		
		return paymentconverter.convertEntityToPaymentConverter(ext);
	}
	

	@Override
	public void deleteAllPayments() {
		paymentrepository.deleteAll();	
	}

	@Override
	public List<PaymentDTO> getPaymentByDate(String date) {
		List<Payment> payment1=paymentrepository.findAll();
		List<PaymentDTO> paymentsDTO= new ArrayList<>();
		for(Payment p: payment1)
		{
			paymentsDTO.add(paymentconverter.convertEntityToPaymentConverter(p));
		}
		return paymentsDTO;
	

	}


	@Override
	public String deletePaymentById(int id) throws ResourceNotFoundException {
		String msg = null;
		Optional<Payment> payment=paymentrepository.findById(id);
		if(payment.isPresent())
		{
			paymentrepository.deleteById(id);
			msg="Payment details deleted successfully";
		}
		else
		{
			throw new ResourceNotFoundException("Payment", "Id", id);
		}
		return msg;
		
	
	
	}
}


	
