/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Saeed
 */
public class ValidationUtil {

    public static boolean validateEmail(String email) {
        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");

        Matcher m = p.matcher(email);

        boolean matchFound = m.matches();

        return matchFound;
    }

    //TEST
    public static void main(String args[]) {
        //Input the string for validation
        String email = "xyz@hotmail.com";

        //Set the email pattern string
        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");

        //Match the given string with the pattern
        Matcher m = p.matcher(email);

        //check whether match is found 
        boolean matchFound = m.matches();

        if (matchFound) {
            System.out.println("Valid Email Id.");
        } else {
            System.out.println("Invalid Email Id.");
        }
    }
}
