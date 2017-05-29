package com.dsa.tablemodel;

import java.util.List;
import java.util.Set;

import javax.swing.table.AbstractTableModel;

import com.dsa.array.Stack;
import com.dsa.physical.Tab_Customer;
import com.dsa.physical.Tab_Product;

public class CustomerTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Stack<Tab_Customer> customerList;
	private final String[] columnNames;
	// = new String[] { "Code", "Name", "Price", "Quantity", "Sale", "" };

	private final Class[] columnClass;

	public CustomerTableModel(Stack<Tab_Customer> customerList, String[] columnNames, Class[] columnClass) {
		// super();
		this.customerList = customerList;
		this.columnNames = columnNames;
		this.columnClass = columnClass;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return customerList.size();
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return columnClass[columnIndex];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Tab_Customer c = customerList.get(rowIndex);
		if (0 == columnIndex) {
			return c.getCcode();
		} else if (1 == columnIndex) {
			return c.getCus_name();
		} else if (2 == columnIndex) {
			return c.getPhone();
		} else if (3 == columnIndex) {
			return c.getI();
		}
		return c;
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	public void removeRow(int row) {
		customerList.remove(row);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Tab_Customer row = customerList.get(rowIndex);
		if (0 == columnIndex) {
			row.setCcode((String) aValue);
		} else if (1 == columnIndex) {
			row.setCus_name((String) aValue);
		} else if (2 == columnIndex) {
			row.setPhone((String) aValue);
		} else if (3 == columnIndex) {
			row.setI((Boolean) aValue);
		}
	}

}
