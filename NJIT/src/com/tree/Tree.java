package com.tree;

public class Tree {

	Node root;
	public static void main(String[] args) {
		
		Tree tree=new Tree();
		
		tree.addNode(50, "Ankur");
		tree.addNode(25, "Ankur");
		tree.addNode(15, "Ankur");
		tree.addNode(30, "Ankur");
		tree.addNode(75, "Ankur");
		tree.addNode(85, "Ankur");
		tree.addNode(65, "Ankur");
		
		tree.inOrderTraversal(tree.root);
	}
	
	public void addNode(int key,String name){
		
		Node newNode=new Node(key,name);
		
		if(root==null){root=newNode;}			
		else{
			Node focusNode=root;
			Node parent;
			
			while(true){
				parent=focusNode;
				
				if(key<focusNode.key){
					focusNode=focusNode.leftNode;
					if(focusNode==null){
						parent.leftNode=newNode;
								return;
					}
					
				}else{
					focusNode=focusNode.rightNode;
					if(focusNode==null){
						parent.rightNode=newNode;
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
		}
	}
}
