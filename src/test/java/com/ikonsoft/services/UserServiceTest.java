/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ikonsoft.services;

import com.ikonsoft.model.User;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author mohamed
 */
public class UserServiceTest {
    
    public UserServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCreateUser() {
        System.out.println("create User Test");
        UserService userService = new UserService();
        User user=new User();
        user.setEmailId("moh3292@gmail.com");
        user.setPassword("123");
       System.out.println("The user id returns "+userService.createUser(user) )  ;
       
         
    }
    
	@Test
	public final void testGetUserByEmailId() {
		 System.out.println("Test Get User by Email");
	        UserService userService = new UserService();
	        User user;
	        String email="moh1@gmail.com";
	       
	       user=  userService.getUserByEmailId(email);
	         
	        System.out.println("The user is found: "+user.getFirstName());
	}
}
