/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me;

import com.me.model.Attendee1;
import com.me.model.Attendee2;
import com.me.model.Attendee3;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Saeed
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mainapp2");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        //using two emails
        Attendee1 attendee1 = new Attendee1();
        attendee1.setName("Ali Ahmed");
        attendee1.setEmail1("ali@hotmail.com");
        attendee1.setEmail2("ali@gmail.com");
        em.persist(attendee1);
        
        //using set as the collection type
        Attendee2 attendee2 = new Attendee2();
        attendee2.setName("Ali Ahmed");
        attendee2.addEmail("ali@hotmail.com");
        attendee2.addEmail("ali@gmail.com");
        em.persist(attendee2);
        
        
        //using list as the collection type
        Attendee3 attendee3 = new Attendee3();
        attendee3.setName("Ali Ahmed");
        attendee3.addEmail("ali@hotmail.com");
        attendee3.addEmail("ali@gmail.com");
        em.persist(attendee3);
        
        tx.commit();
        em.close();
        
        //shutting down the application
        emf.close();
    }

}
