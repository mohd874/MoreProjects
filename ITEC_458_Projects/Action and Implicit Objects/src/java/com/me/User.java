/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me;

/**
 *
 * @author Saeed
 */
public class User {
    private String firstName,lastName,login;
    private int age;
    
    public User(){
        
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
