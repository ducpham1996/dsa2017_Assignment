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
import java.util.EventObject;
import java.util.Iterator;
import java.util.List;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

import com.dsa.files.Read_Products;
import com.dsa.array.Linked_List;
import com.dsa.files.List_Products;
import com.dsa.manager.Order_Manager;
import com.dsa.manager.Product_Manager;
import com.dsa.physical.Tab_Product;
import com.dsa.tablemodel.ProductTableModel;

public class Delete_Product extends __BaseModule {
	protected JScrollPane mainOuter;
	private javax.swing.JPanel pro_main_panel;
	private javax.swing.JScrollPane scroll;
	private javax.swing.JTable table;
	private javax.swing.JTextField search;
	private javax.swing.JButton btn_delete;
	private static Linked_List<Tab_Product> listp;
	private Linked_List<Tab_Product> list_to_remove;

	public Delete_Product() {
		Product_Manager pm = new Product_Manager();
		pro_main_panel = new JPanel();
		scroll = new JScrollPane();
		table = new JTable();
		search = new JTextField("Type here");
		search.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				String type = search.getText();
				listp = pm.search_product(type);
				ProductTableModel ptm = new ProductTableModel(listp,
						new String[] { "Code", "Name", "Price", "Quantity", "Sale", "" }, new Class[] { String.class,
								String.class, Double.class, Integer.class, Integer.class, Boolean.class });
				table.setModel(ptm);
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
				try {
					Order_Manager om = new Order_Manager();
					list_to_remove = new Linked_List<>();
					String temp = "";
					for (Tab_Product p : List_Products.list_products) {
						if (p.getI() == true) {
							if (!om.isPCodeExistInOrder(p.getPcode())) {
								list_to_remove.add(p);
							} else {
								temp += p.getPcode() + " ,";
							}
							p.setI(false);
							//list_to_remove.add(p);
						}
					}
					if (!temp.equals("")) {
						JOptionPane.showMessageDialog(new JFrame(), temp + "is/are current in use in Order", "Message",
								JOptionPane.INFORMATION_MESSAGE);
					}
					Product_Manager pm = new Product_Manager();
					pm.remove_product(list_to_remove);
					// List_Products.list_products.removeAll(list_to_remove);
					ProductTableModel ptm = new ProductTableModel(List_Products.list_products,
							new String[] { "Code", "Name", "Price", "Quantity", "Sale", "" },
							new Class[] { String.class, String.class, Double.class, Integer.class, Integer.class,
									Boolean.class });
					table.setModel(ptm);
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

	public void actionPerformed(ActionEvent arg0) {
		for (Component c : useFrame().getContentPane().getComponents()) {
			mainOuter = (JScrollPane) c;
			// viewport = mainOuter.getViewport();
		}
		ProductTableModel ptm = new ProductTableModel(List_Products.list_products,
				new String[] { "Code", "Name", "Price", "Quantity", "Sale", "" },
				new Class[] { String.class, String.class, Double.class, Integer.class, Integer.class, Boolean.class });

		table.setModel(ptm);

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
		// table.getColumnModel().getColumn(5).setCellRenderer(table.getDefaultRenderer(Boolean.class));
		mainOuter.setViewportView(pro_main_panel);
	}

}
