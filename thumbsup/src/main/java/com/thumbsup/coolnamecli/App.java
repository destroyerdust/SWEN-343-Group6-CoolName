package com.thumbsup.coolnamecli;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hello world!
 *
 */
public class App 
{
	static Session s;
	
    public static void main( String[] args )
    {
Configuration configuracao = new Configuration().configure();
		
		StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
		serviceRegistryBuilder.applySettings(configuracao.getProperties());
		ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
		SessionFactory sessionFactory = configuracao.buildSessionFactory(serviceRegistry);
		s = sessionFactory.openSession();
		selectAllUsers();
    }
    
    public static void insertUser()
    {
    	 
		Transaction t = s.beginTransaction();
        System.out.println( "Hello World!" );
        User u = new User();
        u.setUserName("test");
        u.setPassword("132");
        u.setPasswordSalt("salt");
        
        System.out.println(u.getUserName());
        System.out.println(u.getPassword());
        System.out.println(u.getPasswordSalt());
        
        s.save(u);
        t.commit();
        s.close();
    }
    
    public static void selectUser()
    {
        System.out.println( "Hello World!" );
        User u = new User();
        
        u = (User)s.load(User.class, "test");
        
        System.out.println(u.getUserName());
        System.out.println(u.getPassword());
        System.out.println(u.getPasswordSalt());
        
        s.close();
    }
    
    public static void selectAllUsers()
    {
    	System.out.println( "Hello World!" );
        List<User> u = new ArrayList<User>();
        
        u = s.createCriteria(User.class).list();
        
        for (User user : u) {
        	System.out.println(user.getUserName());
            System.out.println(user.getPassword());
            System.out.println(user.getPasswordSalt());	
		}
        
        s.close();
    }
}
