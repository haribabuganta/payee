package com.hcl.payee.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.payee.service.PayeeService;

@RestController
@RequestMapping("/paypee")
public class PayeeController {
	
	@Autowired
	PayeeService payeeService;
	
	@GetMapping("/welcome")
	public String test(){
		
		return "welocme";
	}
	
	@GetMapping("/payeedelete/{payeeid}")
	public String payeeDelete(@PathParam(value = "payeeId") int payeeId){
		
		return payeeService.delete(payeeId);
		
	}

}
