package sem1.prac.linledlist;

import java.lang.ProcessBuilder.Redirect;

import javax.xml.transform.Templates;

public class SLinkedList {

	SNode head;

	public SLinkedList() {
		// TODO Auto-generated constructor stub
		head = null;

	}

	void insertFirst(int data) {

		SNode refNode = new SNode(data);

		refNode.next = head;
		head = refNode;

	}

	void insertLast(int data) {

		SNode refNode = head;
		SNode newNode = new SNode(data);

		
		if(refNode==null){
			head=newNode;
			return;
		}
		while (refNode != null) {

			if (refNode.next == null) {

				newNode.next = refNode.next;
				refNode.next = newNode;
				break;

			}

			refNode = refNode.next;

		}

	}

	void insertAfter(int data, int afterData) {

		SNode refNode = head;
		SNode newNode = new SNode(data);

		while (refNode != null) {

			if (refNode.data == afterData) {

				newNode.next = refNode.next;
				refNode.next = newNode;
				break;
			}
			refNode = refNode.next;
		}

	}

	
	void insertBefore(int data,int deforeData){
		SNode refNode=head;
		SNode newNode = new SNode(data);
		while (refNode != null ) {

			
			if(refNode.data==deforeData){
			
				newNode.next=head;
				head=newNode;
				break;
			
			}else if (refNode.next!=null && refNode.next.data == deforeData) {
				newNode.next = refNode.next;
				refNode.next = newNode;
				break;
			}
			refNode = refNode.next;
		}
	}
	
	void deleteLast() {

		SNode refNode = head;

		while (refNode != null) {

			if (refNode.next.next == null) {

				refNode.next = null;
				break;
			}

			refNode = refNode.next;

		}
	}

	void display() {

		SNode refNode = head;

		while (refNode != null) {

			System.out.print(refNode.data);

			refNode = refNode.next;

		}

		System.out.println("\n");
	}

	void deleteFirst() {

		SNode refNode = head;

		head = refNode.next;
		refNode.next = null;
	}

	void deleteMiddle(int afterData) {

		SNode refNode = head;

		while (refNode != null) {

			if(refNode.next==null && refNode.data!=afterData){
				break;
			}else
			if (refNode.next.data == afterData) {

				refNode.next = refNode.next.next;

				break;
			} else if (refNode.data == afterData) {

				head = refNode.next;
				break;
			}
			refNode = refNode.next;

		}

	}

	
	
	void deleteAfter(int afterData){
		
		SNode refNode=head;
		
		while(refNode!=null){
			
			if(refNode.data==afterData && refNode.next!=null){
				refNode.next=refNode.next.next;
				break;
			}
			
			refNode=refNode.next;
		}
		
		
	}
	
	
void deleteBefore(int beforerData){
		
		SNode refNode=head;
		
		while(refNode!=null){
		
			if(refNode.data==beforerData || refNode.next==null){
				return;
			}
			if(refNode.next!=null && refNode.next.data== beforerData){
				head=refNode.next;
				break;
			}else	if(refNode.next.next!=null && refNode.next.next.data==beforerData ){
				refNode.next=refNode.next.next;
				
				break;
			}
			
			refNode=refNode.next;
		}
		
		
	}

	void reverse() {

		SNode front = null;
		SNode prev = null;

		SNode refNode = head;

		while (refNode != null) {

			front = refNode.next;
			refNode.next = prev;
			prev = refNode;
			refNode = front;

		}

		head = prev;
	}
}
