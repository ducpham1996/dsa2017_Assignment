package com.dsa.files;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.dsa.array.Linked_List;
import com.dsa.physical.Tab_Product;

public class List_Products {
	public static Linked_List<Tab_Product> list_products;

	public List_Products() {
		super();
		Read_Products rp = new Read_Products();
		list_products = new Linked_List();
		list_products = rp.read_all_product();
	}



}
