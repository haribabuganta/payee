package com.hcl.payee.service;

import org.springframework.stereotype.Service;

import com.hcl.payee.entity.Payee;

@Service
public interface PayeeService {

	public void addPayee(Payee payee);

	public String validatePayee(long otp, int payeeId);

	public String delete(int payeeId);

}
