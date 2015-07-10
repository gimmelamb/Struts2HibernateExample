package com.tut.customer.listener;

import java.net.URL;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public class MyAppServletContextListener implements ServletContextListener {
    
    private static ServiceRegistry serviceRegistry;

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		SessionFactory sf = (SessionFactory) sce.getServletContext().getAttribute("SessionFactory");
        sf.close();
        
 
        //context.setAttribute("sessionFactory", sf);

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
        try{
        	URL url = MyAppServletContextListener.class.getResource("/hibernate.cfg.xml");
            Configuration config = new Configuration().configure(url);
            
            serviceRegistry = new StandardServiceRegistryBuilder()
                            .applySettings(config.getProperties()).build();
            SessionFactory sf = config.buildSessionFactory(serviceRegistry);
            sce.getServletContext().setAttribute("SessionFactory", sf);
    		
           
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
	}

}
