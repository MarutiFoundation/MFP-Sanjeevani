package com.mfp.api.serviceimpl;

import java.sql.Timestamp; 
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mfp.api.dao.UserDao;
import com.mfp.api.entity.Otp;
import com.mfp.api.entity.User;
import com.mfp.api.model.EmailDetails;
import com.mfp.api.model.ResetPasswordDetail;
import com.mfp.api.service.EmailPasswordService;
import com.mfp.api.service.UserService;
import com.mfp.api.utility.OTPGenerator;

@Service
public class EmailPasswordServiceImpl implements EmailPasswordService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	public BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserService userService;

	public boolean sendMail(EmailDetails details) {
		return false;
	}

	@Override
	public String resetPasswordByQA(ResetPasswordDetail detail) { // equals (Rohit - rohit) 
			User user = this.userDao.getUserByUserName(detail.getUserId()); // used to update new user

			
				if(user.getQuestion().equalsIgnoreCase(detail.getQuestion())) {
					if(user.getAnswer().equalsIgnoreCase(detail.getAnswer())) {
						if(detail.getNewPassword().equals(detail.getConfirmPassword())) {
							String encodedPassword = this.passwordEncoder.encode(detail.getNewPassword());
							user.setPassword(encodedPassword);
							User updateUser = this.userDao.updateUser(user);
							if(updateUser != null) {
								return "OK";
							}else {
								return "USER NOT UPDATED...."; 
							}
							
						}else {
							return "NEW PASSWORD AND CONFIRM PASSWORD NOT MATCHED...";
						}
					}else {
						return "WROENG ANSWER...";
					}
				}else {
					return "WROENG QUESTION...";
				}
			
	}

	@Override
	public String sendOtp(String UserId) {
		int otp = OTPGenerator.generateOtp();

		LocalDateTime now = LocalDateTime.now();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyMMddHHmmss");
		String customTimestamp = now.format(formatter);
		LocalDateTime dateTime = LocalDateTime.parse(customTimestamp, formatter);

		Timestamp sqlTimestamp = Timestamp.valueOf(dateTime);
		
		Otp otpClass = new Otp();
		otpClass.setUserId(UserId);
		otpClass.setTimestamp(sqlTimestamp);
		otpClass.setOtp(otp);
		
		boolean status = this.userDao.saveOtp(otpClass);
		if(status) {
			return "OTP Generated Successfully...";
		}else{
			return "ERROR...";
		}

	}

	@Override
	public String resetPasswordByOtp(ResetPasswordDetail detail) { // userId, Password , confirm password , otp
		
		Otp otpByUser = this.userDao.getOtpByUser(detail.getUserId());
		if(detail.getOtp() == otpByUser.getOtp()) {
			if(detail.getNewPassword().equals(detail.getConfirmPassword())) {
				
				User userData = this.userDao.getUserByUserName(detail.getUserId());
				userData.setPassword(detail.getNewPassword());
				
				String encodedPassword = this.passwordEncoder.encode(userData.getPassword());
				userData.setPassword(encodedPassword);
				
				User updateUser = this.userDao.updateUser(userData);
				if(updateUser != null) {
					return "UPDATED";
				}else {
					return "NOT UPDATED";
				}
			}else {
				return "PasswordNotMatched";
			}
		}else {
			return "OTPERROR";
		}
	}

}
