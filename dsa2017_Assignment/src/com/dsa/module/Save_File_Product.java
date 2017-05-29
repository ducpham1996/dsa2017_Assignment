package com.dsa.module;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.dsa.array.Linked_List;
import com.dsa.files.List_Products;
import com.dsa.files.write_file;
import com.dsa.physical.Tab_Product;

public class Save_File_Product extends __BaseModule {
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String message = "Save Successfull";
		try {
			JSONArray jarray = new JSONArray();
			Linked_List<Tab_Product> tp = List_Products.list_products;
			for (Tab_Product p : tp) {
				JSONObject jobject = new JSONObject();
				jobject.put("pcode", p.getPcode());
				jobject.put("pro_name", p.getPro_name());
				jobject.put("quantity", p.getQuantity());
				jobject.put("sale", p.getSale());
				jobject.put("price", p.getPrice());
				jobject.put("pro_image_url", p.getPro_image_url());
				jarray.add(jobject);

			}
			write_file wf = new write_file();
			wf.write("products.json", jarray.toJSONString());
			JOptionPane.showMessageDialog(new JFrame(), message, "Message", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Message", JOptionPane.WARNING_MESSAGE);
		}

	}

}
