package com.resumegenerator.dynamic;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Generate_PDF_Dynamic {
	public static void main(String[] args) {
      
        try {
        	String FILE_NAME = "C:\\Users\\aarora208\\OneDrive - DXC Production\\Desktop\\Generate_PDF\\test_dynamic.pdf";
             Document document = new Document();
             PdfWriter.getInstance(document, new FileOutputStream(FILE_NAME));
             document.open();
             
             DBConnection obj_DBConnection = new DBConnection();
             Connection connection = obj_DBConnection.getConnection();
             PreparedStatement ps=null;
             ResultSet rs=null;
             
             String query = "select * from profile";
             ps=connection.prepareStatement(query);
             rs=ps.executeQuery();
            
             Paragraph p = new Paragraph();
             p.add("Text 1");
             p.setAlignment(Element.ALIGN_CENTER);
             document.add(p);
             
             while (rs.next()) {
                 Paragraph para= new Paragraph(rs.getString("email")+" "+rs.getString("designation")+" "+rs.getString("first_name")+ " "+rs.getString("last_name")+ " "+rs.getString("phone"));
                 document.add(para);
                 document.add(new Paragraph(" "));
                 
             }
             
             document.close();
             System.out.println("Done");
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
 }

