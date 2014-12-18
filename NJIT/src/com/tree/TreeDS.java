package com.tree;

public class TreeDS {

	Node root;
	public static void main(String[] args) {
		TreeDS treeDS=new TreeDS();
		treeDS.addNode(50, "Ankur");
		treeDS.addNode(25, "Ankur");
		treeDS.addNode(15, "Ankur");
		treeDS.addNode(30, "Ankur");
		treeDS.addNode(75, "Ankur");
		treeDS.addNode(85, "Ankur");
		treeDS.addNode(65, "Ankur");
		
		treeDS.inOrderTraversal(treeDS.root);
	}
	
	public void addNode(int key, String name){
		
		Node node=new Node(key, name);
		
		Node refNode=root;
		Node focusNode;
		
		if(refNode==null)
			root=node;
		else{
			focusNode=refNode;
			while(true){
				
				if(key<focusNode.key){
				
					if(focusNode.leftNode!=null){
						refNode=focusNode;
						focusNode=focusNode.leftNode;
						
					}else{
						focusNode.leftNode=node;
						return;
					}
					
					
					
						
				}else{
					
					if(focusNode.rightNode!=null){
						refNode=focusNode;
						focusNode=focusNode.rightNode;
						
					}else{
						focusNode.rightNode=node;
						return;
					}
					
					
					
						
				}
			}
		}
	}
public void inOrderTraversal(Node focusNode){
		
		if(focusNode!=null){
			
			inOrderTraversal(focusNode.leftNode);
			
			System.out.println(focusNode.key+" AND "+focusNode.name);
			
			inOrderTraversal(focusNode.rightNode);
	
}}
}
