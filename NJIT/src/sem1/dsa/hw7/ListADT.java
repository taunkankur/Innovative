package sem1.dsa.hw7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListADT {

	static String[] array={"1", "2","3","4"};
	static List<String> list=new ArrayList<String>();
	static ListADT  listADT=	new ListADT();
	
	
	public static void main(String[] args) {

		
		
		int pFirst=listADT.first();
		int pLast=listADT.last();
		
		
listADT.reverse(pFirst, pLast);

//		while(pFirst!=pLast && pLast-pFirst!=1){
//		
//
//				list.add(array[pLast]);
//				array[pLast]=null;
//				pFirst++;
//				pLast--;
//				
//				if(pLast-pFirst==1){
//					
//					list.add(array[pLast]);
//					array[pLast]=null;}
//				
//				}
		
		for (String string : array) {
			
			System.out.print(string+"\t");
			
		}
		System.out.println("\n");
	for (String string : list) {
			
			System.out.print(string+"\t");
			
		}
	}


	
	void reverse(int pFirst, int pLast){
		
		
		
		
		 if(pLast-pFirst==1){
			listADT.swap(pFirst, pLast);
		return;
		}
		else{
			
		
		while(pFirst!=pLast && pLast-pFirst!=1){
			

			listADT.swap(pFirst, pLast);
			pFirst++;
			pLast--;
			
			reverse(pFirst, pLast);
			}
		
		}
	}
int first(){
	
		if (array.length == 0)
			return 0;
		else
			return 0;
}
	
int last(){
	
	if (array.length == 0)
		return 0;
	else
		return array.length-1;
}


void swap(int pFirst, int pLast){
	
	String temp=array[pFirst];
	array[pFirst]=array[pLast];
	array[pLast]=temp;
	
}

}
