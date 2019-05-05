package com.hcl.payee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcl.payee.repository.PayeeRepository;

@Service
public class PayeeServiceImpl implements PayeeService {

	@Autowired
	private PayeeRepository payeeRepository;

	@Override
	public String validateOtp(long id, long otp) {

		payeeRepository.deleteById(id);
		return "Successfully-deleted";

	}

}
