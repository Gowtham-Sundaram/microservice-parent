package com.flipka.ProductService.controller;

import com.flipka.ProductService.bean.ProductBean;
import com.flipka.ProductService.entity.ProductEntity;
import com.flipka.ProductService.service.ProductService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@PostMapping("/saveproduct")
	@ResponseStatus(HttpStatus.OK)
	public ProductEntity saveProduct(@RequestBody ProductBean productBean) {
		return productService.saveProduct(productBean);
	}

	@GetMapping("/get/{productId}")
	@ResponseStatus(HttpStatus.CREATED)
	public ProductEntity getProductById(@PathVariable("productId") Integer productId) {
		return productService.getProductById(productId);
	}
	
	
}
