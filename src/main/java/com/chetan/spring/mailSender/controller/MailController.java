package com.chetan.spring.mailSender.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chetan.spring.mailSender.mail.MailSender;

@RestController
public class MailController {
	
	@Value("${app.name}")
	private String appName;
	
	private MailSender mailSender;
	
	@Autowired
	public MailController(MailSender smtp) {
		this.mailSender = smtp;
	}
	
	@RequestMapping("/mail")
	public String MailSend() throws MessagingException {
		mailSender.send("tejawee1.taktewale@gmail.com", "Test Love Mail", "Hello Tejaswee ! How are you ? !! Doing will ? Love you So much");
		return "Mail sent successfully......."+" On :"+ appName;
	}

}
