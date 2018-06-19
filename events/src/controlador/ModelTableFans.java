package controlador;

import java.util.List;

import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import modelo.FanDTO;
import modeloDAO.FansDAO;
import modeloDAO.ParticipanteDAO;




public class ModelTableFans extends AbstractTableModel implements TableModelListener{
List<FanDTO>listaFans;

	private static String[] columnNames = {"DNI",
            "NOMBRE",
            "SEXO",
            "EMAIL",
            "FECHA_NACIMIENTO",
            "PARTICIPA"};
	
	private static Object[][] datos = FansDAO.listaData(new FansDAO().getListaFans());
	
	public ModelTableFans() {
		addTableModelListener(this);
	}
	
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return datos.length;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return datos[rowIndex][columnIndex];
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columnNames[column];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex < 1) {
            return false;
        } else {
            return true;
        }
	}
	@Override
	public void setValueAt(Object value, int row, int col) {
        datos[row][col] = value;
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
        ModelTableFans model = (ModelTableFans)e.getSource();
        String columnName = model.getColumnName(column);
        Object data = model.getValueAt(row, column);
     /*   System.out.printf("Cambio en la fila %d, en la columna %d,"
        		+ " nuevo valor %S%n", row, column, data);*/
	}
	public static void setData(Object[][] datos) {
		// TODO Auto-generated method stub
			ModelTableFans.datos = datos;
		
	}
public static void setColunames(String[] columNames) {
	ModelTableFans.columnNames=columNames;
}

/**
 * @return the data
 */
public static Object[][] getData() {
	return datos;
}

		
}
