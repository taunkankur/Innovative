package sem1.dsa.hw8;

public class BinarySearch {

	
	public static void main(String[] args) {
		int[] array={1,6,3,2,5,9,7,0};
		
	System.out.println(	new BinarySearch().searchMax(array, 0, array.length-1));
	}
	
	
int searchMax(int[] arry,int low,int high){
	
	if(low==high){
		return arry[low];
	}
	
	
	int midPoint=(low+high)/2;
	int max1=searchMax(arry, low, midPoint);
	int max2=searchMax(arry, midPoint+1, high);
	
	if (max1>max2)
	return max1;
	else
		return max2;
	
}
}
