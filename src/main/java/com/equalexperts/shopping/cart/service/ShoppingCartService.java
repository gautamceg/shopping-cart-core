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
	
	public double addProduct(Product product, int unit){
		double totalAmount = 0;
		if(product !=null && unit > 0){
			shoppingCart.addProductToCart(product, unit);
			totalAmount = calculateTotalPrice(shoppingCart.getCartProducts());
			return totalAmount;
		}
		return totalAmount;
	}
	
	private double calculateTotalPrice(Map<Product,Integer> cartProducts){
		double totalPrice = 0;
		if(cartProducts != null){
			for(Entry<Product,Integer> entry : cartProducts.entrySet()){
				totalPrice = totalPrice + entry.getKey().getUnitPrice() * entry.getValue();
			}
			totalPrice = ShoppingCartUtil.roundUpAmount(totalPrice);
		}
		return totalPrice;
	}
	
}
