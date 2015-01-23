package com.logic;

import java.net.*;
import java.io.*;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.restapi.ontology.RestApiMethod;

public class SlideShareDataFetchLogic {
	public static long ts;
	public static String hash;
	private static org.apache.log4j.Logger log = Logger.getLogger(SlideShareDataFetchLogic.class);
	public static void main(String[] args) throws Exception {
		final String z;

		String api_key = "4w4sRJ4G";
		String secret_key = "lMZ68S5P";
		long ts = System.currentTimeMillis() / 1000L;
		System.out.println("ts \n" + ts);
		System.out.println("secret_key" + secret_key);
		System.out.println("In main hash=" + hash);
		// PropertyConfigurator.configure("C:\\Users\\Ankur\\git\\Innovative\\WSOntology\\WebContent\\WEB-INF\\log4j.properties");
		  
		log.info("frewr");
		
	//System.out.println(new SlideShareDataFetchLogic().getXML("Attack"));
	}

	public String SHA1(String secret_key, long ts) {
		try {
			String a = secret_key + ts;
			System.out.println(a);
			MessageDigest md = MessageDigest.getInstance("SHA1");
			md.update(a.getBytes());
			byte[] output = md.digest();

			hash = bytesToHex(output);

		} catch (Exception ae) {
			ae.printStackTrace();
		}
		return hash.toLowerCase();

	}

	public String bytesToHex(byte[] b) {
		char hexDigit[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		StringBuffer buf = new StringBuffer();
		for (int j = 0; j < b.length; j++) {
			buf.append(hexDigit[(b[j] >> 4) & 0x0f]);
			buf.append(hexDigit[b[j] & 0x0f]);
		}
		return buf.toString();
	}

	public String getXML(String queryString) {
	
		
		
		  String secret_key = "lMZ68S5P";
		  long  ts=System.currentTimeMillis()/1000L;  
		  String h=SHA1(secret_key, ts);
		  String urlSearch="https://www.slideshare.net/api/2/search_slideshows?q="+queryString+"&page=1&items_per_page=50&lang=**&sort=relevance&upload_date=any&fileformat=ppt&file_type=presentations&cc=1&cc_adapt=1&cc_commercial=1&api_key=4w4sRJ4G&hash="+h+"&ts="+ts+"";
		log.info(urlSearch);
		  URL url;
		HttpURLConnection conn;
		BufferedReader rd;
		String line;
		String result = "";
		try {
			url = new URL(urlSearch);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			rd = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			while ((line = rd.readLine()) != null) {
				result += line;
			}
			rd.close();
		}  catch (Exception e) {
			log.error("Exception"+e.getMessage());
			e.printStackTrace();
		}
	
		return result;
	}

}
