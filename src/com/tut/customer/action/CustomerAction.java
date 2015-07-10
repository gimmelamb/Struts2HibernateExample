package com.tut.customer.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;


import org.apache.struts2.util.ServletContextAware;
import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tut.customer.model.Customer;
import com.tut.customer.dao.CustomerDAO;
import com.tut.customer.dao.impl.CustomerDAOImpl;


public class CustomerAction extends ActionSupport implements ModelDriven, ServletContextAware{
	private ServletContext ctx;
	Customer customer = new Customer();
	List<Customer> customerList = new ArrayList<Customer>();
	
	
	
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	
	public String addCustomer() throws Exception {
		SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
		CustomerDAO customerDAO = new CustomerDAOImpl(sf);
		customerDAO.addCustomer(customer);
		customerList = customerDAO.listCustomer();
		return SUCCESS;
	}
	
	public String listCustomer() throws Exception{
		SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
		CustomerDAO customerDAO = new CustomerDAOImpl(sf);
		customerList = customerDAO.listCustomer();
		return SUCCESS;
	}
	
	public String deleteCustomer() throws Exception{
		SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
		CustomerDAO customerDAO = new CustomerDAOImpl(sf);
		customerDAO.deleteCustomer(customer.getCustomerId());
		customerList = customerDAO.listCustomer();
		return SUCCESS;
	}



	@Override
	public Object getModel() {
		return customer;
	}



	public List<Customer> getCustomerList() {
		return customerList;
	}



	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	@Override
	public void setServletContext(ServletContext sc) {
		
		this.ctx = sc;
	}
	
	

}
