package com.bjit.shoppingbackend.dto;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BillingInfo implements Serializable {
	
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int billingId;
	private int userId;
	private int billingCountryId;
	private String billingAddress;
	private String billingCity;
	private String billingZipCode; 
	
	
	public int getBillingId() {
		return billingId;
	}
	public void setBillingId(int billingId) {
		this.billingId = billingId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBillingCountryId() {
		return billingCountryId;
	}
	public void setBillingCountryId(int billingCountryId) {
		this.billingCountryId = billingCountryId;
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
	@Override
	public String toString() {
		return "BillingInfo [billingId=" + billingId + ", userId=" + userId + ", billingCountryId=" + billingCountryId
				+ ", billingAddress=" + billingAddress + ", billingCity=" + billingCity + ", billingZipCode="
				+ billingZipCode + "]";
	}
	
	
	
	
	
}
