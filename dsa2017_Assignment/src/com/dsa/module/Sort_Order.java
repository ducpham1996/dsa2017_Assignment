package com.dsa.module;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dsa.array.SortUtils;
import com.dsa.files.List_Orders;
import com.dsa.physical.Tab_Order;


public class Sort_Order extends __BaseModule {
	protected JScrollPane mainOuter;
	private javax.swing.JPanel order_main_panel;
	private javax.swing.JScrollPane scroll;
	private javax.swing.JTable table;
	private javax.swing.JLabel total;

	public Sort_Order() {
		scroll = new JScrollPane();
		table = new JTable();
		total = new JLabel("");
		order_main_panel = new JPanel();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// Collections.sort(List_Orders.order_list, new Comparator<Tab_Order>()
		// {
		//
		// @Override
		// public int compare(Tab_Order o1, Tab_Order o2) {
		//
		// int i = o1.getCcode().compareTo(o2.getCcode());
		// if (i != 0) {
		// return i;
		// } else {
		// return o1.getPcode().compareTo(o2.getPcode());
		// }
		// // return 0;
		// }
		// });

		Object[] list = List_Orders.order_list.toArray();
		Arrays.sort(list);
		
//		Tab_Order[] orders = new Tab_Order[list.length]  ;
//		for(int i = 0; i< list.length;i++){
//			orders[i] = (Tab_Order) list[i];
//		}
//		insertionSort(list);
		total.setText("");
		total = new JLabel(List_Orders.order_list.size() + " rows");
		for (Component c : useFrame().getContentPane().getComponents()) {
			mainOuter = (JScrollPane) c;
		}
		DefaultTableModel model = new DefaultTableModel(new Object[0][0],
				new String[] { "C-Code", "P-Code", "Quantity" });
		for (Object o : list) {
			Object[] obj = new Object[3];
			obj[0] = ((Tab_Order) o).getCcode();
			obj[1] = ((Tab_Order) o).getPcode();
			obj[2] = ((Tab_Order) o).getQuantity();
			model.addRow(obj);
		}
		table.setModel(model);
		scroll.setViewportView(table);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(order_main_panel);
		order_main_panel.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(total).addComponent(scroll));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(scroll)
						.addContainerGap()));

		mainOuter.setViewportView(order_main_panel);

		JOptionPane.showMessageDialog(new JFrame(), "Sort Successfully", "Message", JOptionPane.INFORMATION_MESSAGE);
	}

	public void insertionSort(Object[] orders) {
		int in, out;

		for (out = 1; out < orders.length; out++) {
			Tab_Order temp = (Tab_Order) orders[out];
			in = out;

			while (in > 0 && ((Tab_Order) orders[in - 1]).getCcode().compareTo(temp.getCcode()) > 0) {
				orders[in] = orders[in - 1];
				--in;
			}
			orders[in] = temp;
		}
	}

}
