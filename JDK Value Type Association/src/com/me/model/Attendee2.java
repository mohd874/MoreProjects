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
@Table(name = "attendees2")
public class Attendee2 implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "attendee_id")
    private Long id;
    
    @Column(name = "attendee_name")
    private String name;
    
    @org.hibernate.annotations.CollectionOfElements
    @JoinTable(name = "emails2",joinColumns=@JoinColumn(name="attendee_id"))
    @Column(name="email",nullable=false)
    private Set<String> emails = new HashSet<String>();

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

    public Set<String> getEmails() {
        return emails;
    }

    public void setEmails(Set<String> emails) {
        this.emails = emails;
    }

    public void addEmail(String email){
        emails.add(email);
    }
}
