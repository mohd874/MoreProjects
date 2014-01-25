/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
@Table(name = "attendees3")
public class Attendee3 implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "attendee_id")
    private Long id;
    
    @Column(name = "attendee_name")
    private String name;
    
    @org.hibernate.annotations.CollectionOfElements
    @JoinTable(name = "emails3",joinColumns=@JoinColumn(name="attendee_id"))
    @Column(name="email",nullable=false)
    private List<String> emails = new ArrayList<String>();

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

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public void addEmail(String email){
        emails.add(email);
    }
}
