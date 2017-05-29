package com.dsa.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.dsa.array.Linked_List;
import com.dsa.physical.Tab_Product;

public class Read_Products {
	public Linked_List<Tab_Product> read_all_product() {
		try {
			Linked_List<Tab_Product> products = new Linked_List<>();
			file_path filepath = new file_path();
			// FileReader reader = new FileReader(filepath.filepath() +
			// "products.json");
			BufferedReader in = new BufferedReader(
					new InputStreamReader(new FileInputStream(new File(filepath.url + "products.json")), "UTF8"));
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
				Tab_Product p = new Tab_Product();
				p.setPcode(object.get("pcode").toString());
				p.setPro_name(object.get("pro_name").toString());
				p.setQuantity(Integer.parseInt(object.get(("quantity")).toString()));
				p.setSale(Integer.parseInt((String) object.get(("sale")).toString()));
				p.setPrice((Double) object.get("price"));
				p.setPro_image_url(object.get("pro_image_url").toString());
				p.setI(false);
				products.add(p);
			}
			return products;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public void add_product(Tab_Product product) {
		JSONObject object = new JSONObject();
		object.put("pcode", product.getPcode());
		object.put("pro_name", product.getPro_name());
		object.put("quantity", product.getQuantity());
		object.put("sale", product.getSale());
		object.put("price", product.getPrice());
		object.put("pro_image_url", product.getPro_image_url());
		try {
			file_path filepath = new file_path();
			FileReader reader = new FileReader(filepath.filepath() + "products.json");
			BufferedReader br = new BufferedReader(reader);
			String content = br.readLine();

			write_file wf = new write_file();
			if (content == null) {
				content = "";
				content += "[" + object.toJSONString() + "]";
			} else if (content.startsWith("[")) {
				content = content.replace("]", ",");
				content += object.toJSONString() + "]";
			} else {
				content += "[" + object.toJSONString() + "]";
			}
			wf.write("products.json", content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// public void remove_product(List<Tab_Product> list_to_remove) {
	// List_Products.list_products.removeAll(list_to_remove);
	// }

	public static void main(String[] args) {
//		Read_Products rp = new Read_Products();
//		Linked_List<Tab_Product> pt = rp.read_all_product();

//		Tab_Product p = pt.get(pt.size() - 3);
//		pt.removeNext(p);

		 Linked_List<Tab_Product> pt = new Linked_List<>();
		 Tab_Product p = new Tab_Product();
		 p.setPcode("abc");
		 p.setPrice(3.0);
		 p.setPro_name("dsfdsf");
		 pt.add(p);
		 Tab_Product p2 = new Tab_Product();
		 p2.setPcode("adef");
		 p2.setPrice(3.0);
		 p2.setPro_name("dsfdsf");
		 pt.add(p2);
		 Tab_Product p3 = new Tab_Product();
		 p3.setPcode("abcsss");
		 p3.setPrice(3.0);
		 p3.setPro_name("dsfdsf");
		 pt.add(p3);
		 pt.remove(p3);
		 //pt.removeNext(p);
		 for(Tab_Product pro : pt){
			 System.out.println(pro);
		 }
	}
}
