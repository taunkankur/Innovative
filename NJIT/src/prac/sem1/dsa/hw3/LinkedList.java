package prac.sem1.dsa.hw3;

public class LinkedList {

	
	Node head;
	
	public LinkedList() {
		// TODO Auto-generated constructor stub
	head=null;
	
	}

	void insert(int data){
		
		Node newNode=new Node(data);
		
		newNode.next=head;
		head=newNode;
		
	}
	
	
	void display(){
		
		Node refNode=head;
		
		while(refNode!=null){
			
			System.out.print(refNode.data + "->");
			
			refNode=refNode.next;
		}
		
		System.out.println("\n");
	}
	
	
	void deleteLast(){
		
		Node refNode=head;
		
		while(refNode.next!=null){
			
			if(refNode.next.next==null){
				refNode.next=null;
				break;
			}
			refNode=refNode.next;
			
		}
	}
	
	
	void reverseLink(){
		
		Node prev=null;
		Node next=null;
		
		Node temp=head;
		
		while(temp!=null){
			
			next=temp.next;
			temp.next=prev;
			prev=temp;
			temp=next;
			
			
		
		}
		head=prev;
	}
	
	void removeOddNodes(){
		
		int count=1;
		
		Node temp=head;
		
		if(head==null){
			head=null;
		}else{
			
			temp=head;
			head=temp.next;
			temp=temp.next;
			
			while(temp!=null){
				if(temp.next==null){
					break;
				}else{
					temp.next=temp.next.next;
					temp=temp.next;
				}
			}
		}
		
		
		
		
	}

	int count=1;
	void count(){
	
	
		Node temp=head;
		
	Node dataAtThree=null;
	
		
		while(temp!=null){
								
			
			if(count==3){
				temp.data=5;
			}			
			count++;
			
			temp=temp.next;
		}
temp=head;
System.out.println(count);

	
	
	for(int i=0;i<count-3;i++){
		temp=temp.next;
	}
	
	temp.data=40;

		
		
		
		System.out.println(count);
		
	}
	
	
	
	
}
