package com.treebuilder;

public class TestClass {

	public static void main(String[] args) throws Exception{
		String path="C:\\Users\\Ankur\\git\\stupidstuff\\JenaApi\\src\\SecOntV2.owl";
		OntologyTreeBuilder ontologyTreeBuilder=new OntologyTreeBuilder(path);
		System.out.println(ontologyTreeBuilder.getJSONTree(false));
	}
}
