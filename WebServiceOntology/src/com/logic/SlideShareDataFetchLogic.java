package com.logic;

import java.net.*;
import java.io.*;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;



	public class SlideShareDataFetchLogic {	
		public static long ts;
		public static String hash;

		
		public static void main(String[] args) throws Exception {
			final String z;

			String api_key = "4w4sRJ4G";
			String secret_key = "lMZ68S5P";
			long ts=System.currentTimeMillis()/1000L;
			System.out.println("ts \n"+ts);
			System.out.println("secret_key"+secret_key);
//			hash=SHA1(secret_key, ts);
			System.out.println("In main hash="+hash);
		}
		
	public  String  SHA1(String secret_key, long ts) 
	{	try{
		String a= secret_key+ts;
	    	System.out.println(a);
	      MessageDigest md = MessageDigest.getInstance("SHA1");
	      
//	       String input = "a";
	       
	       md.update(a.getBytes()); 
	    	 byte[] output = md.digest();
//	       System.out.println();
//	       System.out.println("SHA1(\""+input+"\") =");
	       hash=bytesToHex(output);
	//       System.out.println(""+hash.toLowerCase());
//	       System.out.println("   "+bytesToHex(output));
		
	}catch(Exception ae){
		ae.printStackTrace();
	}
	return hash.toLowerCase();
	
	} 
	
	

	
	 public  String bytesToHex(byte[] b) 
	 {
	    char hexDigit[] = {'0', '1', '2', '3', '4', '5', '6', '7',
	                       '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	    StringBuffer buf = new StringBuffer();
	    for (int j=0; j<b.length; j++) {
	       buf.append(hexDigit[(b[j] >> 4) & 0x0f]);
	       buf.append(hexDigit[b[j] & 0x0f]);
	    }
	    return buf.toString();
	 }
	 public String getXML(String urlToRead) {
	      URL url;
	      HttpURLConnection conn;
	      BufferedReader rd;
	      String line;
	      String result = "";
	      try {
	         url = new URL(urlToRead);
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
	      return result;
	   }
	
	}
	 
	


