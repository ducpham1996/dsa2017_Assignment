package com.dsa.module;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.text.NumberFormatter;

import com.dsa.files.List_Customer;
import com.dsa.manager.Customer_Manager;
import com.dsa.physical.Tab_Customer;

public class Add_Customer extends __BaseModule {
	private JScrollPane mainOuter;
	private javax.swing.JLabel cus_code_label;
	private javax.swing.JLabel cus_name_label;
	private javax.swing.JLabel cus_phone_label;
	private javax.swing.JLabel clone;
	private javax.swing.JLabel warning;

	private javax.swing.JTextField cus_code_text;
	private javax.swing.JTextField cus_name_text;
	private javax.swing.JFormattedTextField cus_phone_text;

	private javax.swing.JPanel pro_main_panel;
	private javax.swing.JButton btn_submit;
	private JViewport viewport;

	public Add_Customer() {
		cus_code_label = new JLabel("Code");
		cus_name_label = new JLabel("Name");
		cus_phone_label = new JLabel("Phone Number");
		clone = new JLabel("");
		warning = new JLabel("");
		cus_code_text = new JTextField();
		cus_name_text = new JTextField();
		NumberFormat format = new DecimalFormat("##############");
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(0);
		formatter.setMaximum(Integer.MAX_VALUE);
		formatter.setAllowsInvalid(false);
		formatter.setCommitsOnValidEdit(true);
		cus_phone_text = new JFormattedTextField(formatter);
		btn_submit = new JButton("Submit");
		btn_submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				add_cus();
				
			}
		});
		pro_main_panel = new JPanel();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		for (Component c : useFrame().getContentPane().getComponents()) {
			mainOuter = (JScrollPane) c;
			viewport = mainOuter.getViewport();
		}
		GroupLayout layout = new GroupLayout(pro_main_panel);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(cus_code_label)
						.addComponent(cus_name_label).addComponent(cus_phone_label).addComponent(clone)
						.addComponent(clone))

				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(cus_code_text)
						.addComponent(cus_name_text).addComponent(cus_phone_text).addComponent(btn_submit)
						.addComponent(warning)));
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(cus_code_label)
						.addComponent(cus_code_text))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(cus_name_label)
						.addComponent(cus_name_text))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(cus_phone_label)
						.addComponent(cus_phone_text))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(clone)
						.addComponent(btn_submit))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(clone)
						.addComponent(warning)));

		pro_main_panel.setLayout(layout);
		viewport.add(pro_main_panel);
	}
	public void add_cus(){
		Color color = Color.red;
		warning.setForeground(color);
		String ccode = cus_code_text.getText();
		String cname = cus_name_text.getText();
		String cphone = cus_phone_text.getText();
		String alert = "";
		if(ccode.equals("")){
			alert = "Code";
			warning.setText(alert + " can not be blanked");
		}else if (cname.equals("")){
			alert = "Name";
			warning.setText(alert + " can not be blanked");
		}else if (cphone.equals("")){
			alert = "Phone";
			warning.setText(alert + " cann not be blanked");
		}else {
			warning.setText("Add succesful");
			Customer_Manager cm = new Customer_Manager();
			if(cm.isExist(ccode)){
				warning.setText("This code is existed");
			}else{
				Tab_Customer c = new Tab_Customer();
				c.setCcode(ccode);
				c.setCus_name(cname);
				c.setPhone(cphone);
				List_Customer.list_customers.push(c);
			}

		}
	}
}
