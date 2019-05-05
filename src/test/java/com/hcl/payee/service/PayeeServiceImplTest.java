package com.hcl.payee.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.payee.repository.PayeeRepository;

@RunWith(MockitoJUnitRunner.class)
public class PayeeServiceImplTest {
	
	@Mock
	PayeeRepository payeeRepository;
	
	@InjectMocks
	PayeeServiceImpl payeeServiceImpl;
	
	@Test
	public void testValidateOtp() {
		Mockito.when(payeeServiceImpl.validateOtp(id, otp))
	}

}
