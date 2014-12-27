package com.linkedlist;

public class LinkedList {

	Node head;
	
	public static void main(String[] args) {
		
		
		LinkedList list=new LinkedList();
		
		list.addNodeLast(1);
		list.addNodeLast(2);
		list.addNodeLast(3);
		
		list.print();
	
	}
	
	public void addNodeLast(int value){
		
		Node refNode=head;
		Node newNode=new Node(value);
		
		if (refNode==null)
			refNode=newNode;
		else{
			
			while(refNode!=null){
				
				if(refNode.nextNode==null)
					refNode.nextNode=newNode;
					
				refNode=refNode.nextNode;
			}
		}
	}
	
	public void print(){
		
		Node refNode=head;
		
		while(refNode!=null){
			
			System.out.println(refNode.value);
			refNode=refNode.nextNode;
					
		}
		
	}
}
