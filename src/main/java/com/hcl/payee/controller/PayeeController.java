package com.hcl.payee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.payee.entity.Payee;
import com.hcl.payee.pojo.DeletePayeeRequest;
import com.hcl.payee.service.PayeeService;
import com.hcl.payee.service.PayeeServiceImpl;

@RestController
@RequestMapping("/paypee")
public class PayeeController {

	/*
	 * @Autowired private PayeeServiceImpl payeeServiceImpl;
	 */
	@Autowired
	PayeeService payeeService;

	@DeleteMapping("/validate")
	public String validate(@RequestBody DeletePayeeRequest DeletePayeeRequest) {

		return payeeServiceImpl.validateOtp(DeletePayeeRequest.getId(), DeletePayeeRequest.getOtp());

	}

	@GetMapping("/payeedelete/{id}")
	public String payeeDelete(@PathVariable("id") long id) {

		return payeeService.delete(id);

	}

	@PostMapping("/addpayee")
	public String addPayee(@RequestBody Payee payee) {

		payeeServiceImpl.addPayee(payee);

		return "successfully OTP generated";

	}

	@PutMapping("/validateotp/{payeeId}")
	public String validatePayeeOtp(@PathVariable("payeeId") long payeeId, @RequestParam("otp") long otp) {
		String str = payeeServiceImpl.validatePayee(otp, payeeId);

		return str;
	}

}
