/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ikonsoft.services;

import com.ikonsoft.model.Question;
import java.util.Iterator;
import java.util.List;
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
public class SurveyServiceTest {
    
    public SurveyServiceTest() {
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

    /**
     * Test of getQuestions method, of class SurveyService.
     */
    @Test
    public void testGetQuestions() {
        System.out.println("getQuestions");
        SurveyService instance = new SurveyService();
         
        List<Question> result = instance.getQuestions();
       Iterator<Question> i =  result.iterator();
       while (i.hasNext()){
           Question q=i.next();
           System.out.println("Question id :" + q.getQuestionId()+"  Question:"+q.getQuestion());
       }
    }
    
}
