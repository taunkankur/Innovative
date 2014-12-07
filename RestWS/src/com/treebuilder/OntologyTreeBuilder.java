
package com.treebuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.stream.FileImageInputStream;

import jena.owlsyntax;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.reasoner.structural.StructuralReasonerFactory;
/**
 *
 * @author MICKEL MANSOUR
 */
public class OntologyTreeBuilder {
    private static OWLOntologyManager  manager         = null;
    private final  OWLReasonerFactory  reasonerFactory;
    private final  OWLReasoner         reasoner;
    private final  OWLDataFactory      dataFactory;
    private static OWLOntology         ontology        = null;
    private static String              OntologyBase    = null;
    private final  ArrayList<OWLClass> TopClasses;
    private        int                 nodeCounter;
    private static String              JSONTree        = "";        
    
    
    //CONSTRUCTOR
    public OntologyTreeBuilder( String OWLFilePath ) throws OWLOntologyCreationException, FileNotFoundException{
        //GET MANAGER NEEDED TO LOAD ONTOLOGY AND CREATE THE OWL DATA FACTORY
        if(manager == null) manager = OWLManager.createOWLOntologyManager();
        InputStream is = new FileInputStream(OWLFilePath);
        //GET SECURITY ONTOLOGY FROM OWL FILE AND SAVE THE BASE IRI FOR LATER USE
        if(ontology == null) ontology = manager.loadOntologyFromOntologyDocument(is);
        if(OntologyBase == null) OntologyBase = ontology.getOntologyID().getOntologyIRI().toString() + "#";
        
        //GET OWL DATA FACTORY NEEDED FOR RETRIEVING OWL CLASSES BY IRI FROM ONTOLOGY
        dataFactory = manager.getOWLDataFactory();
        
        //GET REASONER NEEDED TO SEARCH ONTOLOGY FOR SUBCLASSES
        reasonerFactory = new StructuralReasonerFactory();
        reasoner = reasonerFactory.createNonBufferingReasoner(ontology);
        
        //INITIALIZE TopClasses ARRAY LIST AND nodeCounter
        TopClasses = new ArrayList<OWLClass>();
        nodeCounter = 1;
    }
    
    //METHOD THAT SHOULD BE CALLED TO RETIEVE A JSON STRING REPRESENTATION OF THE ONTOLOGY 
    public String getJSONTree( boolean newVersion ){
        //IF newVersion == FALSE, RETURN THE OLD VERSION IF IT EXISTS
        if ( !newVersion && !JSONTree.trim().isEmpty() )
            return JSONTree;
        
        //IF newVersion == TRUE OR FIRST VERSION IS NOT CREATED
        //CREATE TREE BUILDER
        StringBuilder ThingNodeChildren = new StringBuilder("");
        
        //GET AND STORE TOP CLASSES
        getTopOWLClasses();
        
        //GET CHILDREN OF EACH TOP CLASS
        for ( OWLClass Class : TopClasses ){
            if( !ThingNodeChildren.toString().trim().isEmpty() ){
                ThingNodeChildren.append( ", " );
            }
            ThingNodeChildren.append( getSubTree( Class ) );
        }

        JSONTree = createNewNode(dataFactory.getOWLThing(), "[" + ThingNodeChildren.toString() + "]", true);
        
        //FREE UNNEEDED RESOURCES FOR GARBAGE COLLECTOR TO COLLECT
        FreeUpResources();
        return JSONTree;
    }
    
    //METHOD SAVES CHILD CLASSES OF THING IN TopClasses ARRAY LIST
    private void getTopOWLClasses(){
        TopClasses.add( dataFactory.getOWLClass( IRI.create(OntologyBase, "Asset")) );
        TopClasses.add( dataFactory.getOWLClass( IRI.create(OntologyBase, "Threat")) );
        TopClasses.add( dataFactory.getOWLClass( IRI.create(OntologyBase, "Countermeasure")) );
        TopClasses.add( dataFactory.getOWLClass( IRI.create(OntologyBase, "Goal")) );
        TopClasses.add( dataFactory.getOWLClass( IRI.create(OntologyBase, "Model")) );
        TopClasses.add( dataFactory.getOWLClass( IRI.create(OntologyBase, "Product")) );
        TopClasses.add( dataFactory.getOWLClass( IRI.create(OntologyBase, "User")) );
        TopClasses.add( dataFactory.getOWLClass( IRI.create(OntologyBase, "Vulnerability")) );
        TopClasses.add( dataFactory.getOWLClass( IRI.create(OntologyBase, "AssetLifeCyclePhase")) );
        TopClasses.add( dataFactory.getOWLClass( IRI.create(OntologyBase, "DefenseStrategy")) );
      //TopClasses.add( dataFactory.getOWLClass( IRI.create(OntologyBase, "NaryRelation")) );
    }
    
    //METHOD RETURNS AN JSON STRING OF THE GIVEN OWL CLASS
    private String getSubTree( OWLClass clazz ){
        StringBuilder ChildrenArray = new StringBuilder("");
        
        for( OWLClass child : reasoner.getSubClasses(clazz, true).getFlattened()){
            //IGNORE ANONYMOUS CLASSES
            if ( child.isAnonymous() ) continue; 
            
            //ADD COMMA BEFORE NEW CHILD, UNLESS THIS IS FIRST CHILD
            if( !ChildrenArray.toString().trim().isEmpty() ){ 
                ChildrenArray.append(", ");
            }
            ChildrenArray.append( getSubTree( child ) );
        }
        
        //IGNORE CLASS Nothing
        if ( "Nothing".equals(getClassName(clazz)) ) return "";
        
        if( ChildrenArray.toString().trim().isEmpty() ){
            return createNewNode( clazz, "", false );
        }else{
            return createNewNode( clazz, "[" + ChildrenArray.toString() + "]", true);
        }
    }
            
    //METHOD CREATES NEW JSON FORMATTED NODE FOR THE GIVEN OWL CLASS
    private String createNewNode( OWLClass Clazz, String Children, boolean NodeOpen ){
       StringBuilder newNode = new StringBuilder("");
       //START NEW NODE HERE 
        newNode.append("{\n"); 
//            newNode.append("\"key\":\"x");newNode.append(nodeCounter);newNode.append("\",\n");  
        newNode.append("\"key\":\"");newNode.append(getClassName(Clazz).replaceAll(" ", ""));newNode.append("\",\n");
            newNode.append("\"isFolder\":"); newNode.append(NodeOpen); newNode.append(",\n"); 
            newNode.append("\"title\":\""); newNode.append( getClassName(Clazz) ); newNode.append("\"");

        if( !Children.trim().isEmpty() ){
           newNode.append(",\n\"children\":"); newNode.append(Children); 
        }

        newNode.append("\n}");
        nodeCounter++;
        return newNode.toString();
    }
    
    //METHOD USES IRI OF OWL CLASS TO GET ITS NAME
    private String getClassName(OWLClass clazz ){
        String clazzIRI = clazz.getIRI().toString();
        String clazzName= clazzIRI.substring( clazzIRI.indexOf("#") + 1 ).trim();
        
        //GET RID OF "_", IF IT EXISTS IN CLASS NAME
        if (clazzName.contains("_")) return StringProcessing.DivideString( clazzName.substring(1) );
        else return StringProcessing.DivideString( clazzName );
    }
    
    //METHOD FREES UN-NEEDED RESOURCES
    private void FreeUpResources(){
        reasoner.flush();
        reasoner.dispose();
        dataFactory.purge();
        TopClasses.clear();
    } 
}
