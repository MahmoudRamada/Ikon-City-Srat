/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ikonsoft.email;

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
public class SendAttachmentInEmailTest {
    
    public SendAttachmentInEmailTest() {
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
    public void testSendMail() throws Exception {
        System.out.println("sendMail");
        String bcc = "mhd911@yahoo.com,mohamed.moftah@gmail.com,mhd911911@gmail.com";
        String cc = "";
        String to = "mhd911911@gmail.com";
        String subject = "Test message";
        String body = "Message body";
        String senderName = "Eng Moftah";
        String filepath = "";
        String filename = "";
        SendAttachmentInEmail.sendMail(bcc, cc, to, subject, body, senderName, filepath, filename);
        
    }
    
}
