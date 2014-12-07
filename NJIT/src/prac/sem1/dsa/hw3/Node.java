package prac.sem1.dsa.hw3;

public class Node {
	
	
	
	int data;
	Node next;
	
	
	Node(int data){
		
		this.data=data;
		
	}
	
public static void main(String[] args) {
	
	
	LinkedList linkedList=new LinkedList();
	
	linkedList.insert(1);
	linkedList.insert(2);
	linkedList.insert(3);
	linkedList.insert(4);
	linkedList.insert(5);
	
	linkedList.count();
//	linkedList.deleteLast();
//	linkedList.display();
	
//	linkedList.reverseLink();
	
//	linkedList.removeOddNodes();
	linkedList.display();
}	
	
}