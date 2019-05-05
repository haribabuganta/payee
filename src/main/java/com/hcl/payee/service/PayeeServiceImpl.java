package com.hcl.payee.service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.hcl.payee.entity.Payee;
import com.hcl.payee.repository.PayeeRepository;


	

@Service
public class PayeeServiceImpl implements PayeeService {
	
    @Autowired
	private PayeeRepository payeeRepository;
    @Autowired
	public JavaMailSender emailSender;
    
    @Override
	public String delete(long payeeId) {
    	Payee payee = payeeRepository.findById(payeeId).get();
		if(payee.getId()==payeeId) {
			String otp =random(6);
			Long otp1=Long.parseLong(otp);
			try {
			
			PayeeServiceImpl payeeServiceImpl = new PayeeServiceImpl();
			payeeServiceImpl.sendMail();
			
			return "OTP genarated and sent to your email id sucessfully";
			}
			catch(Exception e) {
				e.printStackTrace();
				return "can you please send proper payeeid";
			}
			
		}else
		
			return "can you please send proper payeeId";
	
		
	}


	@Override
	public void addPayee(Payee payee) {
		String str=random(6);
		Long i =new Long(str);
		System.out.println("otp"+i);
		payee.setOtp(i);
		payeeRepository.save(payee);
		
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
	
	private void sendMail() throws Exception{
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("haricg8@gmail.com");
		message.setSubject("This is subject");
		message.setText("tdiudih");
		emailSender.send(message);
	}

}
