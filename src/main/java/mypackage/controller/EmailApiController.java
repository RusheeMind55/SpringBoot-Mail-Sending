package mypackage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mypackage.model.EmailModel;
import mypackage.service.EmailService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class EmailApiController {

	@Autowired
	EmailService service;
	
	@GetMapping("api/test")
	public String TestApi() {
		return "This is test api";
	}
	
	
	@PostMapping("api/sendmail")
	public String Send(EmailModel email) {
		 
		service.SendEmail(email);
		return "Email Sent Successfully";
	}
	
}
