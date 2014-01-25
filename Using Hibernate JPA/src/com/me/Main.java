/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me;

import com.me.model.Message;
import java.util.List;
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
    public static void main(String[] args) 
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mainapp");
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        Message message = new Message("Hello World");
        message.setNextMessage(new Message("Hello All Again"));
        em.persist(message);
        
        tx.commit();
        em.close();
        
        EntityManager em2 = emf.createEntityManager();
        EntityTransaction tx2 = em2.getTransaction();
        tx2.begin();
        
        List messages = em2.createQuery("select m from Message m order by m.text asc").getResultList();
        
        System.out.println(messages.size()+" message(s) found");
        
        for (Object m : messages) {
            Message loadedMessage = (Message) m;
            System.out.println(loadedMessage.getText());
        }

        tx2.commit();
        em2.close();
        
        //shutting down the application
        emf.close();
    }

}
