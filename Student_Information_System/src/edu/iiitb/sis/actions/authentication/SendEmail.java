package edu.iiitb.sis.actions.authentication;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import edu.iiitb.sis.model.UserDetails;

import java.util.Properties;


public class SendEmail
{
	private Session session;
	private String username,password;
	
	
    public String sendPasswordDetails(UserDetails user) {

        
        try
        {
        	username = "sis.iiitb@gmail.com";
            password = "9177172724";

            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
        	session= Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username,password);
                        }
                    });
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("sis.iiitb@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(user.getEmail()));
            message.setSubject("Password");
            message.setText("Hi " +user.getName()+","+
                    "\n\nWelcome To Student Information System.\n\n"+"Your User Name :"+user.getLoginId()+"\nYour Password is :"+user.getPassword()+
                    "\n\nThanks and Regards,\n"+"SIS Team.");

            Transport.send(message);

            return "success";

        }
        catch (MessagingException e) 
        {
          System.out.println(e.getLocalizedMessage());
        }
		return "failure";
    }
    public String sendUserDetailsToMail(UserDetails user)
    {
    	try 
    	{
    		username = "sis.iiitb@gmail.com";
            password = "9177172724";

            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
    		 System.out.println(user.getName());
             System.out.println(user.getPassword());
        	System.out.println("In Send User Details");
        	session= Session.getDefaultInstance(props,
                    new javax.mail.Authenticator()
        			{
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username,password);
                        }
                    });
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("sis.iiitb@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(user.getEmail()));
           
            message.setSubject("Account Creation");
            message.setText("Hi  " +user.getName()+","+
                    "\nWelcome To Student Information System. Please change your Password in Profile Settings.\n\n"
            		+"User Name : "+user.getLoginId()
                    +"\nPassword  :"+user.getPassword()
                    +"\n\nThanks and Regards,\n"
                    +"SIS Team");      
                   
            Transport.send(message);

            return "success";

        }
        catch (MessagingException e) 
        {
          System.out.println(e.getLocalizedMessage());
        }
		return "failure";
    }
}
