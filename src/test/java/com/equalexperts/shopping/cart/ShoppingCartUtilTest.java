package com.equalexperts.shopping.cart;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.equalexperts.shopping.cart.util.ShoppingCartUtil;

public class ShoppingCartUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testRoundUpAmount(){
		assertThat(0.57,equalTo(ShoppingCartUtil.roundUpAmount(0.567)));
		assertThat(0.56,equalTo(ShoppingCartUtil.roundUpAmount(0.564)));
		
		assertThat(0.56,equalTo(ShoppingCartUtil.roundUpAmount(0.565)));
	}
	
	@Test
	public void testCalculateTaxOnTotalAmount(){
		double totalAmount = 279.96;
		double taxAmount = ShoppingCartUtil.calculateTaxOnTotalAmount(totalAmount);
		double expacted = 34.99;
		assertThat(taxAmount, equalTo(expacted));
		
	}
	
	@Test
	public void testcalculatePaybleAmount(){
		double totalAmount = 279.96;
		double paybleAmount = ShoppingCartUtil.calculatePaybleAmount(totalAmount);
		double expacted = 314.95;
		assertThat(paybleAmount, equalTo(expacted));
	}

}
