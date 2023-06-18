package com.resumegenerator.resumepdf;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Generate_PDF {

	public static void main(String[] args) {
		
		try {
		String file_name="C:\\Users\\aarora208\\OneDrive - DXC Production\\Desktop\\Generate_PDF\\download.pdf";
		Document document=new Document();
		
		PdfWriter.getInstance(document, new FileOutputStream(file_name));
		document.open();
		
		 Paragraph para = new Paragraph("This is just testing");
         para.add("Text 1");
         para.setAlignment(Element.ALIGN_CENTER);
         document.add(para);
         
		
		  document.close();
          System.out.println("Done");
      } catch (Exception e) {
          e.printStackTrace();
      }    

	}

}
