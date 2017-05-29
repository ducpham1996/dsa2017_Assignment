package com.dsa.tablemodel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.dsa.array.Linked_List;
import com.dsa.physical.Tab_Product;

public class ProductTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Linked_List<Tab_Product> productList;

	private final String[] columnNames;
	// = new String[] { "Code", "Name", "Price", "Quantity", "Sale", "" };

	private final Class[] columnClass;
	// = new Class[] { String.class, String.class, Double.class, Integer.class,
	// Integer.class, Boolean.class };

	public ProductTableModel(Linked_List<Tab_Product> productList, String[] columnNames, Class[] columnClass) {
		// super();
		this.productList = productList;
		this.columnNames = columnNames;
		this.columnClass = columnClass;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return columnClass[columnIndex];
	}

	public void removeRow(int row) {
		productList.removeAtIndex(row);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return productList.size();
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Tab_Product row = productList.get(rowIndex);
		if (0 == columnIndex) {
			row.setPcode((String) aValue);
		} else if (1 == columnIndex) {
			row.setPro_name((String) aValue);
		} else if (2 == columnIndex) {
			row.setPrice((Double) aValue);
		} else if (3 == columnIndex) {
			row.setQuantity((Integer) aValue);
		} else if (4 == columnIndex) {
			row.setSale((Integer) aValue);
		} else if (5 == columnIndex) {
			row.setI((Boolean) aValue);
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Tab_Product row = productList.get(rowIndex);
		if (0 == columnIndex) {
			return row.getPcode();
		} else if (1 == columnIndex) {
			return row.getPro_name();
		} else if (2 == columnIndex) {
			return row.getPrice();
		} else if (3 == columnIndex) {
			return row.getQuantity();
		} else if (4 == columnIndex) {
			return row.getSale();
		} else if (5 == columnIndex) {
			return row.getI();
		}
		System.out.println(row.toString());
		return row;
	}

}
