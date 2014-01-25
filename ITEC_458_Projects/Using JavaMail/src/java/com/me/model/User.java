/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me.model;

/**
 *
 * @author Saeed
 */
public class User {

    private String firstName;
    private String lastName;
    private String email;

    public User(String firstName, String lastName, String email){
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
