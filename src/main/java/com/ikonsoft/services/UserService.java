
package com.ikonsoft.services;

import java.util.List;

import com.ikonsoft.model.Question;
import com.ikonsoft.model.User;
import com.ikonsoft.utils.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
 
public class UserService {
	
    public int createUser(User user)
    {  int id = 0;
    User existingUser = getUserByEmailId(user.getEmailId());
    if (existingUser!=null){ 
    System.out.println("Cant create user , email already exists");
    return 0;
    }
   Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    
    try {
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
          id = user.getUserId();
        System.out.println("\n\nNew Person Id :"+id);
        } catch (RuntimeException e) {  e.printStackTrace(); } 
    
          return id;           	          
    }
    
    public User getUserByEmailId(String email)
    { User user = null;
    	 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    	   session.beginTransaction();
    	     String hql = "SELECT u FROM User u WHERE u.emailId = :email";
    	     Query query = session.createQuery(hql);
    	     query.setParameter("email",email); 
    	     
    	     List results = query.list();
    	if (results.size()>0) {      user = (User) results.get(0);
    	
    	   System.out.println("User i"+user.getUserId());
    	}else {
    		  System.out.println("User Not found");
    	}
    	  session.getTransaction().commit();
    	   
    	    return (user);        	          
    }
  
    
    
    
}
