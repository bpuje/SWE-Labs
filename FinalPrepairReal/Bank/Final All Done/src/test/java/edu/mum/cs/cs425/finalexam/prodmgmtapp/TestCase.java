package edu.mum.cs.cs425.finalexam.prodmgmtapp;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.mum.cs.cs425.finalexam.controller.AccountController;
import edu.mum.cs.cs425.finalexam.service.impl.AccountService;

public class TestCase {

	@Test
	public void test() {
		AccountService service = new AccountService();
		
		double netLiq = service.computeNetLiquidity();
		
		assertEquals(netLiq, 484596.21);
	}

}
