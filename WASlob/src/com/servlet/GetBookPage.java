 package com.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import sun.text.normalizer.ReplaceableString;
import asposewobfuscated.s;

import com.aspose.words.Document;
import com.aspose.words.SaveFormat;
import com.aspose.words.SaveOutputParameters;
//import com.sun.org.apache.bcel.internal.generic.DADD;

/**
 * Servlet implementation class GetBookPage
 */
@WebServlet("/GetBookPage")
public class GetBookPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBookPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ResourceBundle rb2=null;
		HttpSession session=null;
		FileInputStream fileInputStream =null;
	try{
		
		String wordHighlight=request.getParameter("wordToHighlight");
		ResourceBundle rb1=ResourceBundle.getBundle("Environment");
        String environment = rb1.getString("ActiveEnvironment");
         rb2=ResourceBundle.getBundle(environment+"_Config");
		
         
	
		 session = request.getSession();
		Document doc = new Document(rb2.getString("BookPageDirectory")+wordHighlight.split("_")[1]);
		
        
        Pattern regex = Pattern.compile( getSearchTerm(wordHighlight.split("_")[0]).toString(), Pattern.CASE_INSENSITIVE);
       doc.getRange().replace(regex, new ReplaceEvaluatorFindAndHighlight(), false);
       

 
       String savedDoc=rb2.getString("TempPageDirectory")+session.getId()+rb2.getString("FileExtention");
     
       
        doc.save(savedDoc);
        System.out.println(savedDoc);
        SearchReplace sr = new SearchReplace(savedDoc); 
        sr.addSearchTerm("Evaluation Only. Created with Aspose.Words. Copyright 2003-2011 Aspose Pty Ltd.", ""); 
        
        sr.searchReplace();
        
        new DocxToPDF().convertDocxToPdf(rb2.getString("TempPageDirectory")+session.getId());
        
	
		File pdfFile = new File(rb2.getString("ReadFinalFileFrom")+session.getId()+".pdf");
		

		session.invalidate();
		response.setContentType(rb2.getString("ContentType"));
		response.addHeader("Content-Disposition", rb2.getString("ContentDescription") );
		response.setContentLength((int) pdfFile.length());

		fileInputStream = new FileInputStream(pdfFile);
		OutputStream responseOutputStream = response.getOutputStream();
		int bytes;
		while ((bytes = fileInputStream.read()) != -1) {
			responseOutputStream.write(bytes);
		}
		
	}catch(Exception ae){
		
		ae.printStackTrace();
	}finally{
		fileInputStream.close();
		File fileDocx = new File(rb2.getString("TempPageDirectory")+session.getId()+".docx");
		fileDocx.delete();
		File filePdf = new File(rb2.getString("TempPageDirectory")+session.getId()+".pdf");
		filePdf.delete();
		
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	public StringBuffer getSearchTerm(String searchterm) {
		String[] word = searchterm
				.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])");

		StringBuffer concatWord = null;
		for (String w : word) {
			if (null != concatWord) {
				concatWord.append(" ");
				concatWord.append(w);
			} else 
				concatWord = new StringBuffer(w);
		}
		
		System.out.println(concatWord);
		return concatWord;

	}
}
