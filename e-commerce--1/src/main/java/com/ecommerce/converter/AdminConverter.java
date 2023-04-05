package com.ecommerce.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.ecommerce.entity.Admin;
import com.ecommerce.model.AdminDTO;

@Component
public class AdminConverter {

	public AdminDTO convertEntityToAdminDTO(Admin admin) {
		AdminDTO AdminDTO = new AdminDTO();
		if (admin!=null)
		{
			BeanUtils.copyProperties(admin, AdminDTO);
		}
		return AdminDTO ;

	}

	public Admin convertDTOToAdmin(AdminDTO adminDTO){
		Admin Admin = new Admin();
		if (adminDTO!=null)
		{
			BeanUtils.copyProperties(adminDTO, Admin);
		}
		return Admin ;

	}
}
