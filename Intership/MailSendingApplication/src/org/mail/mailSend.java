package org.mail;


import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
public class mailSend {

	public static void main(String[] args) {
		
		System.out.println("Hello API ");
		
		String fromAddress="prathameshwate999@gmail.com";
		String toAddress="pathamwate77@gmail.com";
		String ccAddress="prathameshwate77@gmail.com";
		String messageBody="Hii am Pratham";
		
		try {
			sendMail( fromAddress , toAddress,  messageBody , ccAddress);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		

	}
	public static void sendMail(String fromAddress ,String toAddress,String  messageBody ,String  ccAddress) throws MessagingException {
		Properties properties =System.getProperties();
		
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		
		//Session session;
		Session session = Session.getInstance(properties, new Authenticator() {
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication("prathameshwate999@gmail.com" ,Constant.PASSWORD);
			}
			
		});
		
		MimeMessage message=new MimeMessage(session);
		message.setFrom(fromAddress);
		message.addRecipients(Message.RecipientType.TO, toAddress);
		message.addRecipients(Message.RecipientType.CC, ccAddress);
		message.setSubject("Hi I am Pratham");
	
		message.setText(messageBody);
		
		Transport.send(message);
		System.out.println("Suuceefull");
		
	}
}
