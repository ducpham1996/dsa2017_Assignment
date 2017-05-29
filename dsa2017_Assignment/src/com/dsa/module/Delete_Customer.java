package com.dsa.module;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.dsa.array.Stack;
import com.dsa.files.List_Customer;
import com.dsa.manager.Customer_Manager;
import com.dsa.manager.Order_Manager;
import com.dsa.physical.Tab_Customer;
import com.dsa.tablemodel.CustomerTableModel;

public class Delete_Customer extends __BaseModule {
	protected JScrollPane mainOuter;
	private javax.swing.JPanel pro_main_panel;
	private javax.swing.JScrollPane scroll;
	private javax.swing.JTable table;
	private javax.swing.JTextField search;
	private javax.swing.JButton btn_delete;
	private static Stack<Tab_Customer> listc;
	private Stack<Tab_Customer> list_to_remove;
	private String[] columnNames = { "Code", "Name", "Phone", "" };
	private Class[] columnClass = { String.class, String.class, String.class, Boolean.class };

	public Delete_Customer() {
		pro_main_panel = new JPanel();
		scroll = new JScrollPane();
		table = new JTable();
		search = new JTextField("Type here");
		Customer_Manager cm = new Customer_Manager();
		search.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				String type = search.getText();
				listc = cm.search(type);
				CustomerTableModel ctm = new CustomerTableModel(listc, columnNames, columnClass);
				table.setModel(ctm);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		btn_delete = new JButton("Delete");
		btn_delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Order_Manager om = new Order_Manager();
				try {
					list_to_remove = new Stack<>();
					String temp = "";
					for (Tab_Customer p : listc) {
						// System.out.println(p.getCcode());
						if (p.getI() == true) {

							if (!om.isCCodeExistInOrder(p.getCcode())) {
								list_to_remove.push(p);
							} else {
								temp += p.getCcode() + ", ";

							}
							// list_to_remove.push(p);
						}
					}
					if (!temp.equals("")) {
						JFrame dialog = new JFrame();
						dialog.setSize(400, 500);
						JOptionPane.showMessageDialog(dialog, temp + "is/are current in use in Order", "Message",
								JOptionPane.INFORMATION_MESSAGE);
					}
					for (Tab_Customer c : List_Customer.list_customers) {
						c.setI(false);
					}
					// List_Customer.list_customers.removeALl(list_to_remove);
					cm.remove(list_to_remove);
					listc = List_Customer.list_customers;
					CustomerTableModel ctm = new CustomerTableModel(listc, columnNames, columnClass);
					table.setModel(ctm);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		search.setForeground(Color.GRAY);
		search.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (search.getText().equals("Type here")) {
					search.setText("");
					search.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (search.getText().isEmpty()) {
					search.setForeground(Color.GRAY);
					search.setText("Type here");
				}
			}

		});
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		for (Component c : useFrame().getContentPane().getComponents()) {
			mainOuter = (JScrollPane) c;
		}
		listc = List_Customer.list_customers;
		CustomerTableModel ctm = new CustomerTableModel(listc, columnNames, columnClass);
		table.setModel(ctm);

		scroll.setViewportView(table);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(pro_main_panel);
		pro_main_panel.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 500,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
						.addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addComponent(scroll));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_delete))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(scroll)
						.addContainerGap()));
		mainOuter.setViewportView(pro_main_panel);
	}
}
