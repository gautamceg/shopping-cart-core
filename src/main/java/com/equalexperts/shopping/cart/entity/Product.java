package com.equalexperts.shopping.cart.entity;

public class Product {
	private String name;
	private double unitPrice;
	private boolean underDiscount;
	
	public boolean isUnderDiscount() {
		return underDiscount;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String name, double unitPrice, boolean underDiscount) {
		super();
		this.name = name;
		this.unitPrice = unitPrice;
		this.underDiscount = underDiscount;
	}

	public String getName() {
		return name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(unitPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(unitPrice) != Double.doubleToLongBits(other.unitPrice))
			return false;
		return true;
	}
	
	
	
}
