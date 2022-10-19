package com.flipka.ProductService.bean;


public class ProductBean {
    private String productName;
    private int price;
    private String productSeller;
    private ProductType productType;
    
	public ProductBean() {
	}
	public ProductBean(String productName, int price, String productSeller, ProductType productType) {
		this.productName = productName;
		this.price = price;
		this.productSeller = productSeller;
		this.productType = productType;
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
    
}
