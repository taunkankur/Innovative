package com.linklist.sparcematrix;

public class Node {

	int row;
	int col;
	double value;
	Node rowLink;
	Node colLink;
	
	Node(double value,int row,int col){
		
		this.value=value;
		this.row=row;
		this.col=col;
	}
	
	public static void main(String[] args) {
		
		SLList sList=new SLList(4);
		
//		sList.addRowNode(10, 1, 1);
//		sList.addRowNode(11, 2, 1);
//		sList.addRowNode(12, 3, 1);
		
		
//		sList.addColNode(10, 1, 1);
//		sList.addColNode(11, 1, 2);
//		sList.addColNode(12, 1, 3);
//		sList.addColNode(1, 1, 4);
//		sList.addColNode(13, 2, 1);
//		sList.addColNode(14, 2, 2);
//		sList.addColNode(15, 2, 3);
//		sList.addColNode(2, 2, 4);
//		sList.addColNode(16, 3, 1);
//		sList.addColNode(17, 3, 2);
//		sList.addColNode(18, 3, 3);
//		sList.addColNode(3, 3, 4);
	
//		sList.updateNode(9, 3, 1);
	
		
		sList.addColNode(3, 1, 1);
		sList.addColNode(5, 1, 5);
		sList.addColNode(2, 2, 2);
		sList.addColNode(-1, 2, 3);
		sList.addColNode(-1, 2, 5);
		sList.addColNode(5, 3, 1);
		sList.addColNode(-3, 3, 2);
		sList.addColNode(-10, 3, 5);
		sList.addColNode(-6, 4, 1);
		sList.addColNode(6, 4, 2);
		sList.addColNode(7, 4, 3);
		sList.addColNode(-5, 4, 4);
		sList.addColNode(-5, 4, 5);
		
//		sList.addColNode(-3, 1,1 );
//		sList.addColNode(16, 1,3 );
//		sList.addColNode(3, 2,1 );
//		sList.addColNode(2, 2,2 );
//		sList.addColNode(-1, 3,1 );
//		sList.addColNode(-2, 3,2 );
//		sList.addColNode(-1, 3,3 );
//		sList.addColNode(1, 4,2 );
//		sList.addColNode(2, 4,3 );
//		sList.addColNode(10, 4,4 );
//		sList.addColNode(2, 5,2 );
//		sList.addColNode(1, 5,6 );
//		sList.addColNode(8, 6,4 );
//		sList.addColNode(3, 6,6 );
		
		sList.printData();
		sList.printDataRow();
		
	
	}
}
