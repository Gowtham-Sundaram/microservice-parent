package com.flipka.OrderService.entity;

import com.flipka.OrderService.bean.ProductType;

public class ProductEntity {
	private int productId;
	private String productName;
	private int price;
	private String productSeller;
	private ProductType productType;

	public ProductEntity() {
	}

	public ProductEntity(int productId, String productName, int price, String productSeller, ProductType productType) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.productSeller = productSeller;
		this.productType = productType;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProductSeller() {
		return productSeller;
	}

	public void setProductSeller(String productSeller) {
		this.productSeller = productSeller;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	@Override
	public String toString() {
		return "ProductEntity [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", productSeller=" + productSeller + ", productType=" + productType + "]";
	}

}
