package com.equalexperts.shopping.cart.util;

import static com.equalexperts.shopping.cart.constants.ShoppingCartConstants.TAX_RATE;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ShoppingCartUtil {
	
	public static double calculateTaxOnTotalAmount(double totalAmount){
		double taxAmount = 0;
		if(totalAmount >=0){
			taxAmount = (totalAmount * (TAX_RATE))/100;
			taxAmount = roundUpAmount(taxAmount);
		}
		return taxAmount;
	}
	
	public static double calculatePaybleAmount(double totalAmount){
		double paybleAmount = 0;
		if(totalAmount >0){
			paybleAmount = totalAmount + calculateTaxOnTotalAmount(totalAmount);
			paybleAmount = roundUpAmount(paybleAmount);
		}
		return paybleAmount;
	}
	
	public static double roundUpAmount(double amount){
		if(amount>0){
			//totalPrice formatted to 2 decimal places, rounded up i.e. 0.567 should result in 0.57 but 0.564 should result in 0.56
			//return Math.round(amount*100.0)/100.0;
			return BigDecimal.valueOf(amount).setScale(2, RoundingMode.HALF_UP).doubleValue();
			
		}
		return 0;
	}

}
