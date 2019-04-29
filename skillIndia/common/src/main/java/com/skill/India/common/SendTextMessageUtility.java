package com.skill.India.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SendTextMessageUtility {
	
	@Autowired
	private ReadApplicationConstants readApplicationConstants;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SendTextMessageUtility.class);

	public int sendTextMessage(String receiverContact, String messageBody) {
		
		LOGGER.debug("Request received to send an SMS in sendTextMessage-SendTextMessageUtility class");
		
		String authkey = readApplicationConstants.getSmskey();
		String mobiles = receiverContact;
		String senderId = readApplicationConstants.getSenderId();
		String message = messageBody;
		
		//define route=4 for transactional message & route=1 for Promotional
		String route="4";
		
		//Prepare Url
		URLConnection myURLConnection=null;
		URL myURL=null;
		BufferedReader reader=null;
		
		//Send SMS API
		String mainUrl=readApplicationConstants.getSmsUrl();
		
		String encoded_message=URLEncoder.encode(message);
		
		 //Prepare parameter string
	      StringBuilder sbPostData= new StringBuilder(mainUrl);
	      sbPostData.append("authkey="+authkey);
	      sbPostData.append("&mobiles="+mobiles);
	      sbPostData.append("&message="+encoded_message);
	      sbPostData.append("&route="+route);
	      sbPostData.append("&sender="+senderId);
	      
	      mainUrl = sbPostData.toString();
	      
	      try
	        {
	    	  LOGGER.debug("Preparing connection to send the message");
	            //prepare connection
	            myURL = new URL(mainUrl);
	            myURLConnection = myURL.openConnection();
	            myURLConnection.connect();
	            reader= new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
	            //reading response
	            String response;
	            while ((response = reader.readLine()) != null)
	            LOGGER.debug("Response received is "+response);
	            
	            //finally close connection
	            LOGGER.debug("Closing the message connection");
	            reader.close();
	            LOGGER.debug("Returning 1 to service after sending the message");
	            return 1;
	        }
	        catch(Exception e){
	        	LOGGER.error("Exception occurred while sending the message "+e);
	        	LOGGER.error("Returning 0 to service ");
	        	return 0;
	        }
	      
	      
		
	}
}
