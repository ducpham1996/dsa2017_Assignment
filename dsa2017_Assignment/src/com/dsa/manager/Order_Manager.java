package com.dsa.manager;

import com.dsa.files.List_Orders;
import com.dsa.physical.Tab_Order;

public class Order_Manager {
	public boolean isPCodeExistInOrder(String pcode){
		boolean found = false;
		for (Tab_Order o : List_Orders.order_list){
			if(o.getPcode().equals(pcode)){
				found = true;
			}
		}
		return found;
	}
	public boolean isCCodeExistInOrder(String ccode){
		boolean found = false;
		for(Tab_Order o : List_Orders.order_list){
			if(o.getCcode().equals(ccode)){
				found = true;
			}
		}
		return found;
	}
}
