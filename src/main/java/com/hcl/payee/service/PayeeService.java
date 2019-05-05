package com.hcl.payee.service;

import org.springframework.stereotype.Service;

@Service
public interface PayeeService {
	public String validateOtp(long id, long otp);

}
