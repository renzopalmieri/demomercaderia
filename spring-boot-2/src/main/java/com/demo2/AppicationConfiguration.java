package com.demo2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


public class AppicationConfiguration {

	public MyMessage myMessage( @Value("${my.messageValue}") String messageValue){
		
		MyMessage myMessage = new MyMessage();
		myMessage.setMessageValue(messageValue);
		return myMessage;
	}
	
	

}
