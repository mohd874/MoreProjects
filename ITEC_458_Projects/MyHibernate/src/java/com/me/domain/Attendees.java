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
@Table(name = "attendees")
@NamedQueries({@NamedQuery(name = "Attendees.findById", query = "SELECT a FROM Attendees a WHERE a.id = :id"), @NamedQuery(name = "Attendees.findByLogin", query = "SELECT a FROM Attendees a WHERE a.login = :login"), @NamedQuery(name = "Attendees.findByPassword", query = "SELECT a FROM Attendees a WHERE a.password = :password"), @NamedQuery(name = "Attendees.findByName", query = "SELECT a FROM Attendees a WHERE a.name = :name")})
public class Attendees implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "login", nullable = false)
    private String login;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "name", nullable = false)
    private String name;

    public Attendees() {
    }

    public Attendees(Integer id) {
        this.id = id;
    }

    public Attendees(Integer id, String login, String password, String name) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attendees)) {
            return false;
        }
        Attendees other = (Attendees) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.me.domain.Attendees[id=" + id + "]";
    }

}
