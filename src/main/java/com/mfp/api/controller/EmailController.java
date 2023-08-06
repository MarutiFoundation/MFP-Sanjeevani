package com.mfp.api.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mfp.api.model.EmailDetails;
import com.mfp.api.service.EmailPasswordService;


@RestController
@RequestMapping(value = "/email")
public class EmailController {

	@Autowired
	private EmailPasswordService emailPasswordService;


	@PostMapping("/sendMail")
	public boolean sendMail(@RequestBody EmailDetails details) {
		return false;
	}
	
	@GetMapping(value = "/send-otp/{userId}")
	public ResponseEntity<String> sendOtp(@PathVariable String userId){
		return null;
	}
	
	
	

}
