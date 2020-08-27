package com.chetan.spring.mailSender.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MockMailSender implements MailSender {
	
	public static Log log = LogFactory.getLog(MockMailSender.class);

	@Override
	public void send(String to, String subject, String body) {
		
		log.info("sending Mock Mail to : " + to);
		log.info("with subject : " + subject);
		log.info("with body : " + body);
	}

}
