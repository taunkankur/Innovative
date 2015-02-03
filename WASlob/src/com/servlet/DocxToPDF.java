package com.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;



public class DocxToPDF {


	
	public static void main(String[] args) {
	
		new DocxToPDF().convertPdfToDocx("");
		
	}
	
	
	
	public void convertDocxToPdf(String filePath){
		try{
			InputStream in= new FileInputStream(new File(filePath+".docx"));
			XWPFDocument document = new XWPFDocument(in);
			PdfOptions options = PdfOptions.create();
			OutputStream out = new FileOutputStream(new File(filePath+".pdf"));
			PdfConverter.getInstance().convert(document, out, options);
		}catch(Exception ae){
			ae.printStackTrace();
		}
		
	}
	
	
	public void convertPdfToDocx(String filePath){
		try{
			InputStream in= new FileInputStream(new File("D:\\Personal\\Ankur_Taunk_Resume11"+".pdf"));
			XWPFDocument document = new XWPFDocument(in);
			PdfOptions options = PdfOptions.create();
			OutputStream out = new FileOutputStream(new File("D:\\Personal\\Ankur_Taunk_Resume11"+".docx"));
			PdfConverter.getInstance().convert(document, out, options);
		}catch(Exception ae){
			ae.printStackTrace();
		}
		
	}
}
