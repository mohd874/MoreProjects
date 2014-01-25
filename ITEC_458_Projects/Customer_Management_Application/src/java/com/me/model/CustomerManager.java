/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me.model;

import java.util.ArrayList;

/**
 *
 * @author Saeed
 */
public class CustomerManager {

    private static ArrayList<Customer> customers = new ArrayList<Customer>();
    
    static {
        customers.add(new Customer("1","Ali","Ahmed"));
        customers.add(new Customer("2","Khalid","Abdul Aziz"));
        customers.add(new Customer("3","Ahmed","Adbulla"));
        customers.add(new Customer("4","Saleh","Saeed"));
        customers.add(new Customer("5","Salem","Hasan"));
    }
    
    public CustomerManager(){
        
    }
    
    public static ArrayList<Customer> getCustomers(){
        return customers;
    }
    
    public static Customer getCustomer(String id){
        for(Customer c : customers){
            if(c.getId().equals(id)){
                return c;
            }
        }
        return null;
    }
    
    public static void updateCustomer(Customer customer){
        Customer c = getCustomer(customer.getId());
        if(c != null){
            c.setFirstName(customer.getFirstName());
            c.setLastName(customer.getLastName());
        }
    }
}
