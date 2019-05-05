package com.hcl.payee.service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.payee.entity.Payee;
import com.hcl.payee.repository.PayeeRepository;

@Service
public class PayeeServiceImpl implements PayeeService {
	@Autowired
	private PayeeRepository payeeRepository;

	@Override
	public void addPayee(Payee payee) {
		String str = random(6);
		long otp = Long.parseLong(str);
		System.out.println("otp" + otp);
		payee.setOtp(otp);
		// TODO Auto-generated method stub
		payeeRepository.save(payee);

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

	@Override
	public String validatePayee(long otp, int payeeId) {
		Payee payee = payeeRepository.getOne(payeeId);
		if (payee.getOtp() == otp) {
			payee.setFlag(true);
			payeeRepository.save(payee);
			return "Payee is registered successfully";
		}
		return "Payee is not registered successfully";
	}

}
