package com.linkcode.VehicleRentalSystem;

import java.util.*;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {
	
	final static String sender_mail = "tawade.tanmay7@gmail.com";
	final static String sender_pass = "pjpz sdcb jfct wntv";
	
	public static void sendBookingConfirmation(Vehicle vehicle, Customer customer) {
		Scanner sc = new Scanner(System.in);
		
		String subject = "Vehicle Rental Confirmation";
		
		String msg = "Hello" + customer.name + ","
				+ "\nVehicle Id : " + vehicle.getVehicleId()
				+ "\nRental Rate : " + vehicle.getRentalRate()
				+ "\nTotal Bill : " + (vehicle.getRentalRate() * vehicle.getRentedDays());
		
		System.out.println("Enter Your Mail ID:");
		String receiver_mail = sc.next();

		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(sender_mail, sender_pass);
			}
		});

		session.setDebug(true);

		 try {
		
			 Message message =new MimeMessage(session); 
			
			 message.setFrom(new InternetAddress(sender_mail));
			 message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver_mail));
			 message.setSubject(subject);
			 message.setText(msg);
			 Transport.send(message);
		
		 } catch (MessagingException e) {
		 e.printStackTrace();
		
		 }
		
		 System.out.println("Email sent to "+ receiver_mail);
	}
	
}
