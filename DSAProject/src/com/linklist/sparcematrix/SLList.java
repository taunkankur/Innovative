package com.linklist.sparcematrix;

public class SLList {

	
	Node headRow;
	Node headCol;
	int order;
	
	Node[] rowAryLst;
	Node[] colAryLst;
	
	public SLList(){
		
		headRow=null;
		headCol=null;
		
	}

	public SLList(int order){
		this.order=order;
		rowAryLst=new Node[order+1];
		colAryLst=new Node[order];
	}
	
	
void addNodePointer(Node newNode, int row, int col){
		
		if(rowAryLst[col-1]==null){
			
						rowAryLst[col-1]=newNode;
		}else{
			
			Node firstNode=rowAryLst[col-1];
			
			while(firstNode!=null){
				
				if(firstNode.colLink==null){
					
					firstNode.colLink=newNode;
					break;
				}
				firstNode=firstNode.colLink;
				
			}
		}
	}
	
	
public	void addColNode(double value, int row, int col){
		
		Node newNode=new Node(value,row,col);
		
		if(colAryLst[row-1]==null){
			colAryLst[row-1]=newNode;
			addNodePointer(newNode, row, col);
		}else{
			Node firstNode=colAryLst[row-1];
			
			while (firstNode!=null){
				if(firstNode.rowLink==null){
					firstNode.rowLink=newNode;
					addNodePointer(newNode, row, col);
					break;
				}
				firstNode=firstNode.rowLink;
			}
		}
		
	}
	


public void updateNodePointer(Node newNode,int row, int col){
	headCol=rowAryLst[col-1];
	
	while(headCol!=null){
		
		if(headCol.row>row){
			newNode.colLink=headCol;
			rowAryLst[col-1]=newNode;
			break;
			
		}else
		if(headCol.colLink==null && headCol.row!=row){
			
			newNode.colLink=headCol.colLink;
			headCol.colLink=newNode;
			break;
			
		}else 	if(headCol.colLink!=null && headCol.colLink.row>row){
			
			newNode.colLink=headCol.colLink;
			headCol.colLink=newNode;
			
			
			break;
		}
		
		headCol=headCol.colLink;
	}
	
}

public void updateNode(int data,int row,int col){
	
	headRow=colAryLst[row-1];
	
	int colCount=1;
	int rowCount=1;
	Node tempNodeRow=null;
	Node tempNodeCol=null;
	Node newNode;

	
	while(headRow!=null ){
		
		
		if(headRow.col==col){
			break;
		}else if(headRow.col>col){
			
			newNode=new Node(data, row, col);
			newNode.rowLink=headRow;
			colAryLst[row-1]=newNode;
			updateNodePointer(newNode, row, col);
			break;
			
		}else if(headRow.rowLink==null && headRow.col!=col){
			newNode=new Node(data, row, col);
			newNode.rowLink=headRow.rowLink;
			headRow.rowLink=newNode;
			updateNodePointer(newNode, row, col);
			break;
			
		}else  if(headRow.rowLink!=null && headRow.rowLink.col>col){
			newNode=new Node(data, row, col);
			newNode.rowLink=headRow.rowLink;
			headRow.rowLink=newNode;
			updateNodePointer(newNode, row, col);
			break;
		}
		
		headRow=headRow.rowLink;
	}
	
}
	
public void printData(){
	
	int sequence=1;
	
	for(int i=0;i<colAryLst.length;i++){
		
	while(colAryLst[i]!=null){
			
	
		if(colAryLst[i].col!=sequence){
			
			while((colAryLst[i].col-sequence)!=0){
				System.out.print("0.0"+"\t");
				sequence++;
			}
			
			System.out.print(colAryLst[i].value+"\t");
		}else
			System.out.print(colAryLst[i].value+"\t");
		
		
		sequence++;
		colAryLst[i]=colAryLst[i].rowLink;
	}
sequence=1;
	System.out.println("\n");
	}
	

}




public void printDataRow(){
	
	int sequence=1;
	
	for(int i=0;i<rowAryLst.length;i++){
		
	while(rowAryLst[i]!=null){
			
	
		if(rowAryLst[i].row!=sequence){
			
			while((rowAryLst[i].row-sequence)!=0){
				System.out.print("00.0"+"\t");
				sequence++;
			}
			
			System.out.print(rowAryLst[i].value+"\t");
		}else
			System.out.print(rowAryLst[i].value+"\t");
		
		
		sequence++;
		rowAryLst[i]=rowAryLst[i].colLink;
	}
sequence=1;
	System.out.println("\n");
	}
	

}

}
