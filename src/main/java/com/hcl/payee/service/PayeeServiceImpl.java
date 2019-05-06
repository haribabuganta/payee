package com.hcl.payee.service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.payee.entity.Payee;
import com.hcl.payee.repository.PayeeRepository;

@Service
public class PayeeServiceImpl implements PayeeService {

	@Autowired
	private PayeeRepository payeeRepository;

	Long otp1;

	@Override
	public String validateOtp(long id, long otp) {

		payeeRepository.deleteById(id);
		return "Successfully-deleted";

	}

	@Override
	public String delete(long payeeId) {
		Payee payee = payeeRepository.findByPayeeId(payeeId);
		if (payee != null) {
			String otp = random(6);
			Long otp1 = Long.parseLong(otp);

			try { 
				PayeeServiceImpl payeeServiceImpl = new PayeeServiceImpl();
			 payeeServiceImpl.sendEmail();
			
			 return "OTP genarated sucessfully";
			 } 
			catch(Exception e) {
			 
			  return "OTP otpgenerated";
		}
		}
		else {
			return "can you please send proper payeeId";
			}

		/*return "successfully send otp to your mailid";*/
	}

	

	public String random(int size) {

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

	/*
	 * private void sendMail() throws Exception { SimpleMailMessage message = new
	 * SimpleMailMessage(); message.setTo("haricg8@gmail.com");
	 * message.setSubject("This is subject"); message.setText("otp1"); try { //
	 * System.out.println("emailSender ======>> " + emailSender); //
	 * emailSender.send(message); System.out.println("Email sent..."); } catch
	 * (Exception e) { e.printStackTrace(); }
	 * 
	 * }
	 */

	@Override
	public void addPayee(Payee payee) {
		String str = random(6);
		Long i = new Long(str);
		System.out.println("otp" + i);
		payee.setOtp(i);
		String str1 = random(6);
		long otp = Long.parseLong(str1);
		System.out.println("otp" + otp);
		payee.setOtp(otp);
		payee.setFlag(false);

		payeeRepository.save(payee);

	}

	@Override
	public String validatePayee(long otp, long payeeId) {
		Payee payee = payeeRepository.getOne(payeeId);
		if (payee.getOtp() == otp) {
			payee.setFlag(true);
			payeeRepository.save(payee);

			return "Payee is registered successfully";
		}
		return "Payee is registered successfully";
	}

	public static void sendEmail() {
		System.out.println("inside sendEmail1");

		final String username = "krkesava197@gmail.com";
		final String password = "49064906";

		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("krkesava197@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("rohitkumar999rns@gmail.com"));
			message.setSubject("Testing Subject");
			message.setText("for testing");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

}
