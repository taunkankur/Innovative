package com.logic;

import java.io.StringWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.db.connection.*;

public class YoutubeVideoLogic {

	public static void main(String[] args) {
		System.out.println(new YoutubeVideoLogic().getXML("Confidentiality","at375"));
	}
	
	public String getXML(String className,String studentId) {
		try {
	Connection con=new SQLConnection().getConnection();
	  DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    Document doc = builder.newDocument();
	    Element results = doc.createElement("Results");
	    doc.appendChild(results);
	    
	
	    ResultSet rs=con.createStatement().executeQuery("select distinct * from classesvedio  where ClassName='"+className+"' and VedURL in (select VideoId from personalvideo where  ClassName='"+className+"' and StudentId='"+studentId+"') ");
		ResultSetMetaData rsmd = rs.getMetaData();
		 int colCount = rsmd.getColumnCount();
		 while (rs.next()) {
			 
		      Element row = doc.createElement("Row");
		      row.setAttribute("Pinned", "1");
		      results.appendChild(row);
		      for (int i = 1; i <= colCount; i++) {
		    	  //System.out.println(rsmd.getColumnName(i));
		        String columnName = rsmd.getColumnName(i);
		        Object value = rs.getObject(i);
		        Element node = doc.createElement(columnName);
		        node.appendChild(doc.createTextNode(value.toString()));
		        row.appendChild(node);
		      }
		    }

		 
		ResultSet rs1=con.createStatement().executeQuery("select distinct * from classesvedio  where ClassName='"+className+"' and VedURL not in (select VideoId from personalvideo where  ClassName='"+className+"' and StudentId='"+studentId+"')  ");
		ResultSetMetaData rsmd1 = rs1.getMetaData();
		 int colCount1 = rsmd1.getColumnCount();
		 while (rs1.next()) {
			 
		      Element row = doc.createElement("Row");
		      row.setAttribute("Pinned", "0");
		      results.appendChild(row);
		      for (int i = 1; i <= colCount1; i++) {
		    	  //System.out.println(rsmd.getColumnName(i));
		        String columnName = rsmd1.getColumnName(i);
		        Object value = rs1.getObject(i);
		        Element node = doc.createElement(columnName);
		        node.appendChild(doc.createTextNode(value.toString()));
		        row.appendChild(node);
		      }
		    }
		 
		 
		 
		 
		    DOMSource domSource = new DOMSource(doc);
		    TransformerFactory tf = TransformerFactory.newInstance();
		    Transformer transformer = tf.newTransformer();
		    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		    transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
		    StringWriter sw = new StringWriter();
		    StreamResult sr = new StreamResult(sw);
		    transformer.transform(domSource, sr);
		    con.close();
		    System.out.println(sw.toString());
		    return sw.toString();
		    
	} catch (Exception e) {
		// TODO Auto-generated catch block
		
		e.printStackTrace();
		
	}
		return "false";
}
	
	
	public int insertPinVideoData(String className, String studentId,String videoId){
		
		try{ 
			
			Connection con=new SQLConnection().getConnection();
		Statement  stmt = con.createStatement();
	      
	      String sql = "Insert into personalvideo values ('"+studentId+"','"+videoId+"','"+className+"')";
	     return stmt.executeUpdate(sql);
	      
		}catch(Exception ae){
			
		}
		
		return 0;
	}
	
	
	public int deletePinVideoData(String className, String studentId,String videoId){
		
		try{ 
			
			Connection con=new SQLConnection().getConnection();
		Statement  stmt = con.createStatement();
	      
	      String sql = "DELETE FROM personalvideo WHERE StudentId='"+studentId+"' AND ClassName='"+className+"' AND VideoId='"+videoId+"';";
	     return stmt.executeUpdate(sql);
	      
		}catch(Exception ae){
			
		}
		
		return 0;
	}
	
	
}
