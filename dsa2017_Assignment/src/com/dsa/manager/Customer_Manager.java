package com.dsa.manager;

import java.util.ArrayList;
import java.util.List;

import com.dsa.array.Stack;
import com.dsa.files.List_Customer;
import com.dsa.physical.Tab_Customer;

public class Customer_Manager {
	public boolean isExist(String ccode) {
		boolean found = false;
		for (Tab_Customer c : List_Customer.list_customers) {
			if (c.getCcode().equals(ccode)) {
				found = true;
			}
		}
		return found;
	}
	public Stack<Tab_Customer> search(String ccode){
		Stack<Tab_Customer> lc = new Stack<>();
		for (Tab_Customer c : List_Customer.list_customers) {
			if (c.getCcode().contains(ccode)) {
				lc.push(c);
			}
		}
		return lc;
	}
	public void remove(Stack<Tab_Customer> list_to_remove){
		for(Tab_Customer c : list_to_remove){
			List_Customer.list_customers.remove(c);
		}
	}
}
