package com.equalexperts.shopping.cart.entity;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ShoppingCart {

	private Map<Product,Integer> cartProducts = new ConcurrentHashMap<>();

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
}
