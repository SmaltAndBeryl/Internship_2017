package com.skill.India.common;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
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

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendMailUtility {
	
	@Autowired
	private ReadApplicationConstants readApplicationConstants;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SendMailUtility.class);

	   public int sendInformationOverMail(String email, String file_path, String messageContent) {
	    	LOGGER.debug("Received request to send the mail of file information");
	    	LOGGER.debug("In method - sendInformationOverMail in SendMailUtility");
		
		// Recipient's email ID needs to be mentioned.
	    String to = email;

	    // Sender's email ID needs to be mentioned
	    String from = readApplicationConstants.getEmailSender();

	    final String username = readApplicationConstants.getEmailSender();
	    final String password = readApplicationConstants.getSenderPassword();

	    Properties props = new Properties();
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.host", readApplicationConstants.getHostserver());
	    props.put("mail.smtp.port", readApplicationConstants.getHostport());
	    

	    // Get the Session object.
	    Session session = Session.getInstance(props,
	       new javax.mail.Authenticator() {
	          protected PasswordAuthentication getPasswordAuthentication() {
	             return new PasswordAuthentication(username, password);
	          }
	       });

	       Message message = new MimeMessage(session);
	       try {
	      
	       message.setFrom(new InternetAddress(from));

	       
	       message.setRecipients(Message.RecipientType.TO,
	          InternetAddress.parse(to));

	       
	       message.setSubject("SCGJ Brochure");
	      
	       BodyPart messageBodyPart = new MimeBodyPart();

	       
	       messageBodyPart.setContent(messageContent,"text/html");

	       
	       Multipart multipart = new MimeMultipart();

	       multipart.addBodyPart(messageBodyPart);

	       LOGGER.debug("Adding the file attachment in mail");
	       // Attachment
	       messageBodyPart = new MimeBodyPart();
	       String filename = file_path;
	       String fileExtension=FilenameUtils.getExtension(filename);
	       DataSource source = new FileDataSource(filename);
	       messageBodyPart.setDataHandler(new DataHandler(source));
	       messageBodyPart.setFileName("SCGJBrochure."+fileExtension);
	       multipart.addBodyPart(messageBodyPart);
	       

	       // Sending complete message parts
	       message.setContent(multipart);

	       // Send message
	       Transport.send(message);

	       LOGGER.debug("Mail has been sent successfully");
	       LOGGER.debug("Returning 1 ");
	       return 1;
	       }
	       catch(Exception e){
	    	   LOGGER.error("Exception occured while sending mail from Retrieve information "+e);
	    	   LOGGER.error("Returning 0");
	    	   return 0;
	       }
	       }
}
