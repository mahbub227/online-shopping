package com.bjit.shoppingbackend.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Orders")
public class Orders  implements Serializable {
	
private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="orderId")
	private int orderId; 
	
	@Column(name="vat")
	private int vat;
	@Column(name="shippingCost")
	private int shippingCost;
	@Column(name="status")
	private boolean status;
	@Column(name="createdOn")
	Date createdOn = new Date();
	@Column(name="updatedOn")
	Date updatedOn = new Date(); 
	@OneToOne
	@JoinColumn(name="userId")
	private Users users;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public int getVat() {
		return vat;
	}
	public void setVat(int vat) {
		this.vat = vat;
	}
	public int getShippingCost() {
		return shippingCost;
	}
	public void setShippingCost(int shippingCost) {
		this.shippingCost = shippingCost;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
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
		return "Orders [orderId=" + orderId + ", vat=" + vat + ", shippingCost=" + shippingCost + ", status=" + status
				+ ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", users=" + users + "]";
	}

	
	
}
