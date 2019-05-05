package com.hcl.payee.service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.payee.repository.PayeeRepository;
@Service
public class PayeeServiceImpl implements PayeeService{
	@Autowired
	PayeeRepository payeeRepository;
	

@Override
	public String delete(int payeeId) {
		String otp =random(6);
		Long otp1=Long.parseLong(otp);
		
	
		
		
		
		return "can you please enter OTP don't share this OTP to any one";
	}

	private  static String random(int size) {

		StringBuilder generatedToken = new StringBuilder();
		try {
		SecureRandom number = SecureRandom.getInstance("SHA1PRNG");
		// Generate 20 integers 0..20
		for (int i = 0; i < size; i++) {
		generatedToken.append(number.nextInt(9));
		}
		} catch (NoSuchAlgorithmException e) {
		e.printStackTrace();
		}

		return generatedToken.toString();
		}

}
