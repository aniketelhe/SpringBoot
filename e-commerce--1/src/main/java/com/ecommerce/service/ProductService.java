package com.ecommerce.service;

import java.util.List;

import com.ecommerce.entity.Product;
import com.ecommerce.model.ProductDTO;

public interface ProductService {

	String createproduct(Product product); //save a new product
	ProductDTO getproductById(int id); //fetch data of a product using the id
	List<ProductDTO> getAllproduct(); //fetch all products
	ProductDTO updateproduct(int id,Product product ); //fetch and update the product details
	String deleteproductById(int id); //deleting a product using id
	void deleteAllproducts(); //delete all the products
	List<ProductDTO> getproductByName(String Name);
	

}
