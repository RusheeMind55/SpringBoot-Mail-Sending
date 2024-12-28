package mypackage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;
import mypackage.model.EmailModel;

@Service
public class EmailService {

	@Autowired
	JavaMailSender mailSender;
	
	@Value("${spring.mail.username}")
	private String sender;
	
	public void SendEmail(EmailModel model) {
		 SimpleMailMessage message=new SimpleMailMessage();
		 message.setFrom(sender);
		 message.setTo(model.getToAddress());
		 message.setSubject(model.getSubject());
		 message.setText(model.getMessage());
		 mailSender.send(message);
		
		
	}
}
