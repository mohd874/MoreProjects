/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sketchapp;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Saeed
 */
public class EmailTest {

    public static void main(String[] args) throws AddressException, MessagingException {

     boolean debug = true;

     String[] recipients = {"s200200874@hct.ac.ae"};
     //Set the host smtp address
     Properties props = new Properties();
     props.put("mail.smtp.host", "localhost");
//     props.put("mail.transport.protocol", "smtp");
     
    // create some properties and get the default Session
    Session session = Session.getDefaultInstance(props, null);
    session.setDebug(debug);

    // create a message
    Message msg = new MimeMessage(session);

    // set the from and to address
    InternetAddress addressFrom = new InternetAddress("test@hct.ac.ae");
    msg.setFrom(addressFrom);

    InternetAddress[] addressTo = new InternetAddress[recipients.length]; 
    for (int i = 0; i < recipients.length; i++)
    {
        addressTo[i] = new InternetAddress(recipients[i]);
    }
    msg.setRecipients(Message.RecipientType.TO, addressTo);
   

    // Optional : You can also set your custom headers in the Email if you Want
    msg.addHeader("MyHeaderName", "myHeaderValue");

    // Setting the Subject and Content Type
    msg.setSubject("Testing Java Mail");
    msg.setContent("This is a test. ingnore it", "text/plain");
    Transport.send(msg);
    }

}
