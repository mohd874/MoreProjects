/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me.model;

/**
 *
 * @author Saeed
 */
public class Customer {

    private String id,firstName,lastName;
    
    public Customer(){
        
    }
    
    public Customer(String id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
            
}
