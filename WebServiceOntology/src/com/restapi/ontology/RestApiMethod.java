package com.restapi.ontology;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.logic.*;


@Path("/api")
public class RestApiMethod {

	@Path("/video/{queryString}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getVideoData(@PathParam("queryString") String queryString) {

		return new YoutubeVideoLogic().getXML(queryString);
	}

	@Path("/article/{queryString}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getArticleData(@PathParam("queryString") String queryString) {

		String dblpUrl = "http://www.dblp.org/search/api/?q=" + queryString+ "&h=100&c=4&f=0&format=xml";
		return new DBLPDataFetchLogic().getXML(dblpUrl);
	}

	@Path("/description/{queryString}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getDescriptionData(@Context HttpServletRequest req,@PathParam("queryString") String queryString) {
		System.out.println(queryString.replaceAll(" ", ""));

		return new OwlReader().getOwlData(queryString.replaceAll(" ", ""));
	}

	@Path("/book/{queryString}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getBookData(@PathParam("queryString") String queryString) {

		return new OwlReader().getBookPage(queryString.replaceAll(" ", ""));
	}
	
	
	  @Path("/slides/{queryString}")
	  @GET
	  @Produces(MediaType.TEXT_PLAIN)
	  public String getSlideShareData(@PathParam("queryString") String queryString) {
		 SlideShareDataFetchLogic slFetchLogic= new SlideShareDataFetchLogic();
		  String secret_key = "lMZ68S5P";
		long  ts=System.currentTimeMillis()/1000L;  
		  String h=slFetchLogic.SHA1(secret_key, ts);
		  System.out.println("h=" +h);
		  System.out.println("ts="+ts);
          System.out.println(queryString);
	
 return  slFetchLogic.getXML("https://www.slideshare.net/api/2/search_slideshows?q="+queryString+"&page=1&items_per_page=50&lang=**&sort=relevance&upload_date=any&fileformat=all&file_type=all&cc=1&cc_adapt=1&cc_commercial=1&api_key=4w4sRJ4G&hash="+h+"&ts="+ts+"");
		
	  }
}
