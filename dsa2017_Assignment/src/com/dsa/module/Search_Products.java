package com.dsa.module;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;

import com.dsa.array.Linked_List;
import com.dsa.files.List_Products;
import com.dsa.manager.Product_Manager;
import com.dsa.physical.Tab_Product;

public class Search_Products extends __BaseModule {
	protected JScrollPane mainOuter;
	private javax.swing.JPanel pro_main_panel;
	private javax.swing.JScrollPane scroll;
	private javax.swing.JTable table;
	private javax.swing.JTextField search;
	private JViewport viewport;

	public Search_Products() {
		// useFrame().clearMainView();
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
		Product_Manager pm = new Product_Manager();
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
				//System.out.println(search.getText());
				DefaultTableModel model = new DefaultTableModel(new Object[0][0],
						new String[] { "Code", "Name", "Price", "Quantity", "Sale" });
				Linked_List<Tab_Product> list = pm.search_product(search.getText());
				for(Tab_Product pro : list){
					Object[] o = new Object[5];
					o[0] = pro.getPcode();
					o[1] = pro.getPro_name();
					o[2] = pro.getPrice();
					o[3] = pro.getQuantity();
					o[4] = pro.getSale();
					model.addRow(o);
				}
				
//				for(int i = 0; i< pm.search_product(search.getText()).size();i++){
//					Tab_Product pro =  pm.search_product(search.getText()).get(i);
//					Object[] o = new Object[6];
//					o[0] = pro.getPcode();
//					o[1] = pro.getPro_name();
//					o[2] = pro.getPrice();
//					o[3] = pro.getQuantity();
//					o[4] = pro.getSale();
//					model.addRow(o);
//				}
				table.setModel(model);
			}

		});

	}

	public void actionPerformed(ActionEvent arg0) {
		Search_Products sp = new Search_Products();
		Linked_List<Tab_Product> getAllProducts = new Linked_List<>();
		getAllProducts = List_Products.list_products;
		for (Component c : useFrame().getContentPane().getComponents()) {
			mainOuter = (JScrollPane) c;
			viewport = mainOuter.getViewport();
		}
		//useFrame().clearMainView();
		DefaultTableModel model = new DefaultTableModel(new Object[0][0],
				new String[] { "Code", "Name", "Price", "Quantity", "Sale" });
		for (Tab_Product pro : getAllProducts) {
			Object[] o = new Object[6];
			o[0] = pro.getPcode();
			o[1] = pro.getPro_name();
			o[2] = pro.getPrice();
			o[3] = pro.getQuantity();
			o[4] = pro.getSale();
			// o[5] = icon;
			model.addRow(o);
		}
//		for(int i = 0; i< getAllProducts.size();i++){
//			Tab_Product pro =  getAllProducts.get(i);
//			Object[] o = new Object[6];
//			o[0] = pro.getPcode();
//			o[1] = pro.getPro_name();
//			o[2] = pro.getPrice();
//			o[3] = pro.getQuantity();
//			o[4] = pro.getSale();
//			model.addRow(o);
//		}
		table.setModel(model);

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
		// viewport.add(pro_main_panel);
	}
	
//	public List<Tab_Product> search_product(String pcode){
//		List<Tab_Product> lp = new ArrayList<>();
//		for(Tab_Product p : list_products.list_products){
//			if(p.getPcode().contains(pcode)){
//				lp.add(p);
//			}
//		}
//		return lp;
//	}
}
