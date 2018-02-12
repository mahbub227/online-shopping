package com.bjit.shoppingbackend.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Users implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String contactNo;
	private boolean status;
	private String billingAddress;
	private String billingCity;
	private String billingZipCode;
	private int billingCountry;
	private String shippingAddress;
	private String shippingCity;
	private String shippingZipCode;
	private int shippingCountry;
	Date createdOn = new Date();
	Date updatedOn = new Date();
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	public String getBillingCity() {
		return billingCity;
	}
	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}
	public String getBillingZipCode() {
		return billingZipCode;
	}
	public void setBillingZipCode(String billingZipCode) {
		this.billingZipCode = billingZipCode;
	}
	public int getBillingCountry() {
		return billingCountry;
	}
	public void setBillingCountry(int billingCountry) {
		this.billingCountry = billingCountry;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public String getShippingCity() {
		return shippingCity;
	}
	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}
	public String getShippingZipCode() {
		return shippingZipCode;
	}
	public void setShippingZipCode(String shippingZipCode) {
		this.shippingZipCode = shippingZipCode;
	}
	public int getShippingCountry() {
		return shippingCountry;
	}
	public void setShippingCountry(int shippingCountry) {
		this.shippingCountry = shippingCountry;
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
		return "Users [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", contactNo=" + contactNo + ", status=" + status + ", billingAddress="
				+ billingAddress + ", billingCity=" + billingCity + ", billingZipCode=" + billingZipCode
				+ ", billingCountry=" + billingCountry + ", shippingAddress=" + shippingAddress + ", shippingCity="
				+ shippingCity + ", shippingZipCode=" + shippingZipCode + ", shippingCountry=" + shippingCountry
				+ ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + "]";
	}
	
	
	
}