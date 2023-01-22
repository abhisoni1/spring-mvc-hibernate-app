package com.web.customer.tracker.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.customer.tracker.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers(){
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
		
		List<Customer> customers = query.getResultList();
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(customer);
		
	}

	@Override
	public Customer getCustomerById(int customerId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		return session.get(Customer.class, customerId);
	}

	@Override
	public void deleteCustomerById(int customerId) {

		Session session = sessionFactory.getCurrentSession();
		
		// write HQL query
		Query query = session.createQuery("delete from Customer where id=:theCustomerId");
		
		query.setParameter("theCustomerId" , customerId);
		
		query.executeUpdate();
		
	}
}
