package com.dsa.app;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.dsa.files.List_Customer;
import com.dsa.files.List_Orders;
import com.dsa.files.List_Products;

import dsa2017.swing.SwingMainFrame;

@SuppressWarnings("serial")
public class ProtoMainFrame extends SwingMainFrame {
	protected ProtoMenuBar menuBar;
	protected JTextArea mainView;
	protected JScrollPane mainOuter;

	public ProtoMainFrame() {
		this.setLocation(50, 50);
		this.setSize(600, 700);
		this.setTitle("Sale Management System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.createMenuBar();
		this.createMainView();
	}

	private void createMenuBar() {
		menuBar = new ProtoMenuBar();
		menuBar.createMenuBar(this);
		menuBar.bind();
	}

	private void createMainView() {
		
		this.add(mainOuter = new JScrollPane(mainView = new JTextArea()));
		List_Products lp = new List_Products();
		List_Customer lc = new List_Customer();
		List_Orders lo = new List_Orders();
		mainView.setName("mainarea");
		//mainView.append("Hello ");
	}

	public void clearMainView() {
		mainView.setText("");
	}

	public void selectMainView() {
		mainView.selectAll();
	}

}
