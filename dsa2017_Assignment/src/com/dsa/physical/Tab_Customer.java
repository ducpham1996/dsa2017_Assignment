package com.dsa.physical;

//About a customer:
//1.	ccode (string): the code of the customer (this should be unique for the customer).
//2.	cus_name (string): the name of the customer.
//3.	phone (string): The phone number of the customer (must contain digits only).

public class Tab_Customer implements Comparable<Tab_Customer> {
	public String ccode;
	public String cus_name;
	public String phone;
	public Boolean i;

	public Boolean getI() {
		return i;
	}

	public void setI(Boolean i) {
		this.i = i;
	}

	public String getCcode() {
		return ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	public String getCus_name() {
		return cus_name;
	}

	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int compareTo(Tab_Customer arg0) {
		return this.getCus_name().compareTo(arg0.getCus_name());
	}

}
