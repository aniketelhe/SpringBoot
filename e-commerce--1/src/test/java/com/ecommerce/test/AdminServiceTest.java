package com.ecommerce.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ecommerce.converter.AdminConverter;
import com.ecommerce.entity.Admin;
import com.ecommerce.model.AdminDTO;
import com.ecommerce.repository.AdminRepository;
import com.ecommerce.service.AdminService;


@SpringBootTest
public class AdminServiceTest {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AdminConverter adminConverter;
	
	@MockBean
	private  AdminRepository adminRepository; 
	
	@Test
	void testCreateAdmin()
	{
		 Admin admin =  Admin.builder().firstName("bot").lastName("Elhe").email("aniketelhe@gmail.com").password("12345").build();
		
		Mockito.when(adminRepository.save(admin)).thenReturn(admin);
		assertEquals("Customer details added successfully", adminService.createAdmin(admin));
		assertThat(adminService.createAdmin(admin)).isEqualTo("Customer details added successfully");
		
	}
	@Test
	void testGetAdminyById()
	{
		 Admin  admin1=  Admin.builder().firstName("rohti").lastName("Elhe").email("aniket56@gmail.com").password("67580").build();
		
		Mockito.when(adminRepository.save( admin1)).thenReturn( admin1);
		assertEquals("Elhe",  admin1.getLastName());
	}
	
@Test
	void testGetAllAdmin()
	{
	 Admin admin =  Admin.builder().firstName("bot").lastName("Elhe").email("aniketelhe@gmail.com").password("12345").build();
	 Admin  admin1=  Admin.builder().firstName("rohti").lastName("Elhe").email("aniket56@gmail.com").password("12345").build();
		
		List< Admin>list= new ArrayList<>();
		list.add( admin);
		list.add( admin1);
		
		Mockito.when(adminRepository.findAll()).thenReturn(list);
		
		List<AdminDTO>dto= adminService.getAllAdmin();
		
		List<Admin>Admin= new ArrayList<>();
		dto.forEach(AdminDTO->
		 Admin.add(adminConverter.convertDTOToAdmin(AdminDTO)));

		assertThat(Admin.get(0).getFirstName()).isEqualTo(list.get(0).getFirstName());
		
}

@Test
	void testUpdateAdmin()
	{
	 Admin admin =  Admin.builder().firstName("Aniket").lastName("Earrings").email("aniketelhe@gmail.com").password("12345").build();
		
		Optional<Admin> opAdmin=Optional.of(admin);
		
		Mockito.when(adminRepository.findById(admin.getId())).thenReturn(opAdmin);
		
		Admin c=opAdmin.get();
		admin.setFirstName("Aniket");
		admin.setLastName("Aniket");
		Mockito.when(adminRepository.save(admin)).thenReturn(c);
		
		AdminDTO dto=adminService.updateAdmin(admin.getId(),admin);
		assertEquals(dto.getFirstName(),c.getLastName());
	}
}

	
