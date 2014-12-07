package sem1.dsa.hw2;

public class Link {

	public String bookName;
	public int millionSold;
	
	public Link next;
	
	public Link(String bookName,int millionSold){
		
		this.bookName=bookName;
		this.millionSold=millionSold;
	}
	
	public void display(){
		
		System.out.println(bookName +" : "+millionSold);
	}
	
	public String toString() {
		return bookName;
	}
	
	
	public static void main(String[] args) {
		
		LinkeList theLinkeList=new LinkeList();
		
		theLinkeList.insertFirstLink("ankur", 500);
		theLinkeList.insertFirstLink("Taunk", 500);
		theLinkeList.insertFirstLink("romi", 500);
		theLinkeList.insertFirstLink("ckt", 500);
		theLinkeList.insertFirstLink("veeral", 500);
		theLinkeList.insertFirstLink("divya", 500);
		
		theLinkeList.display();
		System.out.println("**************************************************************************");
		System.out.println("Length : "+theLinkeList.length());
		System.out.println("**************************************************************************");
		theLinkeList.removeFirst();
		System.out.println("**************************************************************************");
		theLinkeList.display();
		System.out.println("**************************************************************************");
		System.out.println(theLinkeList.find("romi").bookName);
		System.out.println("**************************************************************************");
		System.out.println("Length : "+theLinkeList.length());
		System.out.println("**************************************************************************");
		theLinkeList.removeLink("ankur");
		System.out.println("**************************************************************************");
		System.out.println("Length : "+theLinkeList.length());
		System.out.println("**************************************************************************");
		theLinkeList.display();
		System.out.println("**************************************************************************");
		
	}
}
