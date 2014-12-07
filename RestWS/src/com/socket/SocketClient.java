package com.socket;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;

public class SocketClient {

	
	public void connectToClient() {
		  
		try{
			Socket sock = new Socket("10.0.0.7", 9991);
		    byte[] mybytearray = new byte[1024000000];
		    InputStream is = sock.getInputStream();
		    FileOutputStream fos = new FileOutputStream("C:\\Users\\Ankur\\Desktop\\Book12.xlsx");
		    BufferedOutputStream bos = new BufferedOutputStream(fos);
		    int bytesRead = is.read(mybytearray, 0, mybytearray.length);
		    bos.write(mybytearray, 0, bytesRead);
		    bos.close();
		    sock.close();
			
		}catch(Exception ae){
			
			ae.printStackTrace();
		}
		  //scosket conncetion to shook to a server and port to read data
	    
	 
	}
	
}
