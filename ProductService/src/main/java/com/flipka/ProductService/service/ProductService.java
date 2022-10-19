package com.flipka.ProductService.service;

import com.flipka.ProductService.bean.ProductBean;
import com.flipka.ProductService.entity.ProductEntity;
import com.flipka.ProductService.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductEntity saveProduct(ProductBean productBean) {
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(productBean, productEntity);
        return productRepository.save(productEntity);
    }

	public ProductEntity getProductById(Integer productId) {
		return productRepository.findById(productId).get();
	}
    
}
