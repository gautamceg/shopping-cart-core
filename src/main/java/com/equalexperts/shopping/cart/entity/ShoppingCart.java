package com.equalexperts.shopping.cart.entity;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import com.equalexperts.shopping.cart.util.ShoppingCartUtil;

public class ShoppingCart {

	private Map<Product,Integer> cartProducts = new ConcurrentHashMap<>();
	private static final int OFFER_QUANTITY = 3; 

	public Map<Product, Integer> getCartProducts() {
		return cartProducts;
	}

	public void addProductToCart(Product product, int unit) {
		if(product !=null && unit > 0){
			if(cartProducts != null && cartProducts.containsKey(product)){
				cartProducts.put(product, cartProducts.get(product) + unit);
			}
			else{
				cartProducts.put(product, unit);
			}
		}
	}
	
	public int getQuatity(Product soap) {
		int quantity = cartProducts.get(soap);
		return quantity;
	}
	
	public double getTotalPrice() {
		double totalPrice = 0;
		if(cartProducts != null){
			for(Entry<Product,Integer> entry : cartProducts.entrySet()){
				totalPrice = totalPrice + entry.getKey().getUnitPrice() * entry.getValue();
			}
			totalPrice = totalPrice - getTotalDiscount();
			totalPrice = ShoppingCartUtil.roundUpAmount(totalPrice);
		}
		return totalPrice;
	}

	public double getTotalDiscount() {
		// buy 2 get 1
		double discountAmt = 0;
		for(Entry<Product,Integer> entry : cartProducts.entrySet()){
			if(entry.getKey().isUnderDiscount()){
				int quantity = entry.getValue();
				discountAmt = (quantity/OFFER_QUANTITY)*entry.getKey().getUnitPrice();
			}
		}
		return discountAmt;
	}
	
	
}
