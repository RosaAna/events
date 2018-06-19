package controlador;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import modeloDAO.ParticipanteDAO;
import modeloDAO.PerdidasDAO;
import vista.SplitPan;
import vista.Vista;


@SuppressWarnings("serial")
public class ModelTableVentasParticipantes extends AbstractTableModel implements TableModelListener {

	private static String[] columnNames = {"DNI", "NOMBRE"};
	
	private static Object[][] datos = ParticipanteDAO.listaData(new ParticipanteDAO().getListaParticipantes());
	
	
	
	public ModelTableVentasParticipantes () {
		addTableModelListener(this);
	}

	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex < 3) {
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
	
	@Override
	public void tableChanged(TableModelEvent e) {
		
	}

	@Override
	public int getRowCount() {
		return datos.length;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return datos[rowIndex][columnIndex];
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	/**
	 * @return the columnNames
	 */
	public static String[] getColumnNames() {
		return columnNames;
	}

	/**
	 * @param columnNames the columnNames to set
	 */
	public static void setColumnNames(String[] columnNames) {
		ModelTableVentasParticipantes.columnNames = columnNames;
	}

	/**
	 * @return the data
	 */
	public static Object[][] getData() {
		return datos;
	}

	/**
	 * @param data the data to set
	 */
	public static void setData(Object[][] data) {
		ModelTableVentasParticipantes.datos = data;
	}
}
