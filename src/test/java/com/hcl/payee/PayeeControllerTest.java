package com.hcl.payee;

import javax.validation.constraints.AssertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.payee.controller.PayeeController;
import com.hcl.payee.entity.Payee;
import com.hcl.payee.repository.PayeeRepository;
import com.hcl.payee.service.PayeeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class PayeeControllerTest {
	private static final String SUCCESSFULLY_ADDED_PAYEE = "successfully added payee";
	@InjectMocks
	private PayeeController payeeController;

	@Mock
	private PayeeRepository PayeeRepository;

	@InjectMocks
	private PayeeServiceImpl payeeServiceImpl;
	
	@Test
	public void addPayeeTest() {
		Payee payee = new Payee();
		payee.setAccountNumber(6664554);
		payee.setAccountType("Savings");
		payee.setBranch("EC");
		String str=payeeController.addPayee(payee);
		
		Mockito.when(payeeController.addPayee(payee)).thenReturn(
				SUCCESSFULLY_ADDED_PAYEE);
		//Mockito.verify(PayeeRepository.save(payee));
	}

}
