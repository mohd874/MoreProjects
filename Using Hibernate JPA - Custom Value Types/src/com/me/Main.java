/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me;

import com.me.model.Address;
import com.me.model.User1;
import com.me.model.User2;
import com.me.model.User3;
import com.me.model.User4;
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
        
        String firstName = "Ali";
        String lastName = "Ahmed";
        String street = "Airport Road";
        String city = "Abu Dhabi";
        String workStreet = "AlSaada Street";
        boolean isAdmin = true;
        
        User1 user1 = new User1();
        user1.setFirstName(firstName);
        user1.setLastName(lastName);
        user1.setAdmin(isAdmin);
        user1.setHomeAddress(new Address(street, city));
        user1.setWorkAddress(new Address(workStreet, city));
        em.persist(user1);
        
        User2 user2 = new User2();
        user2.setFirstName(firstName);
        user2.setLastName(lastName);
        user2.setAdmin(isAdmin);
        
        user2.addAddress(new Address(street, city));
        user2.addAddress(new Address(workStreet, city));
        em.persist(user2);
        
        User3 user3 = new User3();
        user3.setFirstName(firstName);
        user3.setLastName(lastName);
        user3.setAdmin(isAdmin);
        
        user3.addAddress(new Address(street, city));
        user3.addAddress(new Address(workStreet, city));
        em.persist(user3);
        
        User4 user4 = new User4();
        user4.setFirstName(firstName);
        user4.setLastName(lastName);
        user4.setAdmin(isAdmin);
        
        user4.addAddress(new Address(street, city));
        user4.addAddress(new Address(workStreet, city));
        em.persist(user4);
        
        tx.commit();
        em.close();
        
        //shutting down the application
        emf.close();
    }

}
