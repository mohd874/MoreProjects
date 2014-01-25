/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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
@Table(name = "user4")
public class User4 implements Serializable{

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
    @JoinTable(name="addresses_4",joinColumns=@JoinColumn(name="user_id"))
    @org.hibernate.annotations.GenericGenerator(name="gg1",strategy="increment")
    @org.hibernate.annotations.CollectionId(
            columns=@Column(name="address_id"),
            type=@org.hibernate.annotations.Type(type="long"),
            generator="gg1"
    )
    private Collection<Address> addresses = new ArrayList<Address>();

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

    public Collection<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Collection<Address> addresses) {
        this.addresses = addresses;
    }
    
    public void addAddress(Address address){
        this.addresses.add(address);
    }
}
