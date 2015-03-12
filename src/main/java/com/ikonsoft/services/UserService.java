
package com.ikonsoft.services;

import com.ikonsoft.model.User;
import com.ikonsoft.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
 
public class UserService {
    public void createUser(User user)
    {  int id;
   Session session = HibernateUtil.getSessionFactory().getCurrentSession();
      Transaction trns = null;  
    try {
        session.beginTransaction();
    
        session.save(user);
        session.getTransaction().commit();
          id = user.getUserId();
        System.out.println("\n\nPerson Id :"+id);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }  
                     	          
     
    }
}
