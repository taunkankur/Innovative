package sem1.dsa.hw7;

public class Node {

	int data;
	public Node next=null;
	
	Node(int data){
		
		this.data=data;
	}
	
	public static void main(String[] args) {
		
		LinkedList linkedList=new LinkedList();
		
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(4);
		linkedList.insert(5);
		linkedList.insert(6);
		linkedList.reverse();
		linkedList.display();
	}
}
