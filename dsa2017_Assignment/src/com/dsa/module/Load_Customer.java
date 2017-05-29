package com.dsa.module;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.dsa.array.Stack;
import com.dsa.files.List_Customer;
import com.dsa.physical.Tab_Customer;
import com.dsa.tablemodel.CustomerTableModel;

public class Load_Customer extends __BaseModule {
	protected JScrollPane mainOuter;
	private javax.swing.JTable customer_table;
	private String[] columnNames = { "Code", "Name", "Phone" };
	private Class[] columnClass = { String.class, String.class, String.class };

	public Load_Customer() {
		customer_table = new JTable();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		for (Component c : useFrame().getContentPane().getComponents()) {
			mainOuter = (JScrollPane) c;
			// viewport = mainOuter.getViewport();
		}
		List_Customer lc = new List_Customer();
		Stack<Tab_Customer> ltc = List_Customer.list_customers;
		System.out.println(ltc.size());
		CustomerTableModel ctm = new CustomerTableModel(ltc, columnNames, columnClass);
		customer_table.setModel(ctm);
		mainOuter.getViewport().add(customer_table);
	}
}
