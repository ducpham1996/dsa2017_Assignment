package com.dsa.physical;

import java.util.Comparator;

//About ordering:
//1.	pcode (string): the code of the product to be ordered.
//2.	ccode (string): the code of the customer.
//3.	quantity (integer): the number of  ordered products.
public class Tab_Order implements Comparator<Tab_Order> , Comparable<Tab_Order> {
	public String pcode;
	public String ccode;
	public Integer quantity;

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getCcode() {
		return ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public int compare(Tab_Order o1, Tab_Order o2) {
		int compare = o1.getCcode().compareTo(o2.getCcode());
		if(compare != 0){
			return compare;
		}else {
			return o1.getPcode().compareTo(o2.getCcode());
		}

	}

	@Override
	public int compareTo(Tab_Order o) {
		int compare = this.getCcode().compareTo(o.getCcode());
		if(compare != 0){
			return compare;
		}else {
			return this.getPcode().compareTo(o.getPcode());
		}
	}


}
