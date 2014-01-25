/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.com.mail;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author The Dragon
 */
public class MailUtilLocal {

    public static void sendMail(String to, String from, String subject, String body, boolean bodyIsHTML) throws MessagingException {
        // 1 - get a mail session
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smpt");
        props.put("mail.smtp.host", "localhost");
        props.put("mail.smtp.port",25);
        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);

        // 2 - creata a message 

        Message message = new MimeMessage(session);
        message.setSubject(subject);
        if (bodyIsHTML) {
            message.setContent(body, "text/html");
        } else {
            message.setText(body);
        }

        // 3 - address the message
        Address fromAddress = new InternetAddress(from);
        Address toAddress = new InternetAddress(to);
        message.setFrom(fromAddress);
        message.setRecipient(Message.RecipientType.TO, toAddress);

        // 4 - send the message

        Transport.send(message);
    }
}
