package com.dsa.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.dsa.array.Stack;
import com.dsa.physical.Tab_Customer;

public class Read_Customers {
	public Stack<Tab_Customer> read_all_customers() {
		try {
			Stack<Tab_Customer> cus = new Stack<>();
			file_path filepath = new file_path();
			// FileReader reader = new FileReader();
			BufferedReader in = new BufferedReader(
					new InputStreamReader(new FileInputStream(new File(filepath.url + "customers.json")), "UTF8"));
			String result = "";
			String str;
			while ((str = in.readLine()) != null) {
				result = str;
			}
			JSONParser parser = new JSONParser();
			JSONArray jsonArray = (JSONArray) parser.parse(result);
			Iterator iterator = jsonArray.iterator();
			while (iterator.hasNext()) {
				JSONObject object = (JSONObject) iterator.next();
				Tab_Customer c = new Tab_Customer();
				c.setCcode(object.get("ccode").toString());
				c.setCus_name(object.get("cus_name").toString());
				c.setPhone(object.get("phone").toString());
				c.setI(false);
				cus.push(c);
			}
			return cus;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
//	public static void main(String[] args) {
//		Read_Customers rc = new Read_Customers();
//		//List_Customer lc = new List_Customer();
//		Stack<Tab_Customer> st = new Stack<>();
//		Tab_Customer tc = new Tab_Customer();
//		
//		for(Tab_Customer c : rc.read_all_customers()){
//			st.push(c);
//		}
//
//		
//	}
}
