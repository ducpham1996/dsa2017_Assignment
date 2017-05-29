package com.dsa.module;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;

import com.dsa.files.Read_Products;
import com.dsa.array.Linked_List;
import com.dsa.files.List_Products;
import com.dsa.physical.Tab_Product;

public class Load_Product extends __BaseModule {
	protected JScrollPane mainOuter;
	//protected JTextArea mainView;

	private javax.swing.JTable products_table;
	private Object[] columnNames = { "Code", "Name", "Price", "Quantity", "Saled", "IMG" };

	public Load_Product() {

		products_table = new JTable();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// useFrame().inspectEvent(arg0);
		// useFrame().showColorDialog(x -> newFile(x));
		useFrame().clearMainView();
		// for (Component c : useFrame().getContentPane().getComponents()) {
		// mainOuter = (JScrollPane) c;
		// JViewport viewport = mainOuter.getViewport();
		// for (Component c1 : viewport.getComponents()) {
		// if (c1.getName().equals("mainarea")) {
		// mainView = (JTextArea) c1;
		// }
		// }
		// }

		JViewport viewport;
		viewport = new JViewport();
		List_Products lp = new List_Products();
		for (Component c : useFrame().getContentPane().getComponents()) {
			mainOuter = (JScrollPane) c;
			viewport = mainOuter.getViewport();
			// for (Component c1 : viewport.getComponents()) {
			// if (c1.getName().equals("mainarea")) {
			// mainView = (JTextArea) c1;
			// }
			// }
			// pro_main_panel.add(pro_code_text);
			// pro_main_panel.add(pro_name_text);

			// viewport.add(pro_main_panel);

		}
		Read_Products rp = new Read_Products();
		Linked_List<Tab_Product> getAllProducts = new Linked_List<>();
		getAllProducts = lp.list_products;
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
