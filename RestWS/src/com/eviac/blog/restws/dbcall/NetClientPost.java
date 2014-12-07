package com.eviac.blog.restws.dbcall;
 
import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;

import java.net.URL;
 
public class NetClientPost {
 
               
                public static void main(String[] args) {
 
                  try {
                               

                               	//URL url = new URL("http://localhost:8526/RestWS/rest/hello/hello1");
                               	//String input="hey";
                                //URL url = new URL("http://10.2.110.93:93/ConductorGateway/Conductor.Gateway.ConductorGateway.svc/ProcessGoal");
                	  			//URL url = new URL("http://10.4.35.112:88/ConductorGateway_BELLVIR_STUB/Conductor.Gateway.ConductorGateway.svc/ProcessGoal");
                	  			URL url = new URL("http://10.4.52.196:89/PortalService/DTVGateWay.svc/PROCESSDTVCALLDATA");
                	  			String input ="<?xml version=\"1.0\" encoding=\"UTF-8\"?><SingleServiceInteface><Header><VERSION>1.0</VERSION><CALLID>39de507e01e40051ad44000825a05f30</CALLID><APPLICATION>DTV_CVP</APPLICATION><CLIENT>DIRECTV</CLIENT></Header><State><STATE_NAME>GETDTVCALLDATA</STATE_NAME><DIALED_NUMBER>193995</DIALED_NUMBER></State><ActionLog/></SingleServiceInteface>";
                              //String input ="<SingleServiceInteface><Header><VERSION>1.0</VERSION><PROCESS>IVR_FLOW</PROCESS><APPLICATION>ASURION_IVR</APPLICATION><CULTURE>en-us</CULTURE><CLIENT>BellMobility</CLIENT><MDN>7772766801</MDN><CALL_MODE>A</CALL_MODE><CALLID>39f72a3e01e3e5919d90000825a05f30</CALLID><STATIC_FLAG>false</STATIC_FLAG><STATUS>SUCCESS</STATUS></Header><State><STATE_NAME>SEARCH_MDN</STATE_NAME><CAPTURED_DATA><MDN>7772766801</MDN></CAPTURED_DATA></State><ActionLog/></SingleServiceInteface>";
                              //String input="<SingleServiceInteface><Header><VERSION>1.0</VERSION><PROCESS>REPORTING</PROCESS><APPLICATION>ASURION_IVR</APPLICATION><CULTURE>en-us</CULTURE><CLIENT>BELLVIR</CLIENT><MDN> </MDN><CALL_MODE>A</CALL_MODE><CALLID>9f0b76c001e3e1a1b085000825a05f30</CALLID><STATIC_FLAG>false</STATIC_FLAG><STATUS>SUCCESS</STATUS><ERROR_DESCRIPTION/></Header><State><STATE_NAME>GET_INTERACTION</STATE_NAME><CAPTURED_DATA><RCD>150986</RCD><RCK>4224</RCK></CAPTURED_DATA></State><ActionLog/></SingleServiceInteface>";
                	  			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                                conn.setDoOutput(true);
                                conn.setRequestMethod("POST");
                                conn.setRequestProperty("Content-Type", "text/xml");
                               
 
                               
                               
                                
                                OutputStream os = conn.getOutputStream();
                                os.write(input.getBytes());
                                os.flush();
                               
                                System.out.println("HTTP code : "+ conn.getResponseCode());
               
 
                                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                               
                               
                               
                                String output;
                                
                                while ((output = br.readLine()) != null) {
                               
                                                System.out.println(output);
                                }
 
                                conn.disconnect();
 
                  } catch (Exception e) {
 
                                e.printStackTrace();
 
                  }
 
                }
 
}