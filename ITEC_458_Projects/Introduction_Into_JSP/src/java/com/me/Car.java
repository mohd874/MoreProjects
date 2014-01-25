/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me;

/**
 *
 * @author Saeed
 */
public class Car {

    private String name;
    private int id;
    
    public Car(){
        
    }
    
    public Car(String name, int id){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID: "+id+", name: "+name;
    }
    
}
