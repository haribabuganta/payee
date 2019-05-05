package com.hcl.payee.service;

import org.springframework.stereotype.Service;

import com.hcl.payee.entity.Payee;

@Service
public interface PayeeService {

	public void addPayee(Payee payee);

	public String validatePayee(long otp, long payeeId);

	public String delete(long payeeId);

}
