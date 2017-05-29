package com.dsa.physical;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Tab_Product implements Serializable {
	// About a product:
	// 1. pcode (string): the code of the product (this should be unique for the
	// product).
	// 2. pro_name (string): the name of the product.
	// 3. quantity (integer): the number of products with the same code in a
	// shop at beginning of a day.
	// 4. saled (integer): the number of products with the same code, which are
	// saled in the day. Condition: saled ≤ quantity.
	// 5. price (double): The price of the product.
	public String pcode;
	public String pro_name;
	public Integer quantity;
	public Integer sale;
	public Double price;
	public String pro_image_url;
	public boolean i;
	public boolean getI() {
		return i;
	}

	public void setI(boolean i) {
		this.i = i;
	}

	private static final long serialVersionUID = 8537769;

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getSale() {
		return sale;
	}

	public void setSale(Integer sale) {
		this.sale = sale;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPro_image_url() {
		return pro_image_url;
	}

	public void setPro_image_url(String pro_image_url) {
		this.pro_image_url = pro_image_url;
	}

	// @Override
	// public String toString() {
	// return "pcode=" + pcode + ", pro_name=" + pro_name + ", quantity=" +
	// quantity + ", sale=" + sale
	// + ", price=" + price;
	// }
	@Override
	public String toString() {
		DecimalFormat format = new DecimalFormat("0.00");
		return String.format("%-9s%-15s%-10d%-6d%-20s", pcode, pro_name, quantity, sale, format.format(price) + "$");
	}

}
