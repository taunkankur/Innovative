/* Author : Ankur Taunk 
 * 
 * Date : 3, Nov 2014
 * Description : This Class has all the methods to do operations on Sparse Matrix.
 * 
 * Date : 20, Nov 2014
 * Description : Implemented Add/Subtract/Swap/Delete Method.
 * 
 * Date : 4, Dec 2014
 * Description : Implemented Automated Triangulate/Solve/isSolution functionality.
 * 
 */
public class SprseMatrix {

	private int order;
	private Node[] rowAryLst;
	private Node[] colAryLst;

	public SprseMatrix(int order) {
		this.order = order;
		rowAryLst = new Node[order + 1];
		colAryLst = new Node[order];
	}

	public SprseMatrix() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * This Method is called from insert Method to update all the pointers to
	 * the newly created node.
	 */
	private void addNodePointer(Node newNode, int row, int col) {

		if (rowAryLst[col - 1] == null)
			rowAryLst[col - 1] = newNode;
		else {

			Node firstNode = rowAryLst[col - 1];

			while (firstNode != null) {

				if (firstNode.colLink == null) {

					firstNode.colLink = newNode;
					break;
				}
				firstNode = firstNode.colLink;

			}
		}
	}

	/*
	 * This method is called from initialize method to initialize the Sparse
	 * Matrix.
	 */
	private void insertInitially(int row, int col, double value) {
		Node newNode = null;

		if (col == order + 1) // To add -1 to last column
			newNode = new Node(value, row, -1);
		else
			newNode = new Node(value, row, col);

		if (colAryLst[row - 1] == null) {
			colAryLst[row - 1] = newNode;
			addNodePointer(newNode, row, col);
		} else {
			Node firstNode = colAryLst[row - 1];

			while (firstNode != null) {
				if (firstNode.rowLink == null) {
					firstNode.rowLink = newNode;
					addNodePointer(newNode, row, col);
					break;
				}
				firstNode = firstNode.rowLink;
			}
		}

	}

	/*
	 * This method could be called form insert method. To update the pointers if
	 * a new node is added after the initialization of sparse matrix.
	 */
	private void updateNodePointer(Node newNode, int row, int col) {

		Node headCol;

		int colIndex;

		if (col == -1)
			colIndex = order;
		else
			colIndex = col - 1;

		headCol = rowAryLst[colIndex];

		if (headCol == null) {
			newNode.colLink = headCol;
			rowAryLst[col - 1] = newNode;

		}

		while (headCol != null) {

			if (headCol.row > row) {
				newNode.colLink = headCol;
				rowAryLst[colIndex] = newNode;
				break;

			} else if (headCol.colLink == null && headCol.row != row) {

				newNode.colLink = headCol.colLink;
				headCol.colLink = newNode;
				break;

			} else if (headCol.colLink != null && headCol.colLink.row > row) {

				newNode.colLink = headCol.colLink;
				headCol.colLink = newNode;

				break;
			}
			headCol = headCol.colLink;
		}

	}

	/*
	 * This method could be called, after the Sparse matrix have been
	 * initialized, then if we want to insert a node into this matrix.
	 */
	public void insert(int row, int col, Double data) {

		Node headRow;

		headRow = colAryLst[row - 1];

		Node newNode;

		while (headRow != null) {
			if (headRow.col == col) {
				break;
			}
			if (col == -1 && headRow.rowLink == null) {
				newNode = new Node(data, row, col);
				newNode.rowLink = headRow.rowLink;
				headRow.rowLink = newNode;
				updateNodePointer(newNode, row, col);
				break;
			} else if (col == order && headRow.rowLink.col == -1) {
				newNode = new Node(data, row, col);
				newNode.rowLink = headRow.rowLink;
				headRow.rowLink = newNode;
				updateNodePointer(newNode, row, col);
				break;
			} else if (headRow.col > col && col != -1) {

				newNode = new Node(data, row, col);
				newNode.rowLink = headRow;
				colAryLst[row - 1] = newNode;
				updateNodePointer(newNode, row, col);
				break;

			} else if (headRow.rowLink == null && headRow.col != col) {
				newNode = new Node(data, row, col);
				newNode.rowLink = headRow.rowLink;
				headRow.rowLink = newNode;
				updateNodePointer(newNode, row, col);
				break;

			} else if (col != -1 && headRow.rowLink != null
					&& (headRow.rowLink.col > col || headRow.rowLink.col == -1)) {
				newNode = new Node(data, row, col);
				newNode.rowLink = headRow.rowLink;
				headRow.rowLink = newNode;
				updateNodePointer(newNode, row, col);
				break;
			}
			headRow = headRow.rowLink;
		}

	}

	/* This method initializes the sparse matrix. */
	public SprseMatrix initialize(int order, String[] equ) {

		SprseMatrix sList = new SprseMatrix(order);

		for (int j = 0; j < equ.length; j++) {

			ParseString parseString = new ParseString()
					.findIndex(equ[j], order);

			for (int i = 0; i < parseString.getColum().size(); i++) {
				double coEfficient = parseString.getCoefString().get(i);
				int row = j + 1;
				int col = parseString.getColum().get(i);
				// By mistake if zero is in input coefficient, it is ignored
				if (coEfficient != 0 && col != order + 1)
					sList.insertInitially(row, col, coEfficient);
				else if (col == order + 1)
					sList.insertInitially(row, col, coEfficient);
			}
		}

		return sList;
	}

	/* This Method adds i to j multiplying c to i */
	public void addRow(int rowFirst, double constant, int rowSecond) {

		Node refNodeFirst = colAryLst[rowFirst - 1];
		Node refNodeSecond = colAryLst[rowSecond - 1];

		while (refNodeFirst != null && refNodeSecond != null) {

			if (refNodeFirst.col == -1 && refNodeSecond.col == -1) {
				double temp = refNodeFirst.value * constant;
				// refNodeSecond.value = refNodeSecond.value + temp;
				refNodeSecond.value = epsilonChek(refNodeSecond.value + temp);
				break;
			}
			if (refNodeFirst.col == refNodeSecond.col) {
				double temp = refNodeFirst.value * constant;
				if (refNodeSecond.value + temp == 0)
					deleteRow(refNodeSecond.row, refNodeSecond.col);
				else

					refNodeSecond.value = epsilonChek(refNodeSecond.value
							+ temp);
				if (!(refNodeSecond.col == -1))
					refNodeSecond = refNodeSecond.rowLink;
				if (!(refNodeFirst.col == -1))
					refNodeFirst = refNodeFirst.rowLink;
			} else if (refNodeFirst.col < refNodeSecond.col) {
				if (refNodeFirst.col != -1) {
					double temp = refNodeFirst.value * constant;
					insert(rowSecond, refNodeFirst.col, temp);
					refNodeFirst = refNodeFirst.rowLink;
				} else if (refNodeSecond.col != -1) {
					refNodeSecond = refNodeSecond.rowLink;
				}
				if (refNodeFirst.col == -1 && refNodeSecond.col == -1) {
					double temp = refNodeFirst.value * constant;
					if (refNodeSecond.value + temp == 0)
						deleteRow(refNodeSecond.row, refNodeSecond.col);
					else

						refNodeSecond.value = epsilonChek(refNodeSecond.value
								+ temp);
					break;
				}
			} else if (refNodeFirst.col > refNodeSecond.col) {
				if (refNodeSecond.col != -1) {
					refNodeSecond = refNodeSecond.rowLink;
				} else if (refNodeFirst.col != -1) {
					double temp = refNodeFirst.value * constant;
					insert(refNodeSecond.row, refNodeFirst.col, temp);
					refNodeFirst = refNodeFirst.rowLink;
				}
				if (refNodeFirst.col == -1 && refNodeSecond.col == -1) {
					double temp = refNodeFirst.value * constant;
					if (refNodeSecond.value + temp == 0)
						deleteRow(refNodeSecond.row, refNodeSecond.col);
					else

						refNodeSecond.value = epsilonChek(refNodeSecond.value
								+ temp);
					break;
				}
			}

		}

	}

	/* This Method subtracts i from j multiplying c to i */
	public void substractRow(int rowFirst, double constant, int rowSecond) {

		Node refNodeFirst = colAryLst[rowFirst - 1];
		Node refNodeSecond = colAryLst[rowSecond - 1];

		while (refNodeFirst != null && refNodeSecond != null) {

			if (refNodeFirst.col == -1 && refNodeSecond.col == -1) {
				double temp = refNodeFirst.value * constant;

				refNodeSecond.value = epsilonChek(refNodeSecond.value - temp);
				break;
			}
			if (refNodeFirst.col == refNodeSecond.col) {
				double temp = refNodeFirst.value * constant;
				if (refNodeSecond.value - temp == 0)
					deleteRow(refNodeSecond.row, refNodeSecond.col);
				else
					refNodeSecond.value = refNodeSecond.value - temp;

				if (!(refNodeSecond.col == -1))
					refNodeSecond = refNodeSecond.rowLink;
				if (!(refNodeFirst.col == -1))
					refNodeFirst = refNodeFirst.rowLink;
			} else if (refNodeFirst.col < refNodeSecond.col) {
				if (refNodeFirst.col != -1) {
					double temp = refNodeFirst.value * constant;
					insert(rowSecond, refNodeFirst.col, -temp);
					refNodeFirst = refNodeFirst.rowLink;
				} else if (refNodeSecond.col != -1) {
					refNodeSecond = refNodeSecond.rowLink;
				}
				if (refNodeFirst.col == -1 && refNodeSecond.col == -1) {
					double temp = refNodeFirst.value * constant;
					if (refNodeSecond.value - temp == 0)
						deleteRow(refNodeSecond.row, refNodeSecond.col);
					else

						refNodeSecond.value = epsilonChek(refNodeSecond.value
								- temp);
					break;
				}
			} else if (refNodeFirst.col > refNodeSecond.col) {
				if (refNodeSecond.col != -1) {
					refNodeSecond = refNodeSecond.rowLink;
				} else if (refNodeFirst.col != -1) {
					double temp = refNodeFirst.value * constant;
					insert(refNodeSecond.row, refNodeFirst.col, -temp);
					refNodeFirst = refNodeFirst.rowLink;
				}
				if (refNodeFirst.col == -1 && refNodeSecond.col == -1) {
					double temp = refNodeFirst.value * constant;
					if (refNodeSecond.value - temp == 0)
						deleteRow(refNodeSecond.row, refNodeSecond.col);
					else

						refNodeSecond.value = epsilonChek(refNodeSecond.value
								- temp);
					break;
				}
			}

		}

	}

	/*
	 * This Method is called from the deletRow method, to update the colum link
	 * after a particular node is being deleted.
	 */
	private void updateColLink(int row, int col) {

		int colIndex;

		if (col == -1)
			colIndex = order;
		else
			colIndex = col - 1;

		Node refNodeCol = rowAryLst[colIndex];

		while (refNodeCol != null) {

			if (refNodeCol.row == row) {
				rowAryLst[colIndex] = refNodeCol.colLink;
				break;
			} else if (refNodeCol.colLink.row == row) {
				refNodeCol.colLink = refNodeCol.colLink.colLink;
				break;

			}
			refNodeCol = refNodeCol.colLink;
		}
	}

	/* This method Deletes the node at Point i and j */
	public void deleteRow(int row, int col) {
		Node refNodeRow = colAryLst[row - 1];

		while (refNodeRow != null) {

			if (col == order + 1) {
				System.out.println("Can't delete Y colum");
				break;
			} else if (refNodeRow.col == col) {
				colAryLst[row - 1] = refNodeRow.rowLink;
				updateColLink(row, col);
				break;
			} else if (refNodeRow.rowLink != null
					&& refNodeRow.rowLink.col == col) {
				refNodeRow.rowLink = refNodeRow.rowLink.rowLink;
				updateColLink(row, col);
				break;
			}
			refNodeRow = refNodeRow.rowLink;
		}

	}

	/* Swaps the given First row with the second */
	public void swapRow(int rowFirst, int rowSecond) {

		Node refNodeFirst = colAryLst[rowFirst - 1];
		Node refNodeSecond = colAryLst[rowSecond - 1];

		int sequence = 1;
		while (refNodeFirst != null && refNodeSecond != null) {
			if (rowFirst == rowSecond)
				break;
			Node tempNodeFirsst = null;
			Node tempNodeSecond = null;
			if (refNodeFirst.col == refNodeSecond.col
					&& (refNodeFirst.col != -1 || refNodeSecond.col != -1)) {

				Node tempNode1 = refNodeFirst.rowLink;
				Node tempNode2 = refNodeSecond.rowLink;
				tempNodeFirsst = deleteReturnNode(refNodeFirst.row,
						refNodeFirst.col);
				tempNodeSecond = deleteReturnNode(refNodeSecond.row,
						refNodeSecond.col);

				int row = tempNodeSecond.row;
				int col = tempNodeSecond.col;

				tempNodeSecond.row = tempNodeFirsst.row;
				tempNodeSecond.col = tempNodeFirsst.col;

				tempNodeFirsst.row = row;
				tempNodeFirsst.col = col;

				updateNodeOld(tempNodeSecond.row, tempNodeSecond.col,
						tempNodeSecond);
				updateNodeOld(tempNodeFirsst.row, tempNodeFirsst.col,
						tempNodeFirsst);

				refNodeSecond = tempNode2;
				refNodeFirst = tempNode1;
			} else if (refNodeFirst.col > refNodeSecond.col
					&& refNodeSecond.col == sequence
					&& (refNodeFirst.col != -1 || refNodeSecond.col != -1)) {
				Node tempNode = refNodeSecond.rowLink;
				tempNodeSecond = deleteReturnNode(refNodeSecond.row,
						refNodeSecond.col);
				tempNodeSecond.row = refNodeFirst.row;
				updateNodeOld(tempNodeSecond.row, tempNodeSecond.col,
						tempNodeSecond);
				refNodeSecond = tempNode;

			} else if (refNodeFirst.col < refNodeSecond.col
					&& refNodeFirst.col == sequence
					&& (refNodeFirst.col != -1 || refNodeSecond.col != -1)) {
				Node tempNode = refNodeFirst.rowLink;
				tempNodeFirsst = deleteReturnNode(refNodeFirst.row,
						refNodeFirst.col);
				tempNodeFirsst.row = refNodeSecond.row;
				updateNodeOld(tempNodeFirsst.row, tempNodeFirsst.col,
						tempNodeFirsst);
				refNodeFirst = tempNode;

			}
			if (refNodeSecond.col == -1 && refNodeFirst.col != -1
					&& refNodeFirst.col == sequence) {
				Node tempNode = refNodeFirst.rowLink;
				tempNodeFirsst = deleteReturnNode(refNodeFirst.row,
						refNodeFirst.col);
				tempNodeFirsst.row = refNodeSecond.row;
				updateNodeOld(tempNodeFirsst.row, tempNodeFirsst.col,
						tempNodeFirsst);
				refNodeFirst = tempNode;

			}
			if (refNodeSecond.col != -1 && refNodeFirst.col == -1
					&& refNodeSecond.col == sequence) {
				Node tempNode = refNodeSecond.rowLink;
				tempNodeSecond = deleteReturnNode(refNodeSecond.row,
						refNodeSecond.col);
				tempNodeSecond.row = refNodeFirst.row;
				updateNodeOld(tempNodeSecond.row, tempNodeSecond.col,
						tempNodeSecond);
				refNodeSecond = tempNode;

			}
			if (refNodeFirst.col == -1 && refNodeSecond.col == -1) {

				tempNodeFirsst = deleteReturnNode(refNodeFirst.row,
						refNodeFirst.col);
				tempNodeSecond = deleteReturnNode(refNodeSecond.row,
						refNodeSecond.col);

				int row = tempNodeSecond.row;
				int col = tempNodeSecond.col;

				tempNodeSecond.row = tempNodeFirsst.row;
				tempNodeSecond.col = tempNodeFirsst.col;

				tempNodeFirsst.row = row;
				tempNodeFirsst.col = col;

				updateNodeOld(tempNodeSecond.row, tempNodeSecond.col,
						tempNodeSecond);
				updateNodeOld(tempNodeFirsst.row, tempNodeFirsst.col,
						tempNodeFirsst);

				break;
			}

			if (tempNodeFirsst == null && tempNodeSecond == null
					&& sequence == order + 1)
				break;
			sequence++;

		}

	}

	/*
	 * This method is used in Swap Row Method that deletes the node at a given
	 * position, which is then added at the swapped position. Thus, no new node
	 * is created in Swap logic
	 */
	private Node deleteReturnNode(int row, int col) {
		Node returnNode = null;
		Node refNodeRow = colAryLst[row - 1];
		;
		while (refNodeRow != null) {

			if (col == order + 1) {
				System.out.println("Can't delete Y colum");
				break;
			} else if (refNodeRow.col == col) {
				returnNode = refNodeRow;
				colAryLst[row - 1] = refNodeRow.rowLink;
				updateColLink(row, col);
				break;
			} else if (refNodeRow.rowLink != null
					&& refNodeRow.rowLink.col == col) {
				returnNode = refNodeRow.rowLink;
				refNodeRow.rowLink = refNodeRow.rowLink.rowLink;
				updateColLink(row, col);
				break;
			}
			refNodeRow = refNodeRow.rowLink;
		}
		return returnNode;
	}

	/*
	 * This method is called from Swap row method to update the Node that is
	 * being deleted and added at new position.
	 */
	private void updateNodeOld(int row, int col, Node oldNode) {

		Node headRow;

		headRow = colAryLst[row - 1];

		while (headRow != null) {
			if (headRow.col == col) {
				break;
			}
			if (col == -1 && headRow.rowLink == null) {
				oldNode.rowLink = headRow.rowLink;
				headRow.rowLink = oldNode;
				updateNodePointer(oldNode, row, col);
				break;
			} else if (headRow.col == -1) {
				oldNode.rowLink = headRow;
				colAryLst[row - 1] = oldNode;
				updateNodePointer(oldNode, row, col);
				break;

			} else if (col == order && headRow.rowLink.col == -1) {
				oldNode.rowLink = headRow.rowLink;
				headRow.rowLink = oldNode;
				updateNodePointer(oldNode, row, col);
				break;
			} else if (headRow.col > col && col != -1) {
				oldNode.rowLink = headRow;
				colAryLst[row - 1] = oldNode;
				updateNodePointer(oldNode, row, col);
				break;

			} else if (headRow.rowLink == null && headRow.col != col) {
				oldNode.rowLink = headRow.rowLink;
				headRow.rowLink = oldNode;
				updateNodePointer(oldNode, row, col);
				break;

			} else if (col != -1 && headRow.rowLink != null
					&& (headRow.rowLink.col > col || headRow.rowLink.col == -1)) {
				oldNode.rowLink = headRow.rowLink;
				headRow.rowLink = oldNode;
				updateNodePointer(oldNode, row, col);
				break;
			}
			headRow = headRow.rowLink;
		}

	}

	/* This method prints the sparse matrix. */
	public void output(int order) {

		for (int j = 0; j < order; j++) {
			Node refNode = colAryLst[j];
			int count = 0;
			for (int i = 0; i < order + 1; i++) {
				if (refNode != null && refNode.col == -1 && count == order)
					System.out.print(refNode.value + "\t");
				else if (refNode != null && refNode.col != i + 1)
					System.out.print("0.0\t");
				else if (refNode != null) {
					System.out.print(refNode.value + "\t");
					refNode = refNode.rowLink;
				}
				count++;
			}
			System.out.println("\n");
		}

	}

	/* Called from add and subtract method */
	private double epsilonChek(double value) {

		final double epsilon = 0.00000001;

		if (Math.abs(value) < epsilon)
			return 0.0;
		else
			return value;
	}

	/* Solves the Equation, thereby returning an array with solution of X */
	public double[] solve() {

		double[] solutionArray = new double[order];

		int count = 0;
		double firstValue = 0.0;
		double result = 0.0;
		double addedValue = 0.0;

		Node headRow = colAryLst[order - 1];

		for (int i = order - 1; i >= 0; i--) {
			count = i;
			headRow = colAryLst[i];

			if (headRow.rowLink.col == -1) {

				solutionArray[i] = headRow.rowLink.value / headRow.value;

			} else {

				firstValue = headRow.value;
				headRow = headRow.rowLink;
				while (headRow != null) {

					if (headRow.col == -1) {
						result = headRow.value;
						solutionArray[i] = (result - addedValue) / firstValue;

						break;
					} else {

						if (headRow.col == count + 2) {
							addedValue = addedValue
									+ (headRow.value * solutionArray[count + 1]);
							headRow = headRow.rowLink;
						}

						count++;
					}

				}
				addedValue = 0.0;
			}

		}
		return solutionArray;

	}

	/*
	 * Check if the solution provided by solve() is correct or not with the help
	 * of triangulated matrix.
	 */
	public boolean isSolution(double[] solutionArray) {
		double addedValue = 0.0;
		boolean isSolution = false;
		try {
			Node headRow = colAryLst[order - 1];

			for (int i = order - 1; i >= 0; i--) {

				headRow = colAryLst[i];

				if (headRow.rowLink.col == -1
						&& equalsEpsilon(headRow.rowLink.value,
								solutionArray[i] * headRow.value)) {
					 System.out.println("LHS = " + solutionArray[i] *
					 headRow.value+ " RHS = " + headRow.rowLink.value);
					isSolution = true;
				} else {

					while (headRow != null) {

						if (headRow.col == -1) {

							if (equalsEpsilon(headRow.value, addedValue)) {
								 System.out.println("LHS = " + addedValue+
								 " RHS = " + headRow.value);
								isSolution = true;
							}
							break;
						} else {
							addedValue = addedValue
									+ (headRow.value * solutionArray[headRow.col - 1]);

						}

						headRow = headRow.rowLink;

					}
					addedValue = 0.0;
				}

			}
		} catch (Exception ae) {
			isSolution = false;
			ae.printStackTrace();
		}
		return isSolution;

	}

	/*
	 * Extra Method - This can be used to double check the correctness of solution by
	 * equating value in Main equation
	 */
	public void isSolutionMainEquation(double[] solutionArray,
			String[] equationOne) {
		SprseMatrix sprseMatrix = new SprseMatrix().initialize(order,
				equationOne);
		double addedValue = 0.0;

		Node headRow = null;

		for (int i = 0; i < colAryLst.length; i++) {
			headRow = sprseMatrix.colAryLst[i];
			while (headRow != null) {

				if (headRow.col == -1) {

					if (equalsEpsilon(addedValue, headRow.value)) {
						System.out.println("LHS : " + addedValue + " RHS : "
								+ headRow.value);
					} else {
						System.out.println("Wrong Value");
					}

				} else {
					addedValue = addedValue
							+ (headRow.value * solutionArray[headRow.col - 1]);
				}
				headRow = headRow.rowLink;
			}
			addedValue = 0.0;
		}

	}

	/* This method automatically triangulates the matrix */
	public SprseMatrix triangulate() {

		double divideFactor = 0.0;
		double multiplyFactor = 0.0;
		for (int i = 0; i < colAryLst.length; i++) {

			divideFactor = getValueAt(i + 1, i + 1);
			if (divideFactor != 0)
				this.multiply(i + 1, (1 / divideFactor));
			else {
				for (int k = i + 1; k < colAryLst.length; k++) {
					this.swapRow(k, k + 1);
					divideFactor = getValueAt(i + 1, i + 1);
					if (divideFactor != 0) {
						this.multiply(i + 1, (1 / divideFactor));
						break;
					}
				}
			}

			for (int j = i + 1; j < colAryLst.length; j++) {
				multiplyFactor = getValueAt(j + 1, i + 1);
				if (multiplyFactor != 0)
					this.substractRow(i + 1, multiplyFactor, j + 1);

			}

		}

		return this;
	}

	/* Called from triangulate method to get value at specific node */
	public double getValueAt(int row, int col) {

		Node headRow = colAryLst[row - 1];
		double returnValue = 0.0;
		while (headRow != null) {

			if (headRow.col == col) {

				returnValue = headRow.value;
				break;
			}

			headRow = headRow.rowLink;
		}
		return returnValue;
	}

	/* Called from triangulate method */
	public void multiply(int row, double constant) {

		Node headRow = colAryLst[row - 1];
		while (headRow != null) {

			headRow.value = epsilonChek(headRow.value * constant);

			headRow = headRow.rowLink;
		}
	}

	/* Called from isSolution(x) method */
	public boolean equalsEpsilon(double a, double b) {
		final double EPSILON = 0.0000001;
		if (a == b)
			return true;
		return Math.abs(a - b) < EPSILON * Math.max(Math.abs(a), Math.abs(b));
	}
}
