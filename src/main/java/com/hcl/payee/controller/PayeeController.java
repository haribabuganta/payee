package com.hcl.payee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paypee")
public class PayeeController {
	
	
	@GetMapping("/welcome")
	public String test(){
		
		return "welocme";
	}

}
