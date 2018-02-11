package com.bjit.shoppingbackend.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	@NotBlank(message="Please Enter the Product Name!")
	private String productName;
	private int quantity;
	private int views;
	private String image;
	@JsonIgnore
	private boolean active;
	private double originalPrice;
	private double discountPrice;
	@JsonIgnore
	@NotBlank(message="Please Enter the Description!")
	private String description;
	@JsonIgnore
	private int categoryId;
	@JsonIgnore
	Date createdOn = new Date();
	@JsonIgnore
	Date updatedOn = new Date();
	
	
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public double getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}
	public double getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", quantity=" + quantity
				+ ", views=" + views + ", image=" + image + ", active=" + active + ", originalPrice=" + originalPrice
				+ ", discountPrice=" + discountPrice + ", description=" + description + ", categoryId=" + categoryId
				+ ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + "]";
	}
	
}
