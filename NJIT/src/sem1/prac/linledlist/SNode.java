package sem1.prac.linledlist;

public class SNode {

	
	int data;
	SNode next;
	
	
	
	public SNode(int data) {
		// TODO Auto-generated constructor stub
		
		this.data=data;
		
		
	}
	public static void main(String[] args) {
		
		
		SLinkedList linkedList=new SLinkedList();
		
		linkedList.insertFirst(1);
		linkedList.insertFirst(2);
		linkedList.insertFirst(3);
		linkedList.insertFirst(5);
		
		linkedList.insertLast(4);
		linkedList.insertAfter(8,3);
		
		linkedList.display();
		linkedList.insertBefore(9, 2);
		linkedList.display();
		linkedList.deleteLast();
		linkedList.display();
		linkedList.deleteFirst();
		linkedList.display();
		linkedList.deleteMiddle(9);
		linkedList.display();
		linkedList.reverse();
		linkedList.display();
		linkedList.deleteAfter(2);
		linkedList.display();
		linkedList.deleteBefore(3);
		linkedList.display();
		
	}
	
	
}
