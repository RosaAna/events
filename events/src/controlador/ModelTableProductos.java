package controlador;


import java.util.List;

import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import modelo.ParticipanteDTO;
import modelo.ProductoDTO;
import modeloDAO.FansDAO;
import modeloDAO.ParticipanteDAO;
import modeloDAO.ProductoDAO;

public class ModelTableProductos extends AbstractTableModel implements TableModelListener {
List<ProductoDTO> listaProductos;
JTable tablePo;
	private static String[] columnNames = {"CODIGO_PRODUCTO",
            "PRECIO",
            "CANTIDAD"
             };
	
	private static Object[][] data =ProductoDAO.listaData(new ProductoDAO().getListaProductosDisponibles());
	
		
	/**
	 * @return the tablePo
	 */
	public JTable getTablePo() {
		return tablePo;
	}


	public ModelTableProductos() {
		addTableModelListener(this);
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.length;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return data[rowIndex][columnIndex];
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columnNames[column];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex >=0) {
            return false;
        } else {
            return true;
        }
	}
	@Override
	public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
       fireTableCellUpdated(row, col);
    }
	

	public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

	@Override
	public void tableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub
		int row = e.getFirstRow(); //fila 
        int column = e.getColumn(); //columna
        ModelTableProductos model = (ModelTableProductos)e.getSource();
        String columnName = model.getColumnName(column);
        Object data = model.getValueAt(row, column);
        System.out.printf("Cambio en la fila %d, en la columna %d,"
        		+ " nuevo valor %S%n", row, column, data);
	}
	@Override
	public void addTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static void setData(Object[][] data) {
		// TODO Auto-generated method stub
			ModelTableProductos.data = data;
		
	}
	
}

