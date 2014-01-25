/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Saeed
 */

@Entity
@Table(name = "attendees1")
public class Attendee1 implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "attendee_id")
    private Long id;
    
    @Column(name = "attendee_name")
    private String name;
    
    @Column(name = "email_1")
    private String email1;
    
    @Column(name = "email_2")
    private String email2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }
}
