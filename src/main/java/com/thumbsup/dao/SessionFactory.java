package com.thumbsup.dao;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionFactory {

	private static SessionFactory instance = null;
	private static org.hibernate.SessionFactory sessionFactory = null;
	
	private SessionFactory()
	{
		Configuration configuration = new Configuration().configure();

		StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
		serviceRegistryBuilder.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public static SessionFactory getSessionFactory()
	{
		if(instance == null)
		{
			instance = new SessionFactory();
		}
		return instance;
	}
	
	public Session getSession()
	{
		return sessionFactory.openSession();
	}
}
