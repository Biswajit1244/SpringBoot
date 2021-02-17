package com.biss.mail;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.AbstractResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
@Component
public class MailService {
	@Autowired
	private JavaMailSender sender;
	
	public boolean send(String to,String subject,
						String text,AbstractResource file) {
		boolean issent=false;
		try {
		//create message
		MimeMessage message=sender.createMimeMessage();
		//Create MimeMessageHelper obj
		MimeMessageHelper helper=new MimeMessageHelper(message, file!=null);
		//set values
		helper.setTo(to);
		helper.setSubject(subject);
		if(text!=null) {
			helper.setText(text);
		}
		if(file!=null) {
			helper.addAttachment(file.getFilename(),file);
		}
		sender.send(message);
		issent=true;	
		} catch (Exception e) {
			issent=false;
			e.printStackTrace();
		}
		
		return issent;
	}
	/***
	* over loaded methods
	*
	*/
	public boolean send(
			String to,
			String subject){
	return send(to,subject,null,null);
	}
	
	public boolean send(
			String to,
			String subject,
			String text) {
	return send(to,subject,text,null);
	}
}
