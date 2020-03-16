package com.chainsys.busticketapp.util.mail;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.chainsys.busticketapp.exception.DBException;

public class Mail {
	String from = "vignesh280519@gmail.com";
	String password = "6369541046";

	public static void send(String from, String password, String to, String sub, String Msg, int id)
			throws DBException {
		try {
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(from, password);
				}
			});
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(sub);

			BodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1.setText("Welcome, \nFrom Busticketbooking");
			BodyPart messageBodyPart2 = new MimeBodyPart();
			messageBodyPart2.setText("\nPassenger id: \t\t " + id);
			BodyPart messageBodyPart3 = new MimeBodyPart();
			messageBodyPart3.setText("\n\t\t" + sub);

			BodyPart messageBodyPart4 = new MimeBodyPart();
			messageBodyPart4.setText("\n\t\tThank you");
			BodyPart messageBodyPart5 = new MimeBodyPart();
			messageBodyPart5.setText("\n\t Team busticketbooking...");

			/*
			 * String filename = "SendAttachment.java"; FileDataSource source = new
			 * FileDataSource("./src/test/java/com/chainsys/busticketapp/SendMailSSL.java");
			 * messageBodyPart2.setDataHandler(new DataHandler(source));
			 * messageBodyPart2.setFileName(filename);
			 */
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart1);
			multipart.addBodyPart(messageBodyPart2);
			multipart.addBodyPart(messageBodyPart3);
			multipart.addBodyPart(messageBodyPart4);
			multipart.addBodyPart(messageBodyPart5);

			message.setContent(multipart);
			Transport.send(message);
			System.out.println("message sent successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}