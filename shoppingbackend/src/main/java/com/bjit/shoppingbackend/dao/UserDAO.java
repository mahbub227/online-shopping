package com.bjit.shoppingbackend.dao;

import java.util.List;

import com.bjit.shoppingbackend.dto.Address;
import com.bjit.shoppingbackend.dto.Orders;
import com.bjit.shoppingbackend.dto.Users;

public interface UserDAO {
	
	boolean addUsers(Users users);
	boolean updateOrders(Orders orders);
	Users getByEmail(String email);
	
	Address getAddress(int addressId);
	boolean addAddress(Address address);
	boolean updateAddress(Address address);
	Address getBillingAddress(int userId);
	List<Address> listShippingAddresses(int userId);
}