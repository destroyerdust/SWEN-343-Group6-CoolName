package com.thumbsup.coolnamecli;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class VehicleDAO {
	
	private static SessionFactory SessionFactory;
	
	public static void main(String[] args){
		Configuration configuration = new Configuration().configure();
		
		StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
		serviceRegistryBuilder.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
		SessionFactory = configuration.buildSessionFactory(serviceRegistry);

		
	}
	

}
