package com.hotel.model;

/*
 * - tracing_bean.java
 * - Author: Mohammed Omar --- mohd874@hotmail.com
 * - Priject: Hotel Reservation & Account Managment System for Daffodiles Palace Hotel
 * - Date: 06-06-2006
 * - Purpose: used to store reservation input values if case that the values have any error. this class will display the values one the page
 */

import java.util.Hashtable;


public class reservation_on_error {
    private String ard; //arrival date
    private String dpd; //depart date
    private String flight; //flight number
    private String ccn; //credit card number
    private String cct; //credit card type
    private int expm; //credit card expiry month
    private int expy; //credit card expiry year
    private char cfm; //email confirmation
    private String customer_id; //customer ID
    private String note; //customer note
    private Hashtable ht; //HashTable to store errors
    
    public reservation_on_error() {
        
    }
    
    public reservation_on_error(String ard,String dpd,String flight,String ccn,String cct,int expm,int expy,char cfm, Hashtable ht, String note) {
        setArd(ard);
        setDpd(dpd);
        setFlight(flight);
        setCcn(ccn);
        setCct(cct);
        setExpm(expm);
        setExpy(expy);
        setCfm(cfm);
        setHt(ht);
        setNote(note);
    }

       public reservation_on_error(String ard,String dpd,String flight,String ccn,String cct,int expm,int expy,char cfm, Hashtable ht, String note, String customer_id) {
        setArd(ard);
        setDpd(dpd);
        setFlight(flight);
        setCcn(ccn);
        setCct(cct);
        setExpm(expm);
        setExpy(expy);
        setCfm(cfm);
        setHt(ht);
        setNote(note);
        setCustomer_id(customer_id);
    }
    
    
    public String getArd() {
        return ard;
    }

    public void setArd(String ard) {
        this.ard = ard;
    }

    public String getDpd() {
        return dpd;
    }

    public void setDpd(String dpd) {
        this.dpd = dpd;
    }

    public String getCcn() {
        return ccn;
    }

    public void setCcn(String ccn) {
        this.ccn = ccn;
    }

    public String getCct() {
        return cct;
    }

    public void setCct(String cct) {
        this.cct = cct;
    }

    public int getExpm() {
        return expm;
    }

    public void setExpm(int expm) {
        this.expm = expm;
    }

    public int getExpy() {
        return expy;
    }

    public void setExpy(int expy) {
        this.expy = expy;
    }

    public char getCfm() {
        return cfm;
    }

    public void setCfm(char cfm) {
        this.cfm = cfm;
    }

    public Hashtable getHt() {
        return ht;
    }

    public void setHt(Hashtable ht) {
        this.ht = ht;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }
    
}
