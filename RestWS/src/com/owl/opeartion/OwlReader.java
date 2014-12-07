package	 com.owl.opeartion;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

import com.hp.hpl.jena.util.FileManager;

import edu.stanford.smi.protege.exception.OntologyLoadException;
import edu.stanford.smi.protegex.owl.ProtegeOWL;
import edu.stanford.smi.protegex.owl.jena.JenaOWLModel;
import edu.stanford.smi.protegex.owl.model.OWLClass;
import edu.stanford.smi.protegex.owl.model.OWLDatatypeProperty;
import edu.stanford.smi.protegex.owl.model.OWLNamedClass;
import edu.stanford.smi.protegex.owl.model.RDFProperty;

public class OwlReader {
	
	static final String inputFileName = "C:\\Users\\Ankur\\git\\stupidstuff\\JenaApi\\src\\SecOntV2.owl";
	
	
	public static void main(String[] args) throws Exception{
	System.out.println(	new OwlReader().getOwlData("SmartCard"));
//		System.out.println(	new OwlReader().getBookPage("SmartCard"));
	}
public  String getOwlData(String queryString) {
	StringBuffer sBuffer = new StringBuffer();
	try {
		
	
	InputStream in = FileManager.get().open(inputFileName);
	JenaOWLModel owlModel =  ProtegeOWL.createJenaOWLModelFromInputStream(in);
	OwlReader owlReader=new OwlReader();
	OWLNamedClass cls=owlModel.getOWLNamedClass(queryString);


	
	


	sBuffer.append("<OwlRootNode>");
	

	
	
	String Des=owlReader. PrintDesc(cls,owlModel);
	sBuffer.append("<Description>"+Des+"</Description>");
	String NIST=owlReader.PrintNIST(cls,owlModel);
	sBuffer.append("<NistDef>"+NIST+"</NistDef>");

	 
	owlReader.getSuperClasses(cls,sBuffer);
	
	owlReader.getSubClasses(cls,sBuffer);
	
	owlReader.getEquivalentClasses(cls,sBuffer);
	//owlReader.getPageNumber(cls, sBuffer);
	sBuffer.append("</OwlRootNode>");
	in.close();
	owlModel.flushCache();
	owlModel.close();
	 }catch(Exception ae){
		ae.printStackTrace();
	}
	return sBuffer.toString();
}

public String PrintDesc(OWLNamedClass cls,JenaOWLModel owlModel) throws FileNotFoundException, OntologyLoadException{
	
	//JenaOWLModel owlModel =  ProtegeOWL.createJenaOWLModelFromInputStream(new FileInputStream(uri)); 
	RDFProperty description;
	
	
	
	description=owlModel.getRDFProperty("dc:description");
	
	String des="";    	
try{
	des=cls.getPropertyValue(description).toString() ;
}catch(Exception e){
	des="";
}
	
	return des ;
	
 	
 	
	
}

public String PrintNIST(OWLNamedClass cls,JenaOWLModel owlModel) throws FileNotFoundException, OntologyLoadException{
	
	//JenaOWLModel owlModel =  ProtegeOWL.createJenaOWLModelFromInputStream(new FileInputStream(uri)); 
	
	
	OWLDatatypeProperty hasNISTIRDef;
	
	
	hasNISTIRDef=owlModel.getOWLDatatypeProperty("hasNISTIRDef");
	
	String Nist="";
	
	try{
	  Nist=cls.getPropertyValue(hasNISTIRDef).toString();
          
	}
	catch(Exception e){
		Nist="";
	}
	
        List NISIR_DEF=new ArrayList<String>();
        int count =0; int j=0;
        for(int i=0;i<Nist.length(); i++){
            if(Nist.charAt(i)=='\n'){
                NISIR_DEF.add(Nist.subSequence(j, i));
                j=i+1;
            }
        }
        
        String New_NIST="";
        for(int i=0;i<NISIR_DEF.size();i++){
            String part1= NISIR_DEF.get(i).toString().substring(0,NISIR_DEF.get(i).toString().indexOf("SOURCE") ).replaceAll("\"", "");
            String part2=NISIR_DEF.get(i).toString().substring(NISIR_DEF.get(i).toString().indexOf("SOURCE") , NISIR_DEF.get(i).toString().length());
//            String part3="<a href='" + "http://nvlpubs.nist.gov/nistpubs/ir/2013/NIST.IR.7298r2.pdf" + "' target='" + "_blank" + "'>" + part2 + "</a>";
            New_NIST+=part1+part2;
        }
	return New_NIST;
	
 	
 	
	
}


public void getSuperClasses( OWLNamedClass cls,StringBuffer sBuffer){
	
	 Collection<OWLNamedClass> superClasses=cls.getNamedSuperclasses();
	 sBuffer.append("<SuperClass>");
	 for (Iterator<OWLNamedClass> t=superClasses.iterator(); t.hasNext();) {
     	OWLClass class1=(OWLClass) t.next();
          sBuffer.append(class1.getBrowserText()+"|");
		 
      

     }
	 sBuffer.append("</SuperClass>");
	 
	 
}

public void getEquivalentClasses( OWLNamedClass cls,StringBuffer sBuffer){
	
 Collection<OWLNamedClass> EquiClasses=cls.getEquivalentClasses();
 sBuffer.append("<EquivalentClass>");
	 for (Iterator<OWLNamedClass> t=EquiClasses.iterator(); t.hasNext();) {
     	OWLClass class1=(OWLClass) t.next();
          
     	sBuffer.append(class1.getBrowserText()+"|");
       

     }
	 sBuffer.append("</EquivalentClass>");
	
	 
}

public void getSubClasses( OWLNamedClass cls,StringBuffer sBuffer){
	
	 
Collection<OWLNamedClass> subClasses=cls.getNamedSubclasses(false);
sBuffer.append("<SubClass>");
	 for (Iterator<OWLNamedClass> t=subClasses.iterator(); t.hasNext();) {
     	OWLClass class1=(OWLClass) t.next();
          
     	sBuffer.append(class1.getBrowserText()+"|");
      

     }
	 sBuffer.append("</SubClass>");

	 
}



public  String getBookPage(String queryString) {
	StringBuffer sBuffer = new StringBuffer();
	try {
		
	
	InputStream in = FileManager.get().open(inputFileName);
	JenaOWLModel owlModel =  ProtegeOWL.createJenaOWLModelFromInputStream(in);
	OwlReader owlReader=new OwlReader();
	OWLNamedClass cls=owlModel.getOWLNamedClass(queryString);


	
	

	sBuffer.append("<OwlRootNode>");
	

	owlReader.getPageNumber(cls, sBuffer,queryString);
	sBuffer.append("</OwlRootNode>");
	
	 
	 }catch(Exception ae){
		ae.printStackTrace();
	}
	return sBuffer.toString();
}
public  void getPageNumber(OWLNamedClass cls,StringBuffer sBuffer,String queryString) {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder;
    Document doc = null;
    try {
        builder = factory.newDocumentBuilder();
        doc = builder.parse(inputFileName);
        XPathFactory xpathFactory = XPathFactory.newInstance();

        
        XPath xpath = xpathFactory.newXPath();

        String pageNumber;



        	  XPathExpression expr =xpath.compile("/*[local-name()='RDF']/"+queryString +"/hasPageNumbers/text()");
        	  pageNumber=expr.evaluate(doc, XPathConstants.STRING).toString();
        	 
        	  sBuffer.append("<BookPage>"+pageNumber+"</BookPage>");
        	//  System.out.println(sBuffer.toString());
        
    } catch (Exception e) {
        e.printStackTrace();
    }

}

}
