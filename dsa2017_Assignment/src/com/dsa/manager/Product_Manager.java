package com.dsa.manager;

import com.dsa.array.Linked_List;
import com.dsa.files.List_Products;
import com.dsa.physical.Tab_Product;

public class Product_Manager {

	public boolean isCodeExist(String pcode) {
		boolean found = false;
		for (int i = 0; i < List_Products.list_products.size(); i++) {
			Tab_Product p = List_Products.list_products.get(i);
			if (p.getPcode().equals(pcode)) {
				found = true;
			}
		}
		return found;
	}

	public int reTurnSaled(String pcode) {
		int saled = 0;
		for (Tab_Product p : List_Products.list_products) {
			if (p.getPcode().equals(pcode)) {
				saled = p.getSale();
			}
		}
		return saled;
	}

	public Linked_List<Tab_Product> search_product(String pcode) {
		Linked_List<Tab_Product> lp = new Linked_List<>();
		for (int i = 0; i < List_Products.list_products.size(); i++) {
			Tab_Product p = List_Products.list_products.get(i);
			if (p.getPcode().contains(pcode)) {
				lp.add(p);
			}
		}
		return lp;
	}

	// public Product_List<Tab_Product> search_product(String pcode) {
	// Product_List<Tab_Product> lp = new Product_List<>();
	// for (Tab_Product p : List_Products.list_products) {
	// if (p.getPcode().contains(pcode)) {
	// // System.out.println(p);
	// lp.add(p);
	// }
	// }
	// return lp;
	// }

	public void remove_product(Linked_List<Tab_Product> remove_list) {
		// for (int i = 0; i < List_Products.list_products.size(); i++) {
		// Tab_Product p = List_Products.list_products.get(i);
		// for (int k = 0; k < remove_list.size(); k++) {
		// Tab_Product p2 = remove_list.get(k);
		// //System.out.println(p2.getPcode());
		// if (p.getPcode().equals(p2.getPcode())) {
		// List_Products.list_products.remove(p);;
		// }
		// }
		// }
		for (Tab_Product p : remove_list) {
			List_Products.list_products.remove(p);
		}
	}
}
