package com.bjit.shoppingbackend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	@NotBlank(message = "Please enter address!")	
	@Column(name = "address")
	private String address;
	@NotBlank(message = "Please enter City!")	
	private String city;
	@NotBlank(message = "Please enter State!")	
	private String state;
	@NotBlank(message = "Please enter country!")	
	private String country;
	@Column(name ="postalCode")
	@NotBlank(message = "Please enter Postal Code!")	
	private String postalCode;
	@Column(name="shipping")
	private boolean shipping;
	@Column(name="billing")
	private boolean billing;
	
	@ManyToOne()
	@JoinColumn(name="userId")
	private Users users;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public boolean isShipping() {
		return shipping;
	}

	public void setShipping(boolean shipping) {
		this.shipping = shipping;
	}

	public boolean isBilling() {
		return billing;
	}

	public void setBilling(boolean billing) {
		this.billing = billing;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", address=" + address + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", postalCode=" + postalCode + ", shipping=" + shipping + ", billing="
				+ billing + ", users=" + users + "]";
	}
	
	
	
}
