package com.test.automation.uiAutomation.config;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFGenerator {
	
	public void writePDF() throws Exception{
		
		Document document = new Document();
		String FILE = "D:\\Automation Practice\\Automation Practice\\uiAutomation\\src\\main\\java\\com\\test\\automation\\uiAutomation\\reports\\sample.pdf";
		PdfWriter.getInstance(document, new FileOutputStream(FILE ));
		document.open();
		document.add(new Paragraph("hello"));
		document.add(new Paragraph("hi"));
		document.close();
	}
	public static void main(String args[]) throws Exception{
		PDFGenerator p = new PDFGenerator();
		p.writePDF();
	}
}
