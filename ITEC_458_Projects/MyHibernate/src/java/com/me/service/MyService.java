/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me.service;

import com.me.domain.Attendees;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Saeed
 */
public class MyService {

    @PersistenceContext
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyHibernatePU");
    private static EntityManager manager = emf.createEntityManager();
    
    public static List<Attendees> getAttendees(){
        Query q = manager.createQuery("from Attendees");
        
        return q.getResultList();
    }
}
