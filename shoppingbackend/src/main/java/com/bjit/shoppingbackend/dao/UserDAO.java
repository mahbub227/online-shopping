package com.bjit.shoppingbackend.dao;

import com.bjit.shoppingbackend.dto.BillingInfo;
import com.bjit.shoppingbackend.dto.Orders;
import com.bjit.shoppingbackend.dto.ShippingInfo;
import com.bjit.shoppingbackend.dto.Users;

public interface UserDAO {
	
	boolean addUsers(Users users);
	boolean addShippingInfo(ShippingInfo shippingInfo);
	boolean addBillingInfo(BillingInfo billingInfo);
	boolean addOrders(Orders orders);
}