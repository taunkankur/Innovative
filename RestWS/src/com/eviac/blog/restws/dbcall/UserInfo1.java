package com.eviac.blog.restws.dbcall; 







import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dbconnect.TestClass;
import com.eviac.blog.restws.GetRequest;
import com.owl.opeartion.OwlReader;








@Path("/api")
public class UserInfo1 {
	
	
	
	@Path("/video/{queryString}")
  // This method is called if TEXT_PLAIN is request
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String sayPlainTextHello(@PathParam("queryString") String queryString) {
	  System.out.println(queryString);
	   return new TestClass().getXML(queryString);
  }
  
	
	
	@Path("/article/{queryString}")
	  // This method is called if TEXT_PLAIN is request
	  @GET
	  @Produces(MediaType.TEXT_PLAIN)
	  public String sayPlainText(@PathParam("queryString") String queryString) {
		  System.out.println(queryString);
		   return new GetRequest().getHTML("http://www.dblp.org/search/api/?q="+queryString+"&h=100&c=4&f=0&format=xml");
	  }
	  

	@Path("/description/{queryString}")
	  // This method is called if TEXT_PLAIN is request
	  @GET
	  @Produces(MediaType.TEXT_PLAIN)
	  public String getDescription(@PathParam("queryString") String queryString) {
		queryString=queryString.replaceAll(" ", "");
		  System.out.println(queryString);
		   return new OwlReader().getOwlData(queryString.trim());
	  }
	
	
	@Path("/Book/{queryString}")
	  // This method is called if TEXT_PLAIN is request
	  @GET
	  @Produces(MediaType.TEXT_PLAIN)
	  public String getBookPage(@PathParam("queryString") String queryString) {
		queryString=queryString.replaceAll(" ", "");
		  System.out.println(queryString);
		   return new OwlReader().getBookPage(queryString.trim());
	  }
}

