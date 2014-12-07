package com.eviac.blog.restws; 







import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;









public class UserInfo {
	@Path("/hello/{queryString}")
  // This method is called if TEXT_PLAIN is request
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String sayPlainTextHello(@PathParam("queryString") String queryString) {
	  System.out.println(queryString);
	   return new GetRequest().getHTML("http://www.dblp.org/search/api/?q="+queryString+"&h=100&c=4&f=0&format=xml");
  }
  
  @Path("/hello1")
  @POST
  @Produces(MediaType.TEXT_XML)
  @Consumes(MediaType.TEXT_XML)
 
  public String sayHello(String param1){
	  
	 
      
	  System.out.println("RequestParameter :"+param1);
	  return param1;
  }

}

