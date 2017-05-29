package com.dsa.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.dsa.array.MyStack;
import com.dsa.array.Queue;
import com.dsa.array.Linked_List;
import com.dsa.physical.Tab_Customer;
import com.dsa.physical.Tab_Order;
import com.dsa.physical.Tab_Product;

public class Read_Orders {
	public Queue<Tab_Order> get_all_orders() {
		try {

			file_path filepath = new file_path();
			// FileReader reader = new FileReader();
			BufferedReader in = new BufferedReader(
					new InputStreamReader(new FileInputStream(new File(filepath.url + "orders.json")), "UTF8"));
			String result = "";
			String str;
			while ((str = in.readLine()) != null) {
				result = str;
			}
			JSONParser parser = new JSONParser();
			JSONArray jsonArray = (JSONArray) parser.parse(result);
			Queue<Tab_Order> lo = new Queue<>();
			Iterator iterator = jsonArray.iterator();
			while (iterator.hasNext()) {
				JSONObject object = (JSONObject) iterator.next();
				Tab_Order o = new Tab_Order();
				o.setPcode(object.get("pcode").toString());
				o.setCcode(object.get("ccode").toString());
				o.setQuantity(Integer.parseInt(object.get("quantity").toString()));
				lo.enqueue(o);
			}
			return lo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}

	}

	public static void main(String[] args) {
//		List_Orders lo = new List_Orders();
//		Read_Orders ro = new Read_Orders();
//		//Linked_List<Tab_Order> llt = lo.order_list;
//		Queue<Tab_Order> mt = ro.get_all_orders();
//		Tab_Order o = new Tab_Order();
//		o.setCcode("dsfdsf");
//		o.setPcode("dsfdsf");
//		o.setQuantity(1);
//		mt.add(o);
//		for(Tab_Order oq : mt){
//			//System.out.println(oq.getCcode());
//		}
//		System.out.println(mt.counter);

	}
}
