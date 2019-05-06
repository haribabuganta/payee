
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

@RestController
@RequestMapping("/payee")
public class PayeeController {

	@Autowired
	PayeeService payeeService;

	@PostMapping("/addPayee")
	public String addPayee(@RequestBody Payee payee) {
		payeeService.addPayee(payee);
		return "Successfully OTP generated";

	}

	@PutMapping("/addPayeeValidateOTP/{payeeId}")
	public String validatePayeeOtp(@PathVariable("payeeId") long payeeId, @RequestParam("otp") long otp) {
		return payeeService.validatePayee(otp, payeeId);
	}

	@DeleteMapping("/deletePayeeValidateOTP")
	public String validate(@RequestBody DeletePayeeRequest DeletePayeeRequest) {
		return payeeService.validateOtp(DeletePayeeRequest.getId(), DeletePayeeRequest.getOtp());
	}

	@GetMapping("/deletePayee/{id}")
	public String payeeDelete(@PathVariable("id") long id) {
		return payeeService.delete(id);
	}

}
