package com.dsa.module;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import com.dsa.array.Linked_List;
import com.dsa.array.Stack;
import com.dsa.files.List_Customer;
import com.dsa.files.List_Orders;
import com.dsa.files.List_Products;
import com.dsa.manager.Customer_Manager;
import com.dsa.manager.Product_Manager;
import com.dsa.physical.Tab_Customer;
import com.dsa.physical.Tab_Order;
import com.dsa.physical.Tab_Product;
import com.dsa.tablemodel.CustomerTableModel;
import com.dsa.tablemodel.ProductTableModel;

public class Add_Order extends __BaseModule {
	protected JScrollPane mainOuter;
	private javax.swing.JPanel order_main_panel;
	private javax.swing.JButton btn_product;
	private javax.swing.JButton btn_customer;
	private javax.swing.JButton btn_submit;

	private javax.swing.JLabel clone;
	private javax.swing.JLabel lbl_product;
	private javax.swing.JLabel lbl_customer;
	private javax.swing.JLabel warn;
	private javax.swing.JLabel lbl_quantity;
	private javax.swing.JFrame pro_frame;
	private javax.swing.JFrame cus_frame;
	private javax.swing.JTable pro_table;
	private javax.swing.JTable cus_table;
	private String[] pro_columns = { "Code", "Name", "Price", "Quantity", "Saled" };
	private Class[] pro_classes = { String.class, String.class, Double.class, Integer.class, Integer.class };
	private String[] cus_columns = { "Code", "Name", "Phone" };
	private Class[] cus_classes = { String.class, String.class, String.class };
	private javax.swing.JScrollPane pro_main_scroll;
	private javax.swing.JScrollPane cus_main_scroll;
	private javax.swing.JPanel pro_main_panel;
	private javax.swing.JPanel cus_main_panel;
	private javax.swing.JScrollPane pro_scroll;
	private javax.swing.JScrollPane cus_scroll;
	private javax.swing.JTextField pro_search;
	private javax.swing.JTextField cus_search;
	private javax.swing.JButton btn_pro_select;
	private javax.swing.JButton btn_cus_select;
	private javax.swing.JFormattedTextField quantity;
	private static Linked_List<Tab_Product> listp;
	private static Stack<Tab_Customer> listc;

	public Add_Order() {
		NumberFormat format = new DecimalFormat("##############");
		//pro_table = new JTable();
		//cus_table = new JTable();
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(0);
		formatter.setMaximum(Integer.MAX_VALUE);
		formatter.setAllowsInvalid(false);
		formatter.setCommitsOnValidEdit(true);
		quantity = new JFormattedTextField(formatter);
		pro_frame = new JFrame("Choose product");
		cus_frame = new JFrame("Choose customer");
		order_main_panel = new JPanel();

		btn_product = new JButton("Add");
		btn_product.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				product_frame_action();
				pro_frame.setSize(500, 400);
				pro_frame.setVisible(true);

			}
		});

		btn_customer = new JButton("Add");
		btn_customer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				cus_frame_action();
				cus_frame.setSize(500, 400);
				cus_frame.setVisible(true);

			}
		});
		btn_submit = new JButton("Submit");
		btn_submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Product_Manager pm = new Product_Manager();
				if (lbl_product.getText().equals("Please choose Product")) {
					warn.setText("Please choose a product");
				} else if (lbl_customer.getText().equals("Please choose Customer")) {
					warn.setText("Please choose a customer");
				} else if (quantity.getText().equals("")) {
					warn.setText("Quantity can not be blanked");
				} else if (Integer.parseInt(quantity.getText()) > pm.reTurnSaled(lbl_product.getText())){
					warn.setText("Quantity can not greater than product sale");
				}
				else {
					warn.setText("Add successfully");
					Tab_Order o = new Tab_Order();
					o.setCcode(lbl_customer.getText());
					o.setPcode(lbl_product.getText());
					o.setQuantity(Integer.parseInt(quantity.getText()));
					List_Orders.order_list.enqueue(o);
					
				}

			}
		});
		clone = new JLabel("");
		lbl_product = new JLabel("Please choose Product");
		lbl_customer = new JLabel("Please choose Customer");
		lbl_quantity = new JLabel("Quantity");
		warn = new JLabel("");
		warn.setForeground(Color.red);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		for (Component c : useFrame().getContentPane().getComponents()) {
			mainOuter = (JScrollPane) c;
		}
		GroupLayout layout = new GroupLayout(order_main_panel);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.setHorizontalGroup(layout.createSequentialGroup().addGap(80, 80, 80)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(btn_product)
						.addComponent(btn_customer).addComponent(lbl_quantity).addComponent(clone).addComponent(clone)
						.addComponent(clone))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(lbl_product)
						.addComponent(lbl_customer)
						.addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(clone).addComponent(warn).addComponent(btn_submit)));

		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(btn_product)
						.addComponent(lbl_product))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(btn_customer)
						.addComponent(lbl_customer))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lbl_quantity)
						.addComponent(quantity))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(clone)
						.addComponent(clone))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(clone)
						.addComponent(warn))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(clone)
						.addComponent(btn_submit)));

		order_main_panel.setLayout(layout);

		mainOuter.getViewport().add(order_main_panel);
	}

	public void product_frame_action() {
		listp = List_Products.list_products;
		pro_frame = new JFrame();
		Product_Manager pm = new Product_Manager();
		pro_table = new JTable();
		pro_scroll = new JScrollPane();

		pro_search = new JTextField("Search here");
		pro_search.setForeground(Color.gray);
		pro_search.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (pro_search.getText().isEmpty()) {
					pro_search.setForeground(Color.GRAY);
					pro_search.setText("Search here");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (pro_search.getText().equals("Search here")) {
					pro_search.setText("");
					pro_search.setForeground(Color.BLACK);
				}

			}
		});
		pro_search.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				listp = pm.search_product(pro_search.getText());
				ProductTableModel ptm = new ProductTableModel(listp, pro_columns, pro_classes);
				pro_table.setModel(ptm);

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
		pro_main_panel = new JPanel();
		pro_main_scroll = new JScrollPane();
		btn_pro_select = new JButton("Select");
		btn_pro_select.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println(pro_table.getSelectedRow());
				//pro_table = new JTable();
				if (pro_table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(new JFrame(), "Please choose an item", "Error",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					pro_frame.setVisible(false);
					pro_frame = new JFrame();
					Tab_Product p = listp.get(pro_table.getSelectedRow());
					listp = List_Products.list_products;
					lbl_product.setText(p.getPcode());
				}

			}
		});
		ProductTableModel ptm = new ProductTableModel(List_Products.list_products, pro_columns, pro_classes);

		pro_scroll.setViewportView(pro_table);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(pro_main_panel);
		pro_main_panel.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addComponent(pro_search, javax.swing.GroupLayout.PREFERRED_SIZE, 300,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
						.addComponent(btn_pro_select, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addComponent(pro_scroll));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(pro_search, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_pro_select))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(pro_scroll)
						.addContainerGap()));
		// table.getColumnModel().getColumn(5).setCellRenderer(table.getDefaultRenderer(Boolean.class));
		pro_main_scroll.setViewportView(pro_main_panel);

		pro_table.setModel(ptm);
		pro_scroll.getViewport().add(pro_table);
		pro_frame.add(pro_main_panel);
	}

	public void cus_frame_action() {
		cus_frame = new JFrame();
		cus_table = new JTable();
		listc = List_Customer.list_customers;
		Customer_Manager cm = new Customer_Manager();
		
		cus_scroll = new JScrollPane();

		cus_search = new JTextField("Search here");
		cus_search.setForeground(Color.gray);
		cus_search.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (cus_search.getText().isEmpty()) {
					cus_search.setForeground(Color.GRAY);
					cus_search.setText("Search here");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (cus_search.getText().equals("Search here")) {
					cus_search.setText("");
					cus_search.setForeground(Color.BLACK);
				}

			}
		});
		cus_search.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				listc = cm.search(cus_search.getText());
				CustomerTableModel ctm = new CustomerTableModel(listc, cus_columns, cus_classes);
				cus_table.setModel(ctm);

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
		cus_main_panel = new JPanel();
		cus_main_scroll = new JScrollPane();
		btn_cus_select = new JButton("Select");
		btn_cus_select.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println(pro_table.getSelectedRow());

				if (cus_table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(new JFrame(), "Please choose an item", "Error",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					cus_frame.setVisible(false);
					cus_frame = new JFrame();
					// Tab_Product p = listp.get(pro_table.getSelectedRow());
					Tab_Customer c = listc.get(cus_table.getSelectedRow());
					listc = List_Customer.list_customers;
					lbl_customer.setText(c.getCcode());
				}

			}
		});
		CustomerTableModel ctm = new CustomerTableModel(List_Customer.list_customers, cus_columns,
				cus_classes);
		// roductTableModel ptm = new
		// ProductTableModel(List_Products.list_products, pro_columns,
		// pro_classes);

		cus_scroll.setViewportView(cus_table);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(cus_main_panel);
		cus_main_panel.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addComponent(cus_search, javax.swing.GroupLayout.PREFERRED_SIZE, 300,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
						.addComponent(btn_cus_select, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addComponent(cus_scroll));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(cus_search, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_cus_select))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(cus_scroll)
						.addContainerGap()));
		// table.getColumnModel().getColumn(5).setCellRenderer(table.getDefaultRenderer(Boolean.class));
		cus_main_scroll.setViewportView(cus_main_panel);

		cus_table.setModel(ctm);
		cus_scroll.getViewport().add(cus_table);
		cus_frame.add(cus_main_panel);
	}
}
