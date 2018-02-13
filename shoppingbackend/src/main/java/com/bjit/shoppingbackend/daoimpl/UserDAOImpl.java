package com.bjit.shoppingbackend.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bjit.shoppingbackend.dao.UserDAO;
import com.bjit.shoppingbackend.dto.BillingInfo;
import com.bjit.shoppingbackend.dto.Orders;
import com.bjit.shoppingbackend.dto.ShippingInfo;
import com.bjit.shoppingbackend.dto.Users;


@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addUsers(Users users) {
		// TODO Auto-generated method stub
		try {			
			sessionFactory
					.getCurrentSession()
						.persist(users);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;
	}

	@Override
	public boolean addShippingInfo(ShippingInfo shippingInfo) {
		// TODO Auto-generated method stub
		try {			
			sessionFactory
					.getCurrentSession()
						.persist(shippingInfo);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;
	}

	@Override
	public boolean addBillingInfo(BillingInfo billingInfo) {
		// TODO Auto-generated method stub
		try {			
			sessionFactory
					.getCurrentSession()
						.persist(billingInfo);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;
	}

	@Override
	public boolean addOrders(Orders orders) {
		// TODO Auto-generated method stub
		try {			
			sessionFactory
					.getCurrentSession()
						.persist(orders);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;

	}
}


