package com.stringparsing;

import com.linklist.sparcematrix.SLList;

public class Test {
public static void main(String[] args) {
	
	int order=4;
	
	String[] equ={"x2+2x4=8","2x2-7x3=5","5x1-3x2-10x4=-8","x2+2x4=1"};
	
//	String[] equ={"-3x2+16x3=6","3x1+2x3=-3","-x1-x2-x3=10","1x2+2x3+10x4=7","2x5+1x6=0","8x4+3x6=-1"};
	
//	String[] equ={"2x1-4x4+5x6=32","3x1+4x3+2x5+x7+8x8=31","x2+2x4+3x7=-7","x1+x4+2x5+2x8=10","-x1-2x2+5x8=8","x2+2x4+3x6=8","x3+2x5+x7+x8=8","x1-3x5+x8=-5"};
	SLList slList=new Test().initializeMatrix(order, equ);
	
//	slList.updateNode(-9, 1, 1);
	slList.printData();

	
}



SLList initializeMatrix(int order, String[] equ){
	
	
	SLList sList=new SLList( order);
	
	
	for(int j=0;j<equ.length;j++){
		
		
		ParseString parseString= new ParseString().findIndex(equ[j],order);

		
		for(int i=0;i<parseString.getColum().size();i++){
			
			sList.addColNode(parseString.getCoefString().get(i), j+1, parseString.getColum().get(i));
				
		}
		}
	
	
	return sList;
}
}
