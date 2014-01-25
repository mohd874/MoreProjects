/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Saeed
 */
@Entity
@Table(name = "emails")
@NamedQueries({@NamedQuery(name = "Emails.findByEmailId", query = "SELECT e FROM Emails e WHERE e.emailId = :emailId"), @NamedQuery(name = "Emails.findByEmail", query = "SELECT e FROM Emails e WHERE e.email = :email"), @NamedQuery(name = "Emails.findByAttendeeId", query = "SELECT e FROM Emails e WHERE e.attendeeId = :attendeeId")})
public class Emails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "emailId", nullable = false)
    private Integer emailId;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "attendeeId", nullable = false)
    private int attendeeId;

    public Emails() {
    }

    public Emails(Integer emailId) {
        this.emailId = emailId;
    }

    public Emails(Integer emailId, String email, int attendeeId) {
        this.emailId = emailId;
        this.email = email;
        this.attendeeId = attendeeId;
    }

    public Integer getEmailId() {
        return emailId;
    }

    public void setEmailId(Integer emailId) {
        this.emailId = emailId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAttendeeId() {
        return attendeeId;
    }

    public void setAttendeeId(int attendeeId) {
        this.attendeeId = attendeeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailId != null ? emailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emails)) {
            return false;
        }
        Emails other = (Emails) object;
        if ((this.emailId == null && other.emailId != null) || (this.emailId != null && !this.emailId.equals(other.emailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.me.domain.Emails[emailId=" + emailId + "]";
    }

}
