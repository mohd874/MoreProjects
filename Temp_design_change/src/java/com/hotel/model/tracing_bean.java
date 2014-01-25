package com.hotel.model;

/*
 * - tracing_bean.java
 * - Author: Mohammed Omar --- mohd874@hotmail.com
 * - Priject: Hotel Reservation & Account Managment System for Daffodiles Palace Hotel
 * - Date: 06-06-2006
 * - Purpose: This class is used to save the user information while surfing the website. This information include: userID, user_name, surname, user_type
 */

public class tracing_bean {
    
    //preparing and reseting values
    private String empty_string = "";
    private String null_string = null;
    private String defult_name = "Guest";
    private String uname;
    private String utype;
    private String name;
    private String title;
    private String surname;

    private String ard; //Arrival Date
    private String dpd; //Depart Date
    private String flight; //Flight Number
    private String ccn; //Credit Card Number
    private String cct; //Credit Card Type
    private int expm; //Credit Card Expiry Month
    private int expy; //Credit Card Expiry Year
    private char cfm; //Email Confirmation
    private String userID; //User ID
    private String customer_id; //Customer_id (user by the reseptionist)
    public String rooms_id[]; //Selected Rooms

    //others
    public String[] roomT; //Selected Rooms Type
    public String[] roomV; //Selected Rooms View
    public String[] price; //Selected Rooms Price
    
    public tracing_bean() {
        setEmpty_string("");
        setNull_string(null);
        setDefult_name("Guest");
    }

    public tracing_bean(String uname,String name, String utype,String ID) {
        setUname(uname);
        setName(name);
        setUtype(utype);
        setUserID(ID);
        setEmpty_string("");
        setNull_string(null);
        setDefult_name("Guest");
    }
        public tracing_bean(String uname,String name, String utype,String ID, String surname, String title) {
        setUname(uname);
        setName(name);
        setUtype(utype);
        setUserID(ID);
        setSurname(surname);
        setTitle(title);
        setEmpty_string("");
        setNull_string(null);
        setDefult_name("Guest");
    }
    
    public tracing_bean(String uname,String utype, String roomT, String roomV, String price){
        setUname(uname);
        setUtype(utype);
        setEmpty_string("");
        setNull_string(null);
        setDefult_name("Guest");
    }
    
    public tracing_bean(String uname,String utype,String ard,String dpd,String flight,String ccn,String cct,int expm,int expy,char cfm){
        setUname(uname);
        setUtype(utype);
        setEmpty_string("");
        setNull_string(null);
        setDefult_name("Guest");
        setArd(ard);
        setDpd(dpd);
        setFlight(flight);
        setCcn(ccn);
        setCct(cct);
        setExpm(expm);
        setExpy(expy);
        setCfm(cfm);
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUtype() {
        return utype;
    }

    public void setUtype(String utype) {
        this.utype = utype;
    }

    public String getEmpty_string() {
        return empty_string;
    }

    public void setEmpty_string(String empty_string) {
        this.empty_string = empty_string;
    }

    public String getNull_string() {
        return null_string;
    }

    public void setNull_string(String null_string) {
        this.null_string = null_string;
    }

    public String getDefult_name() {
        return defult_name;
    }

    public void setDefult_name(String defult_name) {
        this.defult_name = defult_name;
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

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
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

    public String[] getRoomT() {
        return roomT;
    }

    public void setRoomT(String[] roomT) {
        this.roomT = roomT;
    }

    public String[] getRoomV() {
        return roomV;
    }

    public void setRoomV(String[] roomV) {
        this.roomV = roomV;
    }

    public String[] getPrice() {
        return price;
    }

    public void setPrice(String[] price) {
        this.price = price;
    }

    public String[] getRooms_id() {
        return rooms_id;
    }

    public void setRooms_id(String[] rooms_id) {
        this.rooms_id = rooms_id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.setUserID(userID);
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    
}
