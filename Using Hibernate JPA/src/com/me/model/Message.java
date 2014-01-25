/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Saeed
 */
@Entity
@Table(name="MESSAGE4")
public class Message 
{
    @Id @GeneratedValue
    @Column(name = "id")
    private Long id;
    
    @Column(name = "text")
    private String text;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "next_message_id")
    private Message nextMessage;

    public Message() {
    }

    public Message(String text) {
        this.text = text;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Message getNextMessage() {
        return nextMessage;
    }

    public void setNextMessage(Message nextMessage) {
        this.nextMessage = nextMessage;
    }
}
