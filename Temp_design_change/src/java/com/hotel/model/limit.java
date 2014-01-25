package com.hotel.model;

/*
 * - limit.java
 * - Author: Mohammed Omar --- mohd874@hotmail.com
 * - Priject: Hotel Reservation & Account Managment System for Daffodiles Palace Hotel
 * - Date: 06-06-2006
 * - Purpose: used to store numbers that will be used as a LIMIT in sql statments in database control page which will grant pageing function
 */

public class limit {
    
    private String limit_1, limit_2;
    
    public limit() {
        
    }
    
    public limit(String L_1, String L_2) {
        
        if(L_1.equalsIgnoreCase("") || L_1.equalsIgnoreCase(null)){
            L_1 = "0";
        }
        if(L_2.equalsIgnoreCase("") || L_2.equalsIgnoreCase(null)){
            L_2 = "10";
        }
        
        setLimit_1(L_1);
        setLimit_2(L_2);
    }

    public String getLimit_1() {
        return limit_1;
    }

    public void setLimit_1(String limit_1) {
        this.limit_1 = limit_1;
    }

    public String getLimit_2() {
        return limit_2;
    }

    public void setLimit_2(String limit_2) {
        this.limit_2 = limit_2;
    }
}
