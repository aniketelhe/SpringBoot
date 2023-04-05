package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.converter.ProductConverter;
import com.ecommerce.entity.Product;
import com.ecommerce.model.ProductDTO;
import com.ecommerce.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("Product/")
public class ProductController {
	
	@Autowired
    private ProductService productService;
	
	@Autowired
	private  ProductConverter productConverter;
	@PostMapping("/createProduct")
	public String createCustomer(@Valid @RequestBody ProductDTO productDTO)
	{
		final Product products = productConverter.convertDTOToProduct(productDTO);
		return productService.createproduct(products);
	}
	
	@GetMapping("/getProductById/{productId}")
	public ProductDTO getProductById(@PathVariable("productId") int id)
	{
		return productService.getproductById(id);
	}
	
	@GetMapping("/getAllProducts")
	public List<ProductDTO> getAllProducts()
	{
		return productService.getAllproduct();
	}
	
	@PutMapping("/updateProduct/{producId}")
	public ProductDTO updateProduct(@PathVariable("productId") int id,
			@RequestBody ProductDTO productDTO)	
	{
		Product prducts = productConverter.convertDTOToProduct(productDTO);
		return productService.updateproduct(id, prducts);
	}
	
	@DeleteMapping("/deleteProductById/{productId}")
	public String deleteProductById(@PathVariable("productId") int id)
	{
		return productService.deleteproductById(id);
	}
	
	@DeleteMapping("/deleteAllProducts")
	public ResponseEntity<String> deleteAllProducts()
	{
		productService.deleteAllproducts();
		return new ResponseEntity<String>("All product details got deleted!",
				HttpStatus.OK);
	}
	
	@GetMapping("/getProductByName/{Name}")
	public List<ProductDTO> getProductByName(@PathVariable("Name") String ProductName)
	{
		return productService.getproductByName(ProductName);
}
}
