package com.adt.hrms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	public String sendEmail() {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom("spyavenger55@gmail.com");
		msg.setTo("spyavenger55@gmail.com");
		msg.setSubject("Test Subject");
		msg.setText("Test Body");

		javaMailSender.send(msg);

		return "Mail Sent Successfully";
	}

}
