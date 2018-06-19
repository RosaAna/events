package modelo;



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

	public class GenerarIncidenciaDevolucionesPDF {
	    private static final Font FUENTEBOL = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
	    private static final Font FUENTENORMAL= FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);    
	 
	    private static final Font subcategoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
	   
	    public void createPDF(File file, String texto, String ruta, String codigo ) {
	        try {
	            Document document = new Document();
	            try {

	                PdfWriter.getInstance(document, new FileOutputStream(file));

	            } catch (FileNotFoundException fileNotFoundException) {
	           	 JOptionPane.showMessageDialog(null,"No se ha encontrado la ruta al fichero","", JOptionPane.INFORMATION_MESSAGE); 
	               
	            }
	            document.open();
	            document.addTitle("Informe devoluciones");
	       
	             
	            Chunk chunk = new Chunk("Incidencias", FUENTEBOL);
	            Chapter chapter = new Chapter(new Paragraph(chunk), 1);
	            chapter.setNumberDepth(0);
	            chapter.add(new Paragraph("Producto: "+codigo, FUENTENORMAL));
	            Image image;
	            try {
	                image = Image.getInstance(ruta); 
	                image.setAlignment(Element.ALIGN_CENTER);
	                image.setWidthPercentage(10);
	                chapter.add(image);
	             
	                chapter.add(new Paragraph(texto, FUENTENORMAL));
	 
	      
	            } catch (IOException ex) {
	            	  JOptionPane.showMessageDialog(null,"No se ha localizado la ruta de la imagén","", JOptionPane.INFORMATION_MESSAGE);   
	                    
	            }
	            document.add(chapter);
	         
	            document.close();
	            JOptionPane.showMessageDialog(null, "Se ha creado el pdf de Incidencias","", JOptionPane.INFORMATION_MESSAGE);   
	            
	        } catch (DocumentException documentException) {
	        	  JOptionPane.showMessageDialog(null, "No se ha creado el pdf de Incidencias","", JOptionPane.INFORMATION_MESSAGE);   
	              
	        }
	    }
	 /* 
	    public static void main(String args[]) {
	        GenerarIncidenciaDevolucionesPDF generatePDFFileIText2 = new GenerarIncidenciaDevolucionesPDF();
	        generatePDFFileIText2.createPDF(new File("Incidencias2.pdf"), texto, ruta);
	    }
*/
}
