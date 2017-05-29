package com.dsa.module;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;

import com.dsa.files.Read_Products;
import com.dsa.array.Linked_List;
import com.dsa.files.List_Products;
import com.dsa.physical.Tab_Product;

public class Display_Products extends __BaseModule{
	protected JScrollPane mainOuter;
	protected JTextArea mainView;

	private javax.swing.JTable products_table;
	private Object[] columnNames = { "Code", "Name", "Price", "Quantity", "Saled", "IMG" };
	public Display_Products() {
		products_table = new JTable();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JViewport viewport;
		viewport = new JViewport();

		for (Component c : useFrame().getContentPane().getComponents()) {
			mainOuter = (JScrollPane) c;
			viewport = mainOuter.getViewport();
		}
		Read_Products rp = new Read_Products();
		Linked_List<Tab_Product> getAllProducts = new Linked_List<>();
		getAllProducts = List_Products.list_products;
		ImageIcon icon = null;
		BufferedImage img = null;
		System.out.println(getAllProducts.size());
		DefaultTableModel model = new DefaultTableModel(new Object[0][0], columnNames);
		try {
			for (Tab_Product pro : getAllProducts) {
//				if (!pro.getPro_image_url().equals("")) {
//					img = ImageIO.read(new URL(pro.getPro_image_url()));
//					if(img == null){	
//						icon = new ImageIcon("data//default_post.jpg");
//						
//					}else{
//						icon = new ImageIcon(img);
//					}
//					
//				}else{
//					icon = new ImageIcon("data//default_post.jpg");
//				}
				Object[] o = new Object[6];
				o[0] = pro.getPcode();
				o[1] = pro.getPro_name();
				o[2] = pro.getPrice();
				o[3] = pro.getQuantity();
				o[4] = pro.getSale();
				//o[5] = icon;
				model.addRow(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//products_table.setRowHeight(100);
		products_table.setModel(model);
		//products_table.getColumnModel().getColumn(5).setCellRenderer(products_table.getDefaultRenderer(ImageIcon.class));
		viewport.add(products_table);
		useFrame().revalidate();
		useFrame().repaint();
	}
}
