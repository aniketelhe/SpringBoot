package com.ecommerce.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.ecommerce.entity.Product;
import com.ecommerce.model.ProductDTO;
@Component
public class ProductConverter {
	//converts from Product entity to ProductDTO
		public ProductDTO convertEntityToProductDTO (Product products)
		{
			ProductDTO productDTO = new ProductDTO();
			if(products != null)
			{
				BeanUtils.copyProperties(products, productDTO);
			}
			return productDTO;
		}
		
		//converts from ProductDTO to Product entity
		public Product convertDTOToProduct(ProductDTO productDTO)
		{
			Product product = new Product();
			if(productDTO != null)
			{
				BeanUtils.copyProperties(productDTO, product);
			}
			return product;
		}
		
	}