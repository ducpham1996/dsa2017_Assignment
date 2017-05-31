package com.dsa.module;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.dsa.array.Linked_List;
import com.dsa.files.List_Products;
import com.dsa.physical.Tab_Product;
import com.dsa.tablemodel.ProductTableModel;

public class Sort_Product extends __BaseModule {
	protected JScrollPane mainOuter;
	private javax.swing.JPanel pro_main_panel;
	private javax.swing.JScrollPane scroll;
	private javax.swing.JTable table;
	// private javax.swing.JTextField search;
	private javax.swing.JButton btn_sort;
	private static List<Tab_Product> listp;

	public Sort_Product() {
		pro_main_panel = new JPanel();
		scroll = new JScrollPane();
		table = new JTable();
		btn_sort = new JButton("Sort Code");
		btn_sort.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Linked_List<Tab_Product> temp = List_Products.list_products;
				Tab_Product[] products = new Tab_Product[temp.size()];

				for (int i = 0; i < temp.size(); i++) {
					products[i] = temp.get(i);
				}
				insertionSort(products);
				temp = new Linked_List<>();
				for(Tab_Product p : products){
					temp.add(p);
				}
				ProductTableModel ptm = new ProductTableModel(temp,
						new String[] { "Code", "Name", "Price", "Quantity", "Sale" },
						new Class[] { String.class, String.class, Double.class, Integer.class, Integer.class });
				table.setModel(ptm);
			}
		});
		pro_main_panel = new JPanel();
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
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);

		List<RowSorter.SortKey> sortKeys = new ArrayList<>(List_Products.list_products.size());
		sortKeys.add(new RowSorter.SortKey(4, SortOrder.ASCENDING));
		sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
		sorter.setSortKeys(sortKeys);
		scroll.setViewportView(table);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(pro_main_panel);
		pro_main_panel.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup()
								// .addComponent(search,
								// javax.swing.GroupLayout.PREFERRED_SIZE, 500,
								// javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10,
										Short.MAX_VALUE)
								.addComponent(btn_sort, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(scroll));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								// .addComponent(search,
								// javax.swing.GroupLayout.PREFERRED_SIZE,
								// javax.swing.GroupLayout.DEFAULT_SIZE,
								// javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_sort))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(scroll)
						.addContainerGap()));
		// table.getColumnModel().getColumn(5).setCellRenderer(table.getDefaultRenderer(Boolean.class));
		mainOuter.setViewportView(pro_main_panel);
	}

	public static void insertionSort(Tab_Product[] products) {
		int in, out;

		for (out = 1; out < products.length; out++) {
			Tab_Product temp = products[out];
			in = out;
			while (in > 0 && products[in - 1].getPcode().compareTo(temp.getPcode()) > 0) {
				products[in] = products[in - 1];
				--in;
			}
			products[in] = temp;
		}
	}
}
