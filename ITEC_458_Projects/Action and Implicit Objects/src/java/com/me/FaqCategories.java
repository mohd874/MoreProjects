/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me;

import java.util.ArrayList;

/**
 *
 * @author Saeed
 */
public class FaqCategories {
    private ArrayList<String> categories = new ArrayList<String>();
    
    public FaqCategories(){
        categories.add("Date and Times");
        categories.add("Strings and StringBuffers");
        categories.add("Threading");
    }
    
    public ArrayList<String> getCategories(){
        return categories;
    }
}
