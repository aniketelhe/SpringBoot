package com.ecommerce.serviceimp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Admin;
import com.ecommerce.model.AdminDTO;
import com.ecommerce.repository.AdminRepository;
import com.ecommerce.service.AdminService;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.converter.AdminConverter;
@Service
public class AdminServiceimp implements AdminService {
	@Autowired
	private AdminRepository adminRepository;
	

	@Autowired
	private AdminConverter adminConverter;

	@Override
	public String createAdmin(Admin admin) {
		String message = null;
		admin.setId(admin.getId());
		admin.setEmail(admin.getEmail());
		admin.setPassword(admin.getPassword());
		
		adminRepository.save(admin);

		
		if(admin!=null)
		{
			message="Customer details added successfully";
		}
		return message;

	}

	@Override
	public AdminDTO getAdminById(int id) {
		 Admin Admin =adminRepository.findById(id).get();
		return adminConverter.convertEntityToAdminDTO(Admin);
	}

	

	@Override
	public List<AdminDTO> getAllAdmin() {
		List<Admin>Admin=adminRepository.findAll();
		List<AdminDTO >AdminDTO=new ArrayList<>();
		for(Admin Ad:Admin)
		{
		AdminDTO.add( adminConverter.convertEntityToAdminDTO(Ad));
			
		}
		return AdminDTO ;
	}	

	@Override
	public AdminDTO updateAdmin(int id, Admin admin) {
		Admin ext = adminRepository.findById(id).get();
		ext.setFirstName(admin.getFirstName());
		ext.setLastName(admin.getLastName());
		ext.setEmail(admin.getEmail());
		ext.setPassword(admin.getPassword());
		adminRepository.save(ext);
		
		return adminConverter.convertEntityToAdminDTO(ext);
	}


	

	@Override
	public List<AdminDTO> findByemail(String email) {
		List<Admin> admin=adminRepository.findByemail(email);
		List<AdminDTO> adminDTO = new ArrayList<>();
		for(Admin ad:admin)
		{
			adminDTO.add(adminConverter.convertEntityToAdminDTO(ad));
		}
		return adminDTO;	
	}

	
	@Override
		public String deleteAllAdminBYID(int id) throws ResourceNotFoundException {

			String msg=null;
			Optional<Admin> user=adminRepository.findById(id);
			if(user.isPresent())
			{
				adminRepository.deleteById(id);
			    
				msg = "Admin deleted successfully!!";
				
			}
			else
			{
				
				throw new ResourceNotFoundException("Admin","ID", id);
			}
			return msg;
	}

	@Override
	public List<AdminDTO> findBypassword(String password) {
	List<Admin> Admin=adminRepository.findBypassword(password);
		List<AdminDTO> AdminDTO = new ArrayList<>();
		for(Admin ad:Admin)
		{
			AdminDTO.add(adminConverter.convertEntityToAdminDTO(ad));
		}
		return AdminDTO;	
	}

	@Override
	public void deleteAllAdmin() {
		adminRepository.deleteAll();
	}			

	
}
