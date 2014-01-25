package com.me.model;

import java.util.ArrayList;
import java.util.List;

public class Attendee {

    private int id;
    private String login;
    private String password;
    private String name;
    private List<String> emails = new ArrayList<String>();

    public Attendee() {

    }

    public Attendee(int attendeeId, String login, String password, String name) {
        this(attendeeId, login, password, name, new ArrayList<String>());
    }

    public Attendee(int attendeeId, String login, String password, String name, List<String> emails) {
        this.id = attendeeId;
        this.login = login;
        this.password = password;
        this.name = name;
        this.emails = emails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }
}
