/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Saeed
 */

@Entity
@Table(name = "user1")
public class User1 {

    @Id @GeneratedValue @Column(name = "user_id")
    private Long id;
    
    @Column(name="first_name")
    private String firstName;
    
    @Column(name="last_name")
    private String lastName;
    
    @Column(name="is_admin")
    @org.hibernate.annotations.Type(type="yes_no")
    private boolean admin;
    
    @Embedded
    private Address homeAddress = new Address();
    
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="street",
                            column = @Column(name="work_street")),
        @AttributeOverride(name="city",
                            column = @Column(name="work_city"))
    })
    private Address workAddress = new Address();

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

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(Address workAddress) {
        this.workAddress = workAddress;
    }
    
    
}
