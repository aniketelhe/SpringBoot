package com.ecommerce.serviceimp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.converter.ProductConverter;
import com.ecommerce.entity.Product;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.model.ProductDTO;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.service.ProductService;
@Service
public class ProductServiceimp  implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductConverter productConverter;

	@Override
	public String createproduct(Product product) {
		String message = null;
		product.setProductName(product.getProductName());
		product.setPrice(product.getPrice());
		product.setDescription(product.getDescription());
		
		productRepository.save(product);
		if(product != null)
		{
			message="Product details added successfully";
		}		
		return message;
	
	}

	@Override
	public ProductDTO getproductById(int id) {
		Product product = productRepository.findById(id).get();
		return productConverter.convertEntityToProductDTO(product);
	}
	

	@Override
	public List<ProductDTO> getAllproduct() {
		List<Product> products = productRepository.findAll();
		List<ProductDTO> productDTO = new ArrayList<>();
		for(Product p : products)
		{
			productDTO.add(productConverter.convertEntityToProductDTO(p));
		}
		return productDTO;
	}


	@Override
	public ProductDTO updateproduct(int id, Product product) {
		Product existingProduct = productRepository.findById(id).get();
		
		existingProduct.setProductName(product.getProductName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setDescription(product.getDescription());
		
		productRepository.save(existingProduct);
		return productConverter.convertEntityToProductDTO(existingProduct);
	}

	
	@Override
	public String deleteproductById(int id) throws ResourceNotFoundException
	{
		String msg=null;
		Optional<Product> Product=productRepository.findById(id);
		if(Product.isPresent())
		{
			productRepository.deleteById(id);
		    
			msg = "product deleted successfully!!";
			
		}
		else
		{
			
			throw new ResourceNotFoundException("product","Id", id);
		}
		return msg;
	}
		
	

	

	@Override
	public void deleteAllproducts() {
		productRepository.deleteAll();	
		
	}

	@Override
	public List<ProductDTO> getproductByName(String Name) {
		List<Product> products = productRepository.findByProductName(Name);
		List<ProductDTO> productDTO = new ArrayList<>();
		for(Product p : products)
		{
			productDTO.add(productConverter.convertEntityToProductDTO(p));
		}
		return productDTO;
	}
	


	
	}
	
	