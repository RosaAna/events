package modelo;

import java.awt.print.PrinterException;
import java.text.MessageFormat;

import javax.swing.JTable;

public class CrearPDF {
	GenerarLog lo;
  public void imprimirJTable(JTable table) {
	MessageFormat headerFormat=new MessageFormat("Relación de participantes Events Jaén");//Encabezado
	MessageFormat headerFooter=new MessageFormat("Event's Jaén, PinBravo S.L ");//Pie
	
	try {
		table.print(JTable.PrintMode.NORMAL, headerFormat, headerFooter);
	} catch (PrinterException e) {
		// TODO Auto-generated catch block
		lo.generarLog("imprimirJTable", "no imprimida ");
	}
  }
}
