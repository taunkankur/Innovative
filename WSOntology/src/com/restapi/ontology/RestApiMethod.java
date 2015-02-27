package com.restapi.ontology;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.logic.*;

@Path("/api")
public class RestApiMethod {
	private static org.apache.log4j.Logger log = Logger.getLogger(RestApiMethod.class);
	

	@Path("/video/{queryString}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getVideoData(@PathParam("queryString") String queryString) {
		queryString = getSearchTerm(queryString).toString();
		String returnValue = new YoutubeVideoLogic().getXML(queryString,"at375");

		if (returnValue != null){
			log.info("Return Value : "+returnValue);
			return returnValue;
			}
		else{
			log.info(returnValue);
			return "false";
		}
			
	}
	
	
	

	@Path("/videoPin/{className}/{studentId}/{videoId}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String setVideoPin(@PathParam("className") String className,
			@PathParam("studentId") String studentId,
			@PathParam("videoId") String videoId) {

		return Integer.toString(new YoutubeVideoLogic().insertPinVideoData(
				className, studentId, videoId));
	}

	
	
	
	@Path("/videoUnPin/{className}/{studentId}/{videoId}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String setVideoUnPin(@PathParam("className") String className,
			@PathParam("studentId") String studentId,
			@PathParam("videoId") String videoId) {

		return Integer.toString(new YoutubeVideoLogic().deletePinVideoData(
				className, studentId, videoId));
	}

	
	
	
	@Path("/article/{queryString}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getArticleData(@PathParam("queryString") String queryString) {
		log.info("Query String : "+queryString);
		queryString = getSearchTerm(queryString).toString();
		String returnValue=new DBLPDataFetchLogic().getXML(queryString);
		log.info("Return Value : "+returnValue);
		return returnValue;
	}


	
	
	@Path("/description/{queryString}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getDescriptionData(@Context HttpServletRequest req,@PathParam("queryString") String queryString) {
		

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
		
		SlideShareDataFetchLogic slFetchLogic = new SlideShareDataFetchLogic();
		queryString = getSearchTerm(queryString).toString();
		log.info(queryString);
		
		String returnValue=slFetchLogic.getXML(queryString);
		log.info(returnValue);
		return returnValue;

	}

	
	
	
	public StringBuffer getSearchTerm(String searchterm) {
		String[] word = searchterm
				.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])");

		StringBuffer concatWord = null;
		for (String w : word) {
			if (null != concatWord) {
				concatWord.append("+");
				concatWord.append(w);
			} else 
				concatWord = new StringBuffer(w);
		}
		log.info("Returned Word : "+ concatWord);
		return concatWord;

	}
}
