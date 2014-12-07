package sem1.dsa.hw7;

public class LinkedList {
	
	Node head;
	
	public LinkedList() {
		// TODO Auto-generated constructor stub
		
		head=null;
	}
	
	
	void insert(int data){
		
		Node newNode=new Node(data);
		
		if (head==null){
			head=newNode;
			return;
		}else{
			
			newNode.next=head;
			head=newNode;
		}
			
					
	}
	
	
	void reverse(){
		
		Node tempNpde=head;
		
		while(tempNpde!=null){
			
			tempNpde=head.next;
			head.next=head;
			head=tempNpde;
			
			tempNpde=tempNpde.next;
		}
	}
	
	void display(){
		
		Node tempNode=head;
		
		while(tempNode!=null){
			System.out.println(tempNode.data);
			tempNode=tempNode.next;
		}
	}
}
