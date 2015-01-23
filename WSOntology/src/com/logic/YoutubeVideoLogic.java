package com.logic;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.db.connection.*;

public class YoutubeVideoLogic {
	private static org.apache.log4j.Logger log = Logger.getLogger(YoutubeVideoLogic.class);
	public static void main(String[] args) {
		System.out.println(new YoutubeVideoLogic().getXML("Confidentiality","at375"));
	}
	
	public String getXML(String className,String studentId) {
		try {
	Connection con=new SQLConnection().getConnection();
	  
	    boolean isDataInDB=false;
	    
	    
	    if(con!=null){
	    	
	    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder builder = factory.newDocumentBuilder();
		    Document doc = builder.newDocument();
		    Element results = doc.createElement("Results");
		    doc.appendChild(results);
		    
		    
	    ResultSet rs=con.createStatement().executeQuery("select distinct * from classesvedio  where ClassName='"+className+"' and VedURL in (select VideoId from personalvideo where  ClassName='"+className+"' and StudentId='"+studentId+"') ");
	    isDataInDB=rs.next();
	    log.info(rs.next());
	    
	    if(isDataInDB){
	    	
	    
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
}
		 
		ResultSet rs1=con.createStatement().executeQuery("select distinct * from classesvedio  where ClassName='"+className+"' and VedURL not in (select VideoId from personalvideo where  ClassName='"+className+"' and StudentId='"+studentId+"')  ");
		isDataInDB=rs.next();
	    log.info(rs.next());
	    
	    if(isDataInDB){
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
	    }
		 
		 
	    if(isDataInDB){
		    DOMSource domSource = new DOMSource(doc);
		    TransformerFactory tf = TransformerFactory.newInstance();
		    Transformer transformer = tf.newTransformer();
		    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		    transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
		    StringWriter sw = new StringWriter();
		    StreamResult sr = new StreamResult(sw);
		    transformer.transform(domSource, sr);
		    log.info(sw.toString());
		    
		    return sw.toString();
		}
		    con.close();
	    }
		    if(!isDataInDB)
		    	return getDynamicVideo(className);
		    return null;
		    
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
	
	public String getDynamicVideo(String queryString){
		
		
		
		String youTubeUrl = "http://gdata.youtube.com/feeds/api/videos?q="+queryString+"+Security&v=2";
		  log.info("YouTubeDynamic URL : "+youTubeUrl);
	      URL url;
	      HttpURLConnection conn;
	      BufferedReader rd;
	      String line;
	      String result = "";
	      try {
	         url = new URL(youTubeUrl);
	         conn = (HttpURLConnection) url.openConnection();
	         conn.setRequestMethod("GET");
	         rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	         while ((line = rd.readLine()) != null) {
	            result += line;
	         }
	         log.info(result);
	         result=xmlTransformation(result);
	         rd.close();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      log.info(result);
		return result;
	}
	
	
	public String xmlTransformation(String xml){
		String result=null;
	    try {
            StringReader reader = new StringReader(xml);
            StringWriter writer = new StringWriter();
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer(
                    new javax.xml.transform.stream.StreamSource("C:\\Users\\Ankur\\git\\Innovative\\WSOntology\\src\\howto.xslt"));

            transformer.transform(
                    new javax.xml.transform.stream.StreamSource(reader), 
                    new javax.xml.transform.stream.StreamResult(writer));

             result = writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
	    
	    return result;
	}
	
}
