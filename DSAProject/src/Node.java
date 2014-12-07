/* Author : Ankur Taunk | Date : 3, Nov 2014
 * 
 * This Class is used for describing actual Data Structure.
 *  
 */
public class Node {

	int row;
	int col;
	double value;
	Node rowLink;
	Node colLink;

	Node(double value, int row, int col) {

		this.value = value;
		this.row = row;
		this.col = col;
		this.rowLink = null;
		this.colLink = null;
	}

}
