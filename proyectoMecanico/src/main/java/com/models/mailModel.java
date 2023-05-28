package com.models;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
public class mailModel {
	public static void enviarCorreo(String sendTo,String subject, String text) { 
		Properties props = new Properties();
		  props.put("mail.smtp.host", "smtp.gmail.com");
		  props.put("mail.smtp.port", "587");
		  props.put("mail.smtp.auth", "true");
		  props.put("mail.smtp.starttls.enable", "true");
		  props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		  
		  Session session = Session.getInstance(props, new Authenticator() {
		    protected PasswordAuthentication getPasswordAuthentication() {
		      return new PasswordAuthentication("proyectodam2023@gmail.com", "oybavotnoiriouag");//oybavotnoiriouag Proyectodam2023!*
		    }
		  });

		  try {
			  System.out.println(text);
		    Message message = new MimeMessage(session);
		    message.setFrom(new InternetAddress("proyectodam2023@gmail.com"));
		    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(sendTo));
		    message.setSubject(subject);
		    message.setText(text);
		    Transport.send(message);
		    System.out.println("Correo enviado satisfactoriamente.");
		  } catch (MessagingException e) {
			  System.out.println("Me meto en esta exception");
		    throw new RuntimeException(e);
		  }
		}
}
