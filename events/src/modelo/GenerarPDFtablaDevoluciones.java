package modelo;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import java.io.*;

import javax.swing.JOptionPane;
import javax.swing.JTable; 


public class GenerarPDFtablaDevoluciones {
    // Fonts 
    private static final Font categoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static final Font blueFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);    
	private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
    private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);    
 
    private static final Font subcategoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
   
    public void crearPDF(File ruta, JTable table) {
    	
    	
    try {
            Document document = new Document();
            try {

                PdfWriter.getInstance(document, new FileOutputStream(ruta));

            } catch (FileNotFoundException fileNotFoundException) {

           	 JOptionPane.showMessageDialog(null,"No se ha encontrado la ruta al fichero","", JOptionPane.INFORMATION_MESSAGE); 
            }
            
            document.open();
            document.addTitle("Informe Tabla devoluciones");
            document.addCreator("Rosa");
       
            PdfPTable miTabla = new PdfPTable(table.getColumnCount());

            // Coloca los nombres de las columnas del jtable
            for (int i = 0; i < table.getColumnCount(); i++) {
                miTabla.addCell(table.getColumnName(i));
            }
            //Rellena los datos de las filas de la jtable
            for (int rows = 0; rows < table.getRowCount(); rows++) {
                for (int cols = 0; cols < table.getColumnCount(); cols++) {
                miTabla.addCell(table.getModel().getValueAt(rows, cols).toString());
                }
            }
            document.add(miTabla);
            document.close();
              JOptionPane.showMessageDialog(null, "Se ha creado el pdf de datos tabla devoluciones","", JOptionPane.INFORMATION_MESSAGE);   
      
            
        } catch (DocumentException documentException) {
        	 JOptionPane.showMessageDialog(null, "No se ha creado el pdf de datos de tabla devoluciones","", JOptionPane.INFORMATION_MESSAGE);   
           
        }
    }
 /* 
    public static void main(String args[]) {
        GenerarPDF gp = new GenerarPDF();
        gp.createPDF(new File("archivo.pdf"));
    }
    */
}
