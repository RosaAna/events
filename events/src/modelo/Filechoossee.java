package modelo;



import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Filechoossee {
/*
	public static void main(String[] args) {
	

		System.out.println(darRuta());
	}
	
	*/
	public static String darRuta() {
	JButton open=new JButton();
	JFileChooser fc= new JFileChooser();
	fc.setCurrentDirectory(new java.io.File("c://Users/rosa/Desktop"));
	fc.setDialogTitle("II Event's Singel");
	fc.setFileSelectionMode(JFileChooser.APPROVE_OPTION);
	if(fc.showOpenDialog(open)==JFileChooser.APPROVE_OPTION) {
		
	}
	
	String ruta=fc.getSelectedFile().getAbsolutePath();
	return ruta;
	}

}
