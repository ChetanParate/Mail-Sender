package com.chetan.spring.mailSender.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

import com.chetan.spring.mailSender.mail.MailSender;
import com.chetan.spring.mailSender.mail.MockMailSender;
import com.chetan.spring.mailSender.mail.SmtpMailSender;

@Configuration
//you can also use @Component annotation for this but this is not good to use
public class MailConfig {
	
	@Bean
	//@Profile("Dev")
	//@ConditionalOnProperty("spring.mail.host")
	public MailSender mockMailSender() {
		
		return new MockMailSender();
	}
	
	@Bean("smtp")
	//@Profile("QA")
	//@ConditionalOnProperty(name="spring.mail.host", havingValue="yahoo", matchIfMissing=true)
	public MailSender smtpMailSender(JavaMailSender javaMailSender) {
		
		return new SmtpMailSender(javaMailSender);
	}

}
