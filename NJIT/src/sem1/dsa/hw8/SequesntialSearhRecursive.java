package sem1.dsa.hw8;

import javax.sql.rowset.serial.SerialArray;

public class SequesntialSearhRecursive {

	
	
	
	public static void main(String[] args) {
		String[] strArray={"a","n","k","u","r"};
	System.out.println(	new SequesntialSearhRecursive().seqSearch(strArray,strArray.length,"u"));
	System.out.println(	new SequesntialSearhRecursive().seqSrchRecur(strArray,strArray.length,"u"));
		
	}
	
	
	
	int seqSrchRecur(String[] strArray, int length,String searchStr){
		
		if (length==0)
				return -1;
		else if (strArray[length-1]==searchStr)
				return length-1;
		else
			return seqSrchRecur(strArray, length-1, searchStr); 
	}
	
	int seqSearch(String[] strArray, int length,String searchStr){
		
		
		for (int i=length-1;i>=0;i--){
			
			if(strArray[i]==searchStr)
				return i;
		}
		
		return -1;
	}
}
