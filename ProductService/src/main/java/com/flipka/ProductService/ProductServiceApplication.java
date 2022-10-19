package com.flipka.ProductService;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.flipka.ProductService.bean.ProductBean;
import com.flipka.ProductService.bean.ProductType;
import com.flipka.ProductService.service.ProductService;

@SpringBootApplication
@EnableEurekaClient
public class ProductServiceApplication {

	@Autowired
	private ProductService productService;

	@PostConstruct
	public void saveProducts() {
		ProductBean[] listOfProducts = {
				new ProductBean("Redmi Note 11 PRO Plus 5G (Mirage Blue, 128 GB)  (6 GB RAM)", 21499, "RPINTERNATIONAL",
						ProductType.PHYSICAL),
				new ProductBean("Thomson 9A Series 80 cm (32 inch) HD Ready LED Smart Android TV  (32PATH0011)", 11999,
						"HydONLINEecommerce", ProductType.PHYSICAL),
				new ProductBean("DG ELPUS Rectangular Pack of 1 Table Placemat  (Brown, PVC)", 224, "DEVGOODS",
						ProductType.PHYSICAL),
				new ProductBean("The Trail (E-Book)", 450, "DEVGOODS", ProductType.DIGITAL) };
		for (ProductBean product : listOfProducts) {
			productService.saveProduct(product);
		}
	}

	public static void main(String[] args) {

		SpringApplication.run(ProductServiceApplication.class, args);

	}

}
