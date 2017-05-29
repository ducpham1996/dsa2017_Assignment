package com.dsa.app;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.dsa.module.*;

import dsa2017.swing.SwingMenuBar;
import dsa2017.swing.SwingActionMarker;

public class ProtoMenuBar extends SwingMenuBar {
	public JMenu menu_order;

	// Order list:
	// 3.1. Input data
	@SwingActionMarker(Add_Order.class)
	public JMenuItem menu_order_input;

	// 3.2. Display data with total value
	@SwingActionMarker(Display_Order.class)
	public JMenuItem menu_order_display;

	// 3.3. Sort by pcode and ccode
	@SwingActionMarker(Sort_Order.class)
	public JMenuItem menu_order_sort;

	public JMenuBar menuBar;
	public JMenu menu_product;
	public JMenu menu_customer;
	public JMenu menu_help;

	@SwingActionMarker(Load_Product.class)
	public JMenuItem menu_load_product_file;

	@SwingActionMarker(Add_Product.class)
	public JMenuItem menu_add_new_product;

	@SwingActionMarker(Display_Products.class)
	public JMenuItem menu_product_display;

	@SwingActionMarker(Save_File_Product.class)
	public JMenuItem menu_file_save_as;

	@SwingActionMarker(Save_File_Order.class)
	public JMenuItem menu_order_save;

	// @SwingActionMarker(Help_Search.class)
	public JMenuItem menu_help_search;

	@SwingActionMarker(Load_Customer.class)
	public JMenuItem menu_customer_load;

	@SwingActionMarker(Add_Customer.class)
	public JMenuItem menu_customer_input;

	@SwingActionMarker(Search_Products.class)
	public JMenuItem menu_product_search;

	@SwingActionMarker(Delete_Product.class)
	public JMenuItem menu_product_delete;

	@SwingActionMarker(Sort_Product.class)
	public JMenuItem menu_product_sort;

	@SwingActionMarker(Delete_Product_After_xCode.class)
	public JMenuItem menu_product_delete_next;

	@SwingActionMarker(Display_Customer.class)
	public JMenuItem menu_customer_display;

	@SwingActionMarker(Save_File_Customer.class)
	public JMenuItem menu_customer_save;

	@SwingActionMarker(Search_Customers.class)
	public JMenuItem menu_customer_search;

	@SwingActionMarker(Delete_Customer.class)
	public JMenuItem menu_customer_delete;

	public void createMenuBar(JFrame f) {
		f.setJMenuBar(menuBar = new JMenuBar());

		menuBar.add(menu_product = newJMenu("Product list", KeyEvent.VK_F));
		menuBar.add(menu_customer = newJMenu("Customer", KeyEvent.VK_E));

		menu_product.add(menu_load_product_file = newJMenuItem("Load data from file", KeyEvent.VK_L, KeyEvent.VK_L));
		menu_product.add(menu_add_new_product = newJMenuItem("Input and add new item", KeyEvent.VK_A, KeyEvent.VK_A));

		// menu_product.addSeparator();
		menu_product.add(menu_product_display = newJMenuItem("Display data", KeyEvent.VK_D ,KeyEvent.VK_D));
		menu_product.add(menu_file_save_as = newJMenuItem("Save product list to file", KeyEvent.VK_S, KeyEvent.VK_S));
		menu_product.add(menu_product_search = new JMenuItem("Search by pcode"));
		menu_product.add(menu_product_delete = new JMenuItem("Delete by pcode"));
		menu_product.add(menu_product_sort = new JMenuItem("Sort by pcode"));
		menu_product
				.add(menu_product_delete_next = new JMenuItem("Delete the node after the node having code = xCode"));

		menu_customer.add(menu_customer_load = new JMenuItem("Load data from file", KeyEvent.VK_C));
		menu_customer.add(menu_customer_input = new JMenuItem("Input & add new item", KeyEvent.VK_A));
		menu_customer.add(menu_customer_display = new JMenuItem("Display data"));
		menu_customer.add(menu_customer_save = new JMenuItem("Save customer to list"));
		menu_customer.add(menu_customer_search = new JMenuItem("Search by Ccode"));
		menu_customer.add(menu_customer_delete = new JMenuItem("Delete by Ccode"));

		menuBar.add(menu_order = newJMenu("Order", KeyEvent.VK_O));
		menu_order.add(menu_order_input = newJMenuItem("Input order", KeyEvent.VK_I, KeyEvent.VK_F1));
		menu_order.add(menu_order_display = newJMenuItem("Display", KeyEvent.VK_D, KeyEvent.VK_F1));
		menu_order.add(menu_order_sort = newJMenuItem("Sort", KeyEvent.VK_O, KeyEvent.VK_F1));
		menu_order.add(menu_order_save = new JMenuItem("Save"));

	}

}
