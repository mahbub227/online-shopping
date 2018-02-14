package com.bjit.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bjit.shoppingbackend.dao.UserDAO;
import com.bjit.shoppingbackend.dto.Address;
import com.bjit.shoppingbackend.dto.Orders;
import com.bjit.shoppingbackend.dto.Users;

public class UsersTestCase {

private static AnnotationConfigApplicationContext context;
	
	
	private static UserDAO userDAO;

	
	private Users users;
	private Address address;
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
		users.setFirstName("Abu");
		users.setLastName("Ubaidah");
		users.setContactNo("017655555");
		users.setStatus(true);
		users.setEmail("abuUba@gmail.com");
		users.setPassword("user");
		users.setRole("user");
		
		//if(users.getRole().equals("user")) {
		
	    orders = new Orders();
	    orders.setUsers(users);
		orders.setShippingCost(1);
		orders.setVat(1);
		orders.setStatus(true);
		users.setOrders(orders);
		assertEquals("Something went wrong while inserting a new product!",
				true,userDAO.addUsers(users));	
			
		address = new Address();
		address.setAddress("101/B Jadoo Society, Krissh Nagar");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);
	
			
			assertEquals("Something went wrong while inserting a new product!", 
					true,userDAO.addAddress(address));
			
			address = new Address();
			address.setAddress("101/B Jadoo Society, Krissh Nagar");
			address.setCity("Mumbai");
			address.setState("Maharashtra");
			address.setCountry("India");
			address.setPostalCode("400001");
			address.setShipping(true);
		
				
				assertEquals("Something went wrong while inserting a new product!", 
						true,userDAO.addAddress(address));
		
			
		
			
		
		
	//	}
}
}
