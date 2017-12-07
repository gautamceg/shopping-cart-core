package com.equalexperts.shopping.cart.service;

import java.util.Map;
import java.util.Map.Entry;

import com.equalexperts.shopping.cart.entity.Product;
import com.equalexperts.shopping.cart.entity.ShoppingCart;
import com.equalexperts.shopping.cart.util.ShoppingCartUtil;

public class ShoppingCartService {
	
	private Map<Product,Integer> cartProducts;
	private ShoppingCart shoppingCart;
	
	public ShoppingCartService() {
		this.shoppingCart = new ShoppingCart();
	}
	
	public boolean clearShoppingCart(){
		cartProducts = shoppingCart.getCartProducts();
		if(cartProducts != null){
			cartProducts.clear();
			return true;
		}
		return false;
	}
	
	

	
}
