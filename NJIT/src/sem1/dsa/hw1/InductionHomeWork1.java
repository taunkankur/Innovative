package sem1.dsa.hw1;

import java.util.Arrays;

public class InductionHomeWork1 {

	
	public static void main(String[] args) {
		int[] a1=new int[6];
		a1[0]=2;
		a1[1]=4;
		a1[2]=7;
		a1[3]=10;
		a1[4]=14;
				
		int[] a2=new int[6];
		a2[0]=6;
		a2[1]=7;
		a2[2]=8;
		a2[3]=9;
		a2[4]=10;
		
		int[] a3=new int[6];
		a3[0]=2;
		a3[1]=5;
		a3[2]=7;
		a3[3]=10;
		a3[4]=11;
		
		int[] a4=new int[1];
		
		new InductionHomeWork1().Insert(a1, 5, 5);
		new InductionHomeWork1().Insert(a2, 5, 2);
		new InductionHomeWork1().Insert(a3, 5, 4);
		new InductionHomeWork1().Insert(a4, 0, 2);
	}
	
	public void Insert(int[] array, int numberOfIntegers, int numberToInsert){
		
		int temp=numberOfIntegers;
		
		while (temp>0 && numberToInsert<array[temp-1]){
			array[temp]=array[temp-1];
			temp=temp-1;
		}
		
		array[temp]=numberToInsert;
		numberOfIntegers=numberOfIntegers+1;
		
		System.out.println(Arrays.toString(array));
	}
}
