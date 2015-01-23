package com.logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;

import com.restapi.ontology.RestApiMethod;



public class DBLPDataFetchLogic {
	
	private static org.apache.log4j.Logger log = Logger.getLogger(DBLPDataFetchLogic.class);
	
	  public String getXML(String queryString) {
		  String dblpUrl = "http://www.dblp.org/search/api/?q="+ queryString+"&h=50&c=4&f=0&format=xml";
		  log.info("DBLP URL : "+dblpUrl);
	      URL url;
	      HttpURLConnection conn;
	      BufferedReader rd;
	      String line;
	      String result = "";
	      try {
	         url = new URL(dblpUrl);
	         conn = (HttpURLConnection) url.openConnection();
	         conn.setRequestMethod("GET");
	         rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	         while ((line = rd.readLine()) != null) {
	            result += line;
	         }
	         rd.close();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      try {
//			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      log.info("DBLP Response : "+result);
	      return result;
	   }

	   public static void main(String args[])
	   {
		   DBLPDataFetchLogic c = new DBLPDataFetchLogic();
	     System.out.println(c.getXML("https://www.slideshare.net/api/2/search_slideshows?q=ontology&api_key=4w4sRJ4G&ts=1415918696&hash=d8b93463481dec4bd1cb48284136fb7519c63b2e"));
	   }
}
