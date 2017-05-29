package com.dsa.files;

import java.util.ArrayList;
import java.util.List;

import com.dsa.array.Linked_List;
import com.dsa.array.MyStack;
import com.dsa.array.Queue;
import com.dsa.physical.Tab_Order;

public class List_Orders {
	public static Queue<Tab_Order> order_list;

	public List_Orders() {
		order_list = new Queue<>();
		Read_Orders ro = new Read_Orders();
		order_list = ro.get_all_orders();
	}
}
