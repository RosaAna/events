package modelo;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

import modeloDAO.PerdidasDAO;
import vista.Vista;


public class ColorearFilasJTable extends DefaultTableCellRenderer {
    

@Override
public Component getTableCellRendererComponent(JTable table, Object value, boolean Selected, boolean hasFocus, int row, int col){
   
super.getTableCellRendererComponent(table, value, Selected, hasFocus, row, col);
 Vista v= new Vista();
 PerdidasDAO pe= new PerdidasDAO();
 String dni=v.getSplitPan().getTable_SAperdidas().getValueAt(row, 1).toString();
    if (pe.totalPorCliente(dni)>2) {

         setBackground(Color.RED);

    } else if (pe.totalPorCliente(dni)==2){
    	
    	setBackground(Color.GRAY);
    	
    }else {
         setBackground(Color.LIGHT_GRAY);

    } 


 return this;


}



}

     