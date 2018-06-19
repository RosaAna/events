package controlador;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import modeloDAO.DevolucionDAO;

public class ModelTableDevoluciones  implements TableModel, TableModelListener{
	private  boolean cargar;

	
	
		
	private static String[] columnNames = {"DNI CLIENTE",
            "CODIGO PRODUCTO",
            "IMPORTE",
            "ESTADO",
            "FECHA"
            };
  
	 
	public static  Object[][] data =DevolucionDAO.listaData(new DevolucionDAO().getListaDevolucionPendienteRevision());
    public ModelTableDevoluciones() {
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
       // fireTableCellUpdated(row, col);
    }

	public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
	
	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void tableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub
		int row = e.getFirstRow(); //fila 
        int column = e.getColumn(); //columna
        ModelTableDevoluciones model = (ModelTableDevoluciones)e.getSource();
        String columnName = model.getColumnName(column);
        Object data = model.getValueAt(row, column);
        System.out.printf("Cambio en la fila %d, en la columna %d,"
        		+ " nuevo valor %S%n", row, column, data);
	}


	public static void setData(Object[][] data) {
	ModelTableDevoluciones.data=data;	// TODO Auto-generated method stub
		
	}
	
}
	

