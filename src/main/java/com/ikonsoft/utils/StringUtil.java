/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ikonsoft.utils;
 
 
/**   
 *
 * @author mohamed
 */
public class StringUtil {
    public static boolean isNull (String input)
    {
        return input.equals("") |input==null ;
        
    }
     public static boolean hasValue (String input)
    {
      return !(input.equals("") |input==null);
        
    }
}
