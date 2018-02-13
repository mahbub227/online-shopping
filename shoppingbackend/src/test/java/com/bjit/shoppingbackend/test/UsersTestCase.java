package com.bjit.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bjit.shoppingbackend.dao.UserDAO;
import com.bjit.shoppingbackend.dto.BillingInfo;
import com.bjit.shoppingbackend.dto.Orders;
import com.bjit.shoppingbackend.dto.ShippingInfo;
import com.bjit.shoppingbackend.dto.Users;

public class UsersTestCase {

private static AnnotationConfigApplicationContext context;
	
	
	private static UserDAO userDAO;

	
	private Users users;
	private ShippingInfo shippingInfo;
	private BillingInfo billingInfo;
	private Orders orders;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.bjit.shoppingbackend");
		context.refresh();
		userDAO = (UserDAO)context.getBean("userDAO");
	}
	
	@Test
	public void testCRUDUsers() {
		users = new Users();
		users.setFirstName("Sadda");
		users.setLastName("Alam");
		users.setContactNo("017317326118");
		users.setStatus(true);
		users.setEmail("saddam@bgo4sdfp.com");
		users.setPassword("user");
		users.setRole("user");
		
		orders.setUserId(4);
		assertEquals("Something went wrong while inserting a new product!",
				true,userDAO.addOrders(orders));
		
		assertEquals("Something went wrong while inserting a new product!",
				true,userDAO.addUsers(users));		
		
		shippingInfo.setUserId(4);
		shippingInfo.setShippingZipCode("1232C");
		shippingInfo.setShippingAddress("Baridhara,Bangladesh");
		shippingInfo.setShippingCountryId(2);
		shippingInfo.setShippingCity("Dhaka");
		
		assertEquals("Something went wrong while inserting a new product!", 
				true,userDAO.addShippingInfo(shippingInfo));		
		
	
		
		if(users.getRole().equals("user")) {
			billingInfo.setUserId(4);
			billingInfo.setBillingZipCode("1232D");
			billingInfo.setBillingAddress("Baridhara,Bangladesh");
			billingInfo.setBillingCountryId(2);
			billingInfo.setBillingCity("Dhaka");
			
			assertEquals("Something went wrong while inserting a new product!",
					true,userDAO.addBillingInfo(billingInfo));		
			
			orders.setUserId(4);
			assertEquals("Something went wrong while inserting a new product!",
					true,userDAO.addOrders(orders));
		}
}
}
