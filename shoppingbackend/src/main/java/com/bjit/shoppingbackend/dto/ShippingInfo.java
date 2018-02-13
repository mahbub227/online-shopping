package com.bjit.shoppingbackend.dto;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ShippingInfo implements Serializable {

	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shippingId;
	private int userId;
	private int shippingCountryId;
	private String shippingAddress;
	private String shippingZipCode;
	private String shippingCity;
	
	
	public int getShippingId() {
		return shippingId;
	}
	public void setShippingId(int shippingId) {
		this.shippingId = shippingId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getShippingCountryId() {
		return shippingCountryId;
	}
	public void setShippingCountryId(int shippingCountryId) {
		this.shippingCountryId = shippingCountryId;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public String getShippingZipCode() {
		return shippingZipCode;
	}
	public void setShippingZipCode(String shippingZipCode) {
		this.shippingZipCode = shippingZipCode;
	}
	public String getShippingCity() {
		return shippingCity;
	}
	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}
	
	@Override
	public String toString() {
		return "ShippingInfo [shippingId=" + shippingId + ", userId=" + userId + ", shippingCountryId="
				+ shippingCountryId + ", shippingAddress=" + shippingAddress + ", shippingZipCode=" + shippingZipCode
				+ ", shippingCity=" + shippingCity + "]";
	}
	
	
	
	
}
