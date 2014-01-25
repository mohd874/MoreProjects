package com.me;

import java.util.*;
import org.hibernate.*;
import com.me.da.HibernateUtil;
import com.me.model.Message;

public class Main {

    public static void main(String[] args) {
        Session session1 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session1.beginTransaction();

        Message message = new Message("Hello Word");
        Long messageId = (Long) session1.save(message);

        tx.commit();
        session.close();

        session session2 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx2 = session2.beginTransaction();
        List messages = session2.createQuery(
                "from Message m order by m.text asc").list();
        System.out.println(message.size() + " message(s) found:");
        for (Iterator i = messages.iterator(); i.hasNext();) {
            Message loadedMessage = (Message) i.next();
            System.out.println(LoadedMessage.getText());
        }

        tx2.commit();
        session2.close();

        Session session3 = HibernatUtil.getSessionFactory().openSession();
        Transaction tx3 = session3.beginTransaction();

        message = (Message) session3.get(Message.class, messageId);
        message.setText("Greetings Earthling");
        message.setNextMessage(new Message("Take me to your leader (please)"));

        tx3.commit();
        session3.close();

        // shotdown the application
        HibernateUtil.shutdown();
    }
}
