package com.dsa.module;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.dsa.files.List_Customer;
import com.dsa.files.write_file;
import com.dsa.physical.Tab_Customer;

public class Save_File_Customer extends __BaseModule {
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			JSONArray jarray = new JSONArray();
			for(Tab_Customer c : List_Customer.list_customers){
				JSONObject jobject = new JSONObject();
				jobject.put("ccode", c.getCcode());
				jobject.put("cus_name", c.getCus_name());
				jobject.put("phone",c.getPhone());
				jarray.add(jobject);
			}
			write_file wf = new write_file();
			wf.write("customers.json", jarray.toJSONString());
			JOptionPane.showMessageDialog(new JFrame(), "Save Successfully", "Message", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
			e.printStackTrace();
		}
	}
}
