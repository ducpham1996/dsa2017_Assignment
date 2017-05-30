package com.dsa.files;

import com.dsa.array.Stack;
import com.dsa.physical.Tab_Customer;

public class List_Customer {
	public static Stack<Tab_Customer> list_customers;

	public List_Customer() {
		//super();
		Read_Customers rc = new Read_Customers();
		list_customers = new Stack<>();
		list_customers = rc.read_all_customers();
	}

}
