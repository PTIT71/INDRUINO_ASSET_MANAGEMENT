package com.asset.management.util;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.TextField;
import com.sun.javafx.geom.Rectangle;
 

public class TestMain {
	private final static String FILE = "D:/FilePdf.pdf";
	public static File fontFile = new File("fonts/vuArial.ttf");
	public static void makePDF() throws IOException{
	    try{    
	        Document document = new Document();
	        PdfWriter.getInstance(document, new FileOutputStream(FILE));
	        BaseFont bf = BaseFont.createFont(fontFile.getAbsolutePath(),BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
	        Font font = new Font(bf,15);
	        document.open();
	        Table tb = new Table(4);
	        tb.setPadding(3);
	        tb.addCell(new Paragraph("THỊNH LHUNG", font) );
	        document.add(tb);
	        document.add(new Paragraph("Đại học bách khoa Hà Nội", font)); 
	        document.close();
	    } catch (FileNotFoundException | DocumentException e) {
	        e.printStackTrace(System.out);
	    }}
	    /**
	     * Main method
	     * @param args no arguments needed
	     * @throws IOException
	     * @throws DocumentException
	     */
	    public static void main(String[] args) throws IOException, DocumentException {
	    	TestMain example = new TestMain();
	    	example.makePDF();
	    }
	
}
