
package com.hotel.model;

public class tracing_bean {
    
    //tracing
    private String empty_string = "";
    private String null_string = null;
    private String defult_name = "Guest";
    private String uname;
    private String utype;
    


    //sql query requorment
    
    //String sql_query = "insert into customer_reservation" 
    //          +"(arrival_date,depart_date,flight_number,confirmation,note,credit_card_no,"
    //		+"credit_card_type,credit_card_exp_month,credit_card_exp_year,customer_id,room_id)"
    //          +"values ('2006-11-2','2006-11-9','k009','n','test','82980883','visa card','4','2007','1','3') ";
           
    
    private String ard;
    private String dpd;
    private String flight;
    private String ccn;
    private String cct;
    private int expm;
    private int expy;
    private char cfm;
    private String userID;
    public String rooms_id[];

    //others
    public String[] roomT;
    public String[] roomV;
    public String[] price;
    
    public tracing_bean() {
        setEmpty_string("");
        setNull_string(null);
        setDefult_name("Guest");
    }

    public tracing_bean(String uname,String utype,String ID) {
        setUname(uname);
        setUtype(utype);
        setUserID(ID);
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

    
}
