/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Utility;


import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author rtspi
 */
public class SendEmailUtility {

    /**
     * @param args the command line arguments
     */
    public static void sendMail(String receiver) throws Exception {
        // TODO code application logic here
        System.out.println("Preparing to send email!");
        
        Properties properties = new Properties();
        
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        
        String myAccountEmail = "rtspirit.test@gmail.com";
        String password = "Netflix@2020";
        
        Session session = Session.getInstance(properties, new Authenticator()   {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password); //To change body of generated methods, choose Tools | Templates.
            }
            
            
        });
        
        
        Message message = prepareMessage(session, myAccountEmail, receiver);
        
        Transport.send(message);
        System.out.println("Message Sent Successfully");
    }
    
    
    private static Message prepareMessage(Session session, String myAccountEmail, String receiver){
        
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
            message.setSubject("Welcome to DMS World.");
            message.setText("Thank you for registering on DMS World! Your account is now activated.");
            return message;
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(SendEmailUtility.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    
    
}
