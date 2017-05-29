package com.dsa.module;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.text.NumberFormatter;

import com.dsa.files.List_Products;
import com.dsa.manager.Product_Manager;
import com.dsa.physical.Tab_Product;

public class Add_Product extends __BaseModule {
	protected JScrollPane mainOuter;
	private javax.swing.JLabel pro_code_label;
	private javax.swing.JLabel pro_name_label;
	private javax.swing.JLabel pro_price_label;
	private javax.swing.JLabel pro_quantity_label;
	private javax.swing.JLabel pro_sale_label;
	private javax.swing.JLabel pro_img_label;
	private javax.swing.JLabel clone;
	private javax.swing.JLabel warning;

	private javax.swing.JTextField pro_name_text;
	private javax.swing.JTextField pro_code_text;
	private javax.swing.JFormattedTextField pro_price_text;
	// private javax.swing.JTextField pro_quantity_text;
	private javax.swing.JFormattedTextField pro_sale_text;
	private javax.swing.JTextField pro_img_text;
	private javax.swing.JFormattedTextField pro_quantity_text;

	private javax.swing.JFileChooser fileChooser;
	private javax.swing.JPanel pro_main_panel;
	private javax.swing.JButton btn_img;
	private javax.swing.JButton btn_submit;
	private JViewport viewport;

	public Add_Product() {
		// useFrame().clearMainView();
		Dimension d = new Dimension(60, 20);
		viewport = new JViewport();
		NumberFormat format = new DecimalFormat("##########");
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(0);
		formatter.setMaximum(Integer.MAX_VALUE);
		formatter.setAllowsInvalid(false);
		formatter.setCommitsOnValidEdit(true);
		NumberFormat format2 = new DecimalFormat("########.0");
		NumberFormatter formatter2 = new NumberFormatter(format2);
		formatter2.setValueClass(Integer.class);
		formatter2.setMinimum(0);
		formatter2.setMaximum(Integer.MAX_VALUE);
		formatter2.setAllowsInvalid(false);
		formatter2.setCommitsOnValidEdit(true);
		// Label
		pro_code_label = new JLabel("Product Code");
		pro_name_label = new JLabel("Product Name");
		pro_price_label = new JLabel("Product Price");
		pro_quantity_label = new JLabel("Product Quantity");
		pro_sale_label = new JLabel("Product Sale");
		pro_img_label = new JLabel("Product Image");
		clone = new JLabel("");
		warning = new JLabel("");
		// TextFields
		pro_name_text = new JTextField();
		pro_name_text.setName("txtname");
		// pro_name_text.setPreferredSize(d);
		pro_code_text = new JTextField();
		pro_code_text.setName("txtcode");
		// pro_code_text.setPreferredSize(d);
		pro_price_text = new JFormattedTextField(formatter2);
		pro_price_text.setName("txtprice");
		pro_quantity_text = new JFormattedTextField(formatter);
		pro_quantity_text.setName("txtquantity");
		pro_sale_text = new JFormattedTextField(formatter);
		pro_sale_text.setName("txtsale");
		fileChooser = new JFileChooser();

		pro_main_panel = new JPanel();
		btn_submit = new JButton("Submit");
		btn_submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				add_product();

			}
		});

		btn_img = new JButton("Browse");
		btn_img.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				choose();

			}

		});
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		useFrame().clearMainView();
		Add_Product ap = new Add_Product();
		for (Component c : useFrame().getContentPane().getComponents()) {
			mainOuter = (JScrollPane) c;
			viewport = mainOuter.getViewport();
		}
		GroupLayout layout = new GroupLayout(pro_main_panel);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(pro_code_label)
						.addComponent(pro_name_label).addComponent(pro_price_label).addComponent(pro_quantity_label)
						.addComponent(pro_sale_label).addComponent(pro_img_label).addComponent(clone)
						.addComponent(clone))

				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(pro_code_text)
						.addComponent(pro_name_text).addComponent(pro_price_text).addComponent(pro_quantity_text)
						.addComponent(pro_sale_text).addComponent(btn_img).addComponent(btn_submit)
						.addComponent(warning)));
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(pro_code_label)
						.addComponent(pro_code_text))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(pro_name_label)
						.addComponent(pro_name_text))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(pro_price_label)
						.addComponent(pro_price_text))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(pro_quantity_label)
						.addComponent(pro_quantity_text))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(pro_sale_label)
						.addComponent(pro_sale_text))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(pro_img_label)
						.addComponent(btn_img))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(clone)
						.addComponent(btn_submit))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(clone)
						.addComponent(warning)));

		pro_main_panel.setLayout(layout);
		// pro_main_panel.add(btn_submit);

		viewport.add(pro_main_panel);

	}

	public void choose() {
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(btn_img);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			System.out.println("Selected file: " + selectedFile.getAbsolutePath());
		}
	}

	public void add_product() {
		// System.out.println(pro_code_text.getText());
		try {
			Product_Manager pm = new Product_Manager();
			Color c = Color.red;
			warning.setForeground(c);
			String pcode = pro_code_text.getText();
			String quantity = pro_quantity_text.getText();
			String sale = pro_sale_text.getText();
			String price = pro_price_text.getText();
			String pname = pro_name_text.getText();
			String alert = "";
			if (pcode.equals("")) {
				alert = "Code";
				warning.setText(alert + " can not be blanked");
			} else if (pname.equals("")) {
				alert = " Name";
				warning.setText(alert + " can not be blanked");
			} else if (quantity.equals("")) {
				alert = " Quantity";
				warning.setText(alert + " can not be blanked");
			} else if (sale.equals("")) {
				alert = " Sale";
				warning.setText(alert + " can not be blanked");
			} else if (price.equals("")) {
				alert = " Price";
				warning.setText(alert + " can not be blanked");
			} else {
				Tab_Product p = new Tab_Product();
				if (Integer.parseInt(sale) > Integer.parseInt(quantity)) {
					warning.setText("Sale can not greater than quantity");
				} else if (!pm.isCodeExist(pcode)) {
					p.setPcode(pcode);
					p.setQuantity(Integer.parseInt(quantity.replace(",", "")));
					p.setSale(Integer.parseInt(sale.replace(",", "")));
					p.setPrice(Double.parseDouble(price));
					p.setPro_name(pname);
					p.setPro_image_url("");
					warning.setText("Add successfully");
					List_Products.list_products.add(p);
				} else {
					warning.setText(pcode + " is already existed");
				}
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
			warning.setText("quantity must be numberic");
		}

	}

}
