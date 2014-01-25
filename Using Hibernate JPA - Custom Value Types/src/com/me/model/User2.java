/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

/**
 *
 * @author Saeed
 */
@Entity
@Table(name = "user2")
public class User2 implements Serializable{

    
    @Id @GeneratedValue @Column(name = "user_id")
    private Long id;
    
    @Column(name="first_name")
    private String firstName;
    
    @Column(name="last_name")
    private String lastName;
    
        @Column(name="is_admin")
    @org.hibernate.annotations.Type(type="yes_no")
    private boolean admin;

    @org.hibernate.annotations.CollectionOfElements
    @JoinTable(name="addresses_2",joinColumns=@JoinColumn(name="user_id"))
    private Set<Address> addresses = new HashSet<Address>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
 
    public void addAddress(Address address){
        this.addresses.add(address);
    }
}
