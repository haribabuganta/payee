package com.hcl.payee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.payee.entity.Payee;
import com.hcl.payee.service.PayeeServiceImpl;

@RestController
@RequestMapping("/paypee")
public class PayeeController {
	@Autowired
	private PayeeServiceImpl payeeServiceImpl;

	@GetMapping("/welcome")
	public String test() {

		return "welocme";
	}

	@PostMapping("/addpayee")
	public String addPayee(@RequestBody Payee payee) {

		payeeServiceImpl.addPayee(payee);

		return "successfully added payee";

	}

	@PutMapping("/validateotp/{payeeId}")
	public String validatePayeeOtp(@PathVariable("payeeId") int payeeId,
			@RequestParam("otp") int otp) {
		String str = payeeServiceImpl.validatePayee(otp, payeeId);

		return str;
	}

}
