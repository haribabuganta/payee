package com.hcl.payee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.payee.pojo.DeletePayeeRequest;
import com.hcl.payee.service.PayeeServiceImpl;

@RestController
@RequestMapping("/paypee")
public class PayeeController {

	@Autowired
	private PayeeServiceImpl payeeServiceImpl;

	@DeleteMapping("/validate")
	public String validate(@RequestBody DeletePayeeRequest DeletePayeeRequest) {

		return payeeServiceImpl.validateOtp(DeletePayeeRequest.getId(),DeletePayeeRequest.getOtp());

	}

}
