package com.mfp.api.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.mfp.api.dao.UserDao;
import com.mfp.api.model.EmailDetails;
import com.mfp.api.model.ResetPasswordDetail;
import com.mfp.api.service.EmailPasswordService;
import com.mfp.api.service.UserService;

@Service
public class EmailPasswordServiceImpl implements EmailPasswordService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserService userService;

	public boolean sendMail(EmailDetails details) {
		return false;
	}

	@Override
	public String resetPasswordByQA(ResetPasswordDetail detail) {
		return null;
	}

	@Override
	public String sendOtp(String UserId) {
		return null;
	}

	@Override
	public String resetPasswordByOtp(ResetPasswordDetail detail) {
		return null;
	}

}
