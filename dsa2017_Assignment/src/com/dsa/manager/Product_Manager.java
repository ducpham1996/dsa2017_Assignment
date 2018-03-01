package com.dsa.manager;

import com.dsa.array.Linked_List;
import com.dsa.files.List_Products;
import com.dsa.physical.Tab_Product;

public class Product_Manager {
//check code is existed
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
//Search product
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


	public void remove_product(Linked_List<Tab_Product> remove_list) {
		for (Tab_Product p : remove_list) {
			List_Products.list_products.remove(p);
		}
	}
}
