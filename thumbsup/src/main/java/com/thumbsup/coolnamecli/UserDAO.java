package com.thumbsup.coolnamecli;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class UserDAO {

	private static SessionFactory SessionFactory;
	
	public static void main( String[] args )
    {
		Configuration configuration = new Configuration().configure();
		
		StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
		serviceRegistryBuilder.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
		SessionFactory = configuration.buildSessionFactory(serviceRegistry);

		
		//TESTING SECTION
		UserDAO UserManager = new UserDAO();
//		
//		User u = new User();
//		u.setUserName("Testsad");
//		
//		UserManager.deleteUser(u);
//		
//		User u = new User();
//		u.setUserName("Testsad");
//		u.setPassword("testinP{assd");
//		u.setPasswordSalt("eee");
//		
//		UserManager.insertUser(u);
//		
//		User x = selectUser(u.getUserName());
//		System.out.println(x.getUserName());
//		System.out.println(x.getPassword());
//		
//		List<User> list = UserManager.selectAllUsers();
//		
//		for(User user: list){
//			System.out.println(user.getUserName());
//			System.out.println(user.getFirstName());
//			System.out.println(user.getLastName());
//		}
//		
//		u.setPassword("eteasd");
		
//		UserManager.updateUser(u);
//		
//		User y = selectUser(u.getUserName());
//		System.out.println(y.getUserName());
//		System.out.println(y.getPassword());
		
		
    }
	
    public static void insertUser(User u)
    {
    	Session s = SessionFactory.openSession();
		Transaction t = s.beginTransaction();        
		s.save(u);
        t.commit();
        s.close();
    }
    
    public static User selectUser(String username)
    {
    	User selectedUser = new User();
    	
    	Session s = SessionFactory.openSession();
//        System.out.println( "Hello World!" );  
    	
    	Transaction transaction = s.beginTransaction();
        selectedUser = (User)s.get(User.class, username);
        transaction.commit();
        
        s.close();
        return selectedUser;
    }
    
    public static List<User> selectAllUsers()
    {
        List<User> userList = new ArrayList<User>();
    	
    	Session s = SessionFactory.openSession();    
        
    	Transaction transaction = s.beginTransaction();
        userList = s.createCriteria(User.class).list();
        transaction.commit();
        
        s.close();
        
        return userList;
    }
    
    /**
     * This method is used to update a user object within the database
     * 
     * @param updatedUser : the user to be updated
     * @return void
     */
    public static void updateUser(User updatedUser)
    {   	
    	Session s = SessionFactory.openSession();
    	
    	User oldUser = (User) s.load(User.class, updatedUser.getUserName());
    	
    	Transaction transaction = s.beginTransaction();
    	s.update(updatedUser);
    	transaction.commit();
    	
    	s.close();    	
    }
    
    public static void deleteUser(User user){
    	Session s = SessionFactory.openSession();
    	
    	Transaction transaction = s.beginTransaction();
    	s.delete(user);
    	transaction.commit();
    	
    	s.close();
    	
    }
}
