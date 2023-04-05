package com.ecommerce.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.ecommerce.entity.Payment;
import com.ecommerce.model.PaymentDTO;
@Component
public class PaymentConverter {

	//converts from payment  entity to paymentDTO
		public PaymentDTO convertEntityToPaymentConverter(Payment pay) {
			PaymentDTO payDTO = new PaymentDTO();
			if(pay!=null)
			{
				BeanUtils.copyProperties(pay, payDTO);
			}
			return payDTO;
		}
		//converts from paymentDTO to payment entity
		public Payment  convertDTOToPayment(PaymentDTO payDTO)
		{
			Payment pay = new Payment();
			if(payDTO!= null) {
				BeanUtils.copyProperties(payDTO, pay);
				
			}
			return pay;
		}
}
