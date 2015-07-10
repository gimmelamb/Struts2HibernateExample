package com.tut.customer.dao.impl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tut.customer.dao.CustomerDAO;
import com.tut.customer.model.Customer;

public class CustomerDAOImpl implements CustomerDAO {
	private SessionFactory sf;
    
    public CustomerDAOImpl(SessionFactory sf){
        this.sf = sf;
    }
 

	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try{
			session.save(customer);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}

	}

	@Override
	public List<Customer> listCustomer() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		List<Customer> customers = null;
		try{
		 customers = (List<Customer>) session.createQuery("from Customer").list();
		 tx.commit();
	} catch(Exception e){
		tx.rollback();
		e.printStackTrace();
		}finally{
			session.close();
		}
		return customers;
	}
 
	public void deleteCustomer(int customerId) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			
			Customer customer = (Customer) session.load(Customer.class, customerId);
			if(customer!=null) {
				session.delete(customer);
			}
			session.getTransaction().commit();
		}catch(Exception ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();

		}finally {
			session.close();
		}
	}

}
