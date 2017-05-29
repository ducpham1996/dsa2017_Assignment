package com.dsa.module;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.dsa.files.List_Products;
import com.dsa.manager.Order_Manager;
import com.dsa.manager.Product_Manager;
import com.dsa.physical.Tab_Product;
import com.dsa.tablemodel.ProductTableModel;

public class Delete_Product_After_xCode extends __BaseModule {
	protected JScrollPane mainOuter;
	private javax.swing.JPanel pro_main_panel;
	private javax.swing.JScrollPane scroll;
	private javax.swing.JTable table;
	private javax.swing.JTextField search;
	private javax.swing.JButton btn_delete;
	private List<Tab_Product> remove_list;

	public Delete_Product_After_xCode() {
		remove_list = new ArrayList<>();
		scroll = new JScrollPane();
		table = new JTable();
		search = new JTextField();
		pro_main_panel = new JPanel();
		btn_delete = new JButton("Delete");
		Order_Manager om = new Order_Manager();
		btn_delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String pcode = search.getText();
				Product_Manager pm = new Product_Manager();
				if (pm.isCodeExist(pcode)) {
					for (int i = 0; i < List_Products.list_products.size(); i++) {
						Tab_Product p = List_Products.list_products.get(i);
						if (p.getPcode().equals(pcode)) {
							if (i + 1 == List_Products.list_products.size()) {
								JOptionPane.showMessageDialog(new JFrame(), "There is no node after this code",
										"Dialog", JOptionPane.WARNING_MESSAGE);
							} else {
								Tab_Product item = List_Products.list_products.get(i + 1);
								if (!om.isPCodeExistInOrder(item.getPcode())) {
									List_Products.list_products.remove(item);
								} else {
									JOptionPane.showMessageDialog(new JFrame(),
											"There product: " + item.getPcode() + " is current in use in order",
											"Dialog", JOptionPane.WARNING_MESSAGE);
								}
								//List_Products.list_products.remove(item);
								ProductTableModel ptm = new ProductTableModel(List_Products.list_products,
										new String[] { "Code", "Name", "Price", "Quantity", "Sale" },
										new Class[] { String.class, String.class, Double.class, Integer.class,
												Integer.class });

								table.setModel(ptm);
							}

						}
					}

				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Code does not exist", "Dialog",
							JOptionPane.WARNING_MESSAGE);
				}

			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		for (Component c : useFrame().getContentPane().getComponents()) {
			mainOuter = (JScrollPane) c;
		}
		ProductTableModel ptm = new ProductTableModel(List_Products.list_products,
				new String[] { "Code", "Name", "Price", "Quantity", "Sale" },
				new Class[] { String.class, String.class, Double.class, Integer.class, Integer.class });

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
		mainOuter.setViewportView(pro_main_panel);
	}
}
