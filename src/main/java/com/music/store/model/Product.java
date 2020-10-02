package com.music.store.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="music_product")
public class Product {
	
	@Transient
	private MultipartFile imageId;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productId;
	
	@NotEmpty(message="Name must be needed of product")
	@Column(name="product_Name")
	private String productName;
	
	@Column(name="product_Category")
	private String productCategory;
	
	@Column(name="product_Description")
	private String productDescription;
	
	@Min(value=0 , message="Price should be greater than 0")
	@Column(name="product_Price")
	private double productPrice;
	
	@Column(name="produc_Condition")
	private String producCondition;
	
	@Column(name="product_Status")
	private String productStatus;
	
	@Min(value=0 , message="Unit Stock should be greater than 0")
	@Column(name="unitInStock")
	private int unitInStock;
	
	@Column(name="product_Manufacturer")
	private String productManufacturer;
	
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
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProducCondition() {
		return producCondition;
	}
	public void setProducCondition(String producCondition) {
		this.producCondition = producCondition;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	public int getUnitInStock() {
		return unitInStock;
	}
	public void setUnitInStock(int unitInStock) {
		this.unitInStock = unitInStock;
	}
	public String getProductManufacturer() {
		return productManufacturer;
	}
	public void setProductManufacturer(String productManufacturer) {
		this.productManufacturer = productManufacturer;
	}
	public MultipartFile getImageId() {
		return imageId;
	}
	public void setImageId(MultipartFile imageId) {
		this.imageId = imageId;
	}
	
	
	

}
