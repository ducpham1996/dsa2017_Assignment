package com.dsa.module;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;

import com.dsa.array.SortUtils;
import com.dsa.array.Stack;
import com.dsa.files.List_Customer;
import com.dsa.files.List_Products;
import com.dsa.manager.Customer_Manager;
import com.dsa.manager.Product_Manager;
import com.dsa.physical.Tab_Customer;
import com.dsa.physical.Tab_Product;
import com.dsa.tablemodel.CustomerTableModel;

public class Search_Customers extends __BaseModule {
	protected JScrollPane mainOuter;
	private javax.swing.JPanel pro_main_panel;
	private javax.swing.JScrollPane scroll;
	private javax.swing.JTable table;
	private javax.swing.JTextField search;
	private JViewport viewport;
	private String[] columnNames = { "Code", "Name", "Phone" };
	private Class[] columnClass = { String.class, String.class, String.class };
	private Stack<Tab_Customer> ltc;

	public Search_Customers() {
		Customer_Manager cm = new Customer_Manager();
		pro_main_panel = new JPanel();
		scroll = new JScrollPane();
		table = new JTable();
		search = new JTextField("Search here");
		search.setForeground(Color.GRAY);
		search.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (search.getText().equals("Search here")) {
					search.setText("");
					search.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (search.getText().isEmpty()) {
					search.setForeground(Color.GRAY);
					search.setText("Search here");
				}
			}

		});
		search.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				
				ltc = cm.search(search.getText());
				// System.out.println(search.getText());
				CustomerTableModel ctm = new CustomerTableModel(ltc, columnNames, columnClass);
				table.setModel(ctm);
			}

		});

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ltc = List_Customer.list_customers;
		for (Component c : useFrame().getContentPane().getComponents()) {
			mainOuter = (JScrollPane) c;
		}
		Stack<Tab_Customer> ltc = List_Customer.list_customers;
		CustomerTableModel ctm = new CustomerTableModel(ltc, columnNames, columnClass);
		// for (Tab_Customer pro : getAllCustomers) {
		// Object[] o = new Object[6];
		// o[0] = pro.getPcode();
		// o[1] = pro.getPro_name();
		// o[2] = pro.getPrice();
		// o[3] = pro.getQuantity();
		// o[4] = pro.getSale();
		// // o[5] = icon;
		// model.addRow(o);
		// }
		table.setModel(ctm);

		scroll.setViewportView(table);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(pro_main_panel);
		pro_main_panel.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(search).addComponent(scroll));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(scroll)
						.addContainerGap()));

		mainOuter.setViewportView(pro_main_panel);
	}
}
