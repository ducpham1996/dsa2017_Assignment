package com.dsa.module;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.dsa.array.Queue;
import com.dsa.files.List_Orders;
import com.dsa.files.write_file;
import com.dsa.physical.Tab_Order;

public class Save_File_Order extends __BaseModule {
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String message = "Save Successfull";
		try {
			JSONArray jarray = new JSONArray();
			Queue<Tab_Order> q = List_Orders.order_list;
			for(Tab_Order o : q){
				JSONObject jobject = new JSONObject();
				jobject.put("pcode", o.getPcode());
				jobject.put("ccode", o.getCcode());
				jobject.put("quantity", o.getQuantity());
				jarray.add(jobject);
			}
			
			write_file wf = new write_file();
			wf.write("orders.json", jarray.toJSONString());
			JOptionPane.showMessageDialog(new JFrame(), message, "Message", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Message", JOptionPane.WARNING_MESSAGE);
		}

	}
}
