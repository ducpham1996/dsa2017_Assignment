package com.dsa.module;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dsa.files.List_Orders;
import com.dsa.physical.Tab_Order;

public class Display_Order extends __BaseModule {
	protected JScrollPane mainOuter;
	private javax.swing.JPanel order_main_panel;
	private javax.swing.JScrollPane scroll;
	private javax.swing.JTable table;
	private javax.swing.JLabel total;

	public Display_Order() {
		scroll = new JScrollPane();
		table = new JTable();
		total = new JLabel("");
		order_main_panel = new JPanel();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		total.setText("");
		total = new JLabel(List_Orders.order_list.size() +" rows");
		for (Component c : useFrame().getContentPane().getComponents()) {
			mainOuter = (JScrollPane) c;
		}
		DefaultTableModel model = new DefaultTableModel(new Object[0][0],
				new String[] { "C-Code", "P-Code", "Quantity" });
		for(Tab_Order o : List_Orders.order_list){
			Object[] obj = new Object[3];
			obj[0] = o.getCcode();
			obj[1] = o.getPcode();
			obj[2] = o.getQuantity();
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
	}
}
