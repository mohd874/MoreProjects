

package com.hotel.model;

import java.util.Hashtable;


public class reservation_on_error {
    private String ard;
    private String dpd;
    private String flight;
    private String ccn;
    private String cct;
    private int expm;
    private int expy;
    private char cfm;
    private Hashtable ht;
    
    public reservation_on_error() {
        
    }
    
    public reservation_on_error(String ard,String dpd,String flight,String ccn,String cct,int expm,int expy,char cfm, Hashtable ht) {
        setArd(ard);
        setDpd(dpd);
        setFlight(flight);
        setCcn(ccn);
        setCct(cct);
        setExpm(expm);
        setExpy(expy);
        setCfm(cfm);
        setHt(ht);
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
    
}
