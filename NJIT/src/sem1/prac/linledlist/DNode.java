package sem1.prac.linledlist;

public class DNode {

	int data;
	DNode next;
	DNode prev;

	public DNode(int data){
		
		this.data=data;
		
	}
	
	
	public static void main(String[] args) {
		DLinkedList linkedList=new DLinkedList();
		
		linkedList.insertFirst(3);
		linkedList.insertFirst(4);
		linkedList.insertFirst(5);
		linkedList.insertFirst(6);
		linkedList.insertFirst(7);
//		linkedList.display();
//		linkedList.insertLast(2);
//		linkedList.display();
//		linkedList.insertAfter(1, 2);
//		linkedList.display();
//		linkedList.insertBefore(9, 1);
//		linkedList.display();
//		linkedList.deleteFirst();
//		linkedList.display();
//		linkedList.deleteLast();
//		linkedList.display();
//		linkedList.deleteBefore(9);
//		linkedList.display();
//		linkedList.deleteAfter(5);
//		linkedList.display();
//		linkedList.delete(5);
		linkedList.display();
		linkedList.reverse();
		linkedList.display();
	
	}
	
}


