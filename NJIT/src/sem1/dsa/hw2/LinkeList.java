package sem1.dsa.hw2;

public class LinkeList {

	
	public Link head;
	
	LinkeList(){
		head=null;
	}
	
	public boolean isEmpty(){
		
		return (head==null);
	}
	
	public void insertFirstLink(String bookName,int millionSold){
		
		Link newLink=new Link( bookName, millionSold);
		
		newLink.next=head;
		head=newLink;
	}
	
	public Link removeFirst(){
		
		Link linkRefefence=head;
		
		if(!isEmpty()){
			head=head.next;
		}else{
			System.out.println("Empty LinkedList");
		}
		
		return linkRefefence;
	}
	
	public void display(){
		
		Link theLink=head;
		
		while(theLink!=null){
			theLink.display();
			System.out.println("Next Link : "+theLink.next);
			theLink=theLink.next;
		}
		
	}
	
	
public int length(){
		
		Link theLink=head;
		int count=0;
		while(theLink!=null){
			count++;
			theLink=theLink.next;
		}
		return count;
	}
	
	public Link find(String bookName){
		Link theLink=head;
		
		if (!isEmpty()){
			while (theLink.bookName!=bookName){
				if(theLink.next==null){
					return null;
				}else{
					theLink=theLink.next;
				}
			}
		}else{
			System.out.println("Empty LinkedList");
		}
		
		return theLink;
	}
	
	
	public Link removeLink( String bookName) {
	
		Link currentLink=head;
		Link previousLink=head;
		
		while(currentLink.bookName!=bookName){
			if(currentLink.next==null){
				return  null;
			}else{
				previousLink=currentLink;
				currentLink=currentLink.next;
			}
		}
		
		if(currentLink==head){
			head=head.next;
		}else{
			previousLink.next=currentLink.next;
		}
return currentLink;
	}
	
	
	
}
