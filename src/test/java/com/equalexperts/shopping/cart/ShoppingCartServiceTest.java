package com.equalexperts.shopping.cart;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.equalexperts.shopping.cart.entity.Product;
import com.equalexperts.shopping.cart.service.ShoppingCartService;
import com.equalexperts.shopping.cart.util.ShoppingCartUtil;


public class ShoppingCartServiceTest {
	
	private ShoppingCartService target;

	@Before
	public void setUp() throws Exception {
		target = new ShoppingCartService();
	}

	@Test
	public void testAddProductWhenProductIsNull() {
		double actual = target.addProduct(null, 0);
		double expected = 0;
		assertThat(actual, equalTo(expected));
	}
	
	@Test
	public void testAddProductWhenUnitIsZero() {
		double actual = target.addProduct(null, 1);
		double expected = 0;
		assertThat(actual, equalTo(expected));
	}
	
	@Test
	public void testAddProductWithOneProductTypeOneTimeAddition(){
		Product product = new Product("DOVE_SOPE", "Dove Sope", 39.99, "Cosmetics");
		target.clearShoppingCart();
		double actual = target.addProduct(product, 5);
		double expected = 199.95;
		assertThat(actual, equalTo(expected));
	}

	@Test
	public void testAddProductWithOneProductTypeMultipleTimesAddition(){
		Product product = new Product("DOVE_SOPE", "Dove Sope", 39.99, "Cosmetics");
		target.clearShoppingCart();
		target.addProduct(product, 5);
		double actual = target.addProduct(product, 3);
		double expected = 319.92;
		assertThat(actual, equalTo(expected));
	}
	
	@Test
	public void testCalculatTaxRateOfShoppingCartWithMultipleItems(){
		target.clearShoppingCart();
		Product product1 = new Product("DOVE_SOPE", "Dove Sope", 39.99, "Cosmetics");
		target.addProduct(product1, 2);
		
		Product product2 = new Product("AXE_DUO", "Axe Duo", 99.99, "Cosmetics");
		
		double totalAmount = target.addProduct(product2, 2);
		double taxAmount = ShoppingCartUtil.calculateTaxOnTotalAmount(totalAmount);
		double paybleAmount = ShoppingCartUtil.calculatePaybleAmount(totalAmount);
		double expected = 314.96;
		assertThat(paybleAmount, equalTo(expected));
	}
	
}
