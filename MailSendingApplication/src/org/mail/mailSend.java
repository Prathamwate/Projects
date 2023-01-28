package org.mail;


import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
public class mailSend {

	public static void main(String[] args) {
		
		
		System.out.println("Hello API ");
		
		String fromAddress="prathameshwate999@gmail.com";
		String toAddress="prathamwate77@gmail.com";
		String ccAddress="prathameshwate999@gmail.com";
		String messageBody="Hii am Pratham Otp";
	
		
		try {
		//	sendMail( fromAddress , toAddress,  messageBody , ccAddress);
			sendMailWithAttachment( fromAddress , toAddress,  ccAddress, messageBody );
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}


	public static void sendMail(String fromAddress ,String toAddress,String  messageBody ,String  ccAddress) throws MessagingException {
		Connection con=new Connection();
		Session session=con.getConnection();
		MimeMessage message=new MimeMessage(session);
		message.setFrom(fromAddress);
		message.addRecipients(Message.RecipientType.TO, toAddress);
		message.addRecipients(Message.RecipientType.CC, ccAddress);
		message.setSubject("Hi I am Pratham");
	
		message.setText(messageBody);
		
		Transport.send(message);
		System.out.println("Suuceefull");
	}
		
		  public static void sendMailWithAttachment(String fromAddress , String toAddress , String ccAddress , String messageBody) throws ArithmeticException, MessagingException, IOException {
			    Connection con=new Connection();
			    Session session=con.getConnection();
		        // B. Compose the mail
		        MimeMessage message = new MimeMessage(session);
		        message.setFrom(fromAddress);
		        message.addRecipients(Message.RecipientType.TO, toAddress);
		        message.addRecipients(Message.RecipientType.CC, ccAddress);
		     //   message.setSubject(" Pratham ");
		        message.setText(messageBody);
		        MimeBodyPart bodyAttachment =new MimeBodyPart();
		        //for body test
		        MimeBodyPart bodyText = new MimeBodyPart();
		        bodyText.setText(messageBody);
		        //for file
		        MimeMultipart mimeMultipart=new MimeMultipart();
		        //Setting body with Attachment
		        String path ="G:\\TicTacToe\\Pratham.png";
		        // set the file
		        File file=new File(path);
		        bodyAttachment.attachFile(file);
		        mimeMultipart.addBodyPart(bodyText);
		        mimeMultipart.addBodyPart(bodyAttachment);
		        message.setContent(mimeMultipart);
		        // send the mail
		        Transport.send(message);
		        System.out.println("Email send Successfully...");
		    }
		
	}

