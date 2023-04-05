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

import com.ecommerce.repository.ProductRepository;
import com.ecommerce.entity.Product;
import com.ecommerce.model.ProductDTO;
import com.ecommerce.service.ProductService;
import com.ecommerce.converter.ProductConverter;

@SpringBootTest
public class ProductServiceTest {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductConverter productConverter;
	
	@MockBean
	private ProductRepository productRepository;
	
	@Test
	void testCreateProduct()
	{
		Product product= Product.builder().productname("Diamond Ring").price(1500000).description("").build();
		
		Mockito.when(productRepository.save(product)).thenReturn(product);
//		assertEquals(" Product details added successfully",
//				productService.createProduct(product));
		
		assertThat(productService.createproduct(product)).isEqualTo("Product details added successfully");
	}
	
	@Test
	void testGetProductById()
	{
		Product product1= Product.builder().id(2).productname("Diamond Ring").price(1500000).description("").build();
		
		Mockito.when(productRepository.save(product1)).thenReturn(product1);
		 assertEquals("Diamond Ring",product1.getProductName());
	}
	
	
	@Test
		void testUpdateProduct()
		{
			Product product=Product.builder().productname("latop").price(150000).description("").build();
			
			Optional<Product>opProduct= Optional.of(product);
			
			Mockito.when(productRepository.findById(product.getId())).thenReturn(opProduct);
			
			Product p=opProduct.get();
			product.setProductName("null");
			
			Mockito.when(productRepository.save(product)).thenReturn(p);
			
			ProductDTO dto= productService.updateproduct(product.getId(),product);
			
//			assertEquals(dto.getName("null"),p.getProductName("null"));
		}
		
	}
	

