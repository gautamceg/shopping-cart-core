package com.equalexperts.shopping.cart;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.equalexperts.shopping.cart.entity.Product;
import com.equalexperts.shopping.cart.entity.ShoppingCart;
import com.equalexperts.shopping.cart.service.ShoppingCartService;
import com.equalexperts.shopping.cart.util.ShoppingCartUtil;


public class ShoppingCartServiceTest {
	
	private ShoppingCartService target;

	@Before
	public void setUp() throws Exception {
		target = new ShoppingCartService();
	}
	/*
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
		Product product = new Product("Dove Sope", 39.99);
		target.clearShoppingCart();
		double actual = target.addProduct(product, 5);
		double expected = 199.95;
		assertThat(actual, equalTo(expected));
	}

	@Test
	public void testAddProductWithOneProductTypeMultipleTimesAddition(){
		Product product = new Product( "Dove Sope", 39.99);
		target.clearShoppingCart();
		target.addProduct(product, 5);
		double actual = target.addProduct(product, 3);
		double expected = 319.92;
		assertThat(actual, equalTo(expected));
	}
	
	@Test
	public void testCalculatTaxRateOfShoppingCartWithMultipleItems(){
		target.clearShoppingCart();
		Product product1 = new Product("Dove Sope", 39.99);
		target.addProduct(product1, 2);
		
		Product product2 = new Product("Axe Duo", 99.99);
		
		double totalAmount = target.addProduct(product2, 2);
		double taxAmount = ShoppingCartUtil.calculateTaxOnTotalAmount(totalAmount);
		double paybleAmount = ShoppingCartUtil.calculatePaybleAmount(totalAmount);
		double expected = 314.96;
		assertThat(paybleAmount, equalTo(expected));
	}
	
	*/
	
	
	@Test
	public void verifyProductQuantityInShoppingCart() {
		Product soap = new Product("Deo", 39.99, false);
		
		ShoppingCart cart = new ShoppingCart();
		cart.addProductToCart(soap, 5);
		
		int quantity = cart.getQuatity(soap);
		assertEquals(5, quantity);
	}
	
	@Test
	public void verifyProductQuantityAndUnitPrice(){
		//given
		Product dove = new Product("Dove", 39.99, false);
		Product axeDeo = new Product("Axe Deo's", 99.99, false);
		
		//when
		ShoppingCart cart = new ShoppingCart();
		cart.addProductToCart(dove, 2);
		
		cart.addProductToCart(axeDeo, 2);
		
		//then
		assertEquals(2, cart.getQuatity(dove));
		assertEquals(2, cart.getQuatity(axeDeo));
		assertEquals(279.96, cart.getTotalPrice(), 0);
		
	}
	
	@Test
	public void verifyOfferBuyXGetYfree(){
		//given
		Product dove = new Product("Dove", 40,true);
		Product axeDeo = new Product("Axe Deo's", 100, false);
		
		//when
		ShoppingCart cart = new ShoppingCart();
		cart.addProductToCart(dove, 3);
		cart.addProductToCart(axeDeo, 2);
		
		//then
		assertEquals(3, cart.getQuatity(dove));
		assertEquals(2, cart.getQuatity(axeDeo));
		assertEquals(40, cart.getTotalDiscount(), 0);
		assertEquals(280, cart.getTotalPrice(), 0);
		
		
		
		//then
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

