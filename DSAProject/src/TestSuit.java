/* Author : Ankur Taunk 
 * 
 * Date : 4, Dec 2014
 * Description : This class has individual implementation of logic for Test Case - Step 1/2/3.
 * 
 */

public class TestSuit {

	public void stepOneEqutionOne(String[] equationOne, int order) {
		SprseMatrix slList = new SprseMatrix().initialize(order, equationOne);
		System.out.println("Initial Matrix.\n");
		slList.output(order);
	}

	public void stepOneEqutionTwo(String[] equationTwo, int order) {
		SprseMatrix slList = new SprseMatrix().initialize(order, equationTwo);
		System.out.println("Initial Matrix.\n");
		slList.output(order);
	}

	public void stepOneEqutionThree(String[] equationThree, int order) {
		SprseMatrix slList = new SprseMatrix().initialize(order, equationThree);
		System.out.println("Initial Matrix.\n");
		slList.output(order);
	}

	public void stepTwoEquationOne(String[] equationOne, int order) {
		SprseMatrix slList = new SprseMatrix().initialize(order, equationOne);
		System.out
				.println("Add the last row multiplied by 2 to the first row.\n");
		slList.addRow(4, 2, 1);
		slList.output(order);
		System.out
				.println("Add the third row multiplied by -3 to the second row.\n");
		slList.addRow(3, -3, 2);
		slList.output(order);
		System.out.println("Subtract the first row from the second row.\n");
		slList.substractRow(1, 1, 2);
		slList.output(order);
		System.out
				.println("Subtract the last row multiplied by 3 from the second to last row.\n");
		slList.substractRow(4, 3, 3);
		slList.output(order);
		System.out.println("Swap the first and last rows.\n");
		slList.swapRow(1, 4);
		slList.output(order);
		System.out.println("Swap the second and second to last rows.\n");
		slList.swapRow(2, 3);
		slList.output(order);
		System.out.println("Delete all of the nodes in column 1.\n");
		slList.deleteRow(1, 1);
		slList.deleteRow(2, 1);
		slList.deleteRow(3, 1);
		slList.deleteRow(4, 1);
		slList.output(order);
		System.out.println("Delete all but the last two nodes in row 2.\n");
		slList.deleteRow(2, 2);
		slList.deleteRow(2, 3);
		slList.output(order);

	}

	public void stepTwoEquationTwo(String[] equationTwo, int order) {
		SprseMatrix slList = new SprseMatrix().initialize(order, equationTwo);
		System.out
				.println("Add the last row multiplied by 2 to the first row.\n");
		slList.addRow(6, 2, 1);
		slList.output(order);
		System.out
				.println("Add the third row multiplied by -3 to the second row.\n");
		slList.addRow(3, -3, 2);
		slList.output(order);
		System.out.println("Subtract the first row from the second row.\n");
		slList.substractRow(1, 1, 2);
		slList.output(order);
		System.out
				.println("Subtract the last row multiplied by 3 from the second to last row.\n");
		slList.substractRow(6, 3, 5);
		slList.output(order);
		System.out.println("Swap the first and last rows.\n");
		slList.swapRow(1, 6);
		slList.output(order);
		System.out.println("Swap the second and second to last rows.\n");
		slList.swapRow(2, 5);
		slList.output(order);
		System.out.println("Delete all of the nodes in column 1.\n");
		slList.deleteRow(1, 1);
		slList.deleteRow(2, 1);
		slList.deleteRow(3, 1);
		slList.deleteRow(4, 1);
		slList.deleteRow(5, 1);
		slList.deleteRow(6, 1);
		slList.output(order);
		System.out.println("Delete all but the last two nodes in row 2.\n");
		slList.deleteRow(2, 4);
		slList.deleteRow(2, 5);
		slList.output(order);

	}

	public void stepTwoEquationThree(String[] equationThree, int order) {
		SprseMatrix slList = new SprseMatrix().initialize(order, equationThree);
		System.out
				.println("Add the last row multiplied by 2 to the first row.\n");
		slList.addRow(8, 2, 1);
		slList.output(order);
		System.out
				.println("Add the third row multiplied by -3 to the second row.\n");
		slList.addRow(3, -3, 2);
		slList.output(order);
		System.out.println("Subtract the first row from the second row.\n");
		slList.substractRow(1, 1, 2);
		slList.output(order);
		System.out
				.println("Subtract the last row multiplied by 3 from the second to last row.\n");
		slList.substractRow(8, 3, 7);
		slList.output(order);
		System.out.println("Swap the first and last rows.\n");
		slList.swapRow(1, 8);
		slList.output(order);
		System.out.println("Swap the second and second to last rows.\n");
		slList.swapRow(2, 7);
		slList.output(order);
		System.out.println("Delete all of the nodes in column 1.\n");
		slList.deleteRow(1, 1);
		slList.deleteRow(2, 1);
		slList.deleteRow(3, 1);
		slList.deleteRow(4, 1);
		slList.deleteRow(5, 1);
		slList.deleteRow(6, 1);
		slList.deleteRow(7, 1);
		slList.deleteRow(8, 1);
		slList.output(order);
		System.out.println("Delete all but the last two nodes in row 2.\n");
		slList.deleteRow(2, 3);
		slList.deleteRow(2, 5);
		slList.deleteRow(2, 7);
		slList.output(order);

	}

	public void stepThreeEquationOne(String[] equationOne, int order) {
		int countXVariable = 1;
		double[] solutionArray;
		SprseMatrix sprseMatrix = new SprseMatrix().initialize(order,
				equationOne);
		System.out.println("Initialize Matrix :: ");
		sprseMatrix.output(order);
		System.out.println("Trangulate Matrix :: ");
		sprseMatrix = sprseMatrix.triangulate();
		sprseMatrix.output(order);
		solutionArray = sprseMatrix.solve();

		System.out.println("Solution :: ");
		for (double string : solutionArray) {
			System.out.println("x" + countXVariable + " : " + string);
			countXVariable++;
		}

		if (sprseMatrix.isSolution(solutionArray))
			System.out.println("\nisSolution() :: Correct Solution");
		else
			System.out.println("\nisSolution() :: Incorrect Solution");

	}

	public void stepThreeEquationTwo(String[] equationTwo, int order) {

		int countXVariable = 1;
		double[] solutionArray;
		SprseMatrix sprseMatrix = new SprseMatrix().initialize(order,
				equationTwo);
		System.out.println("Initialize Matrix :: ");
		sprseMatrix.output(order);
		System.out.println("Trangulate Matrix :: ");
		sprseMatrix = sprseMatrix.triangulate();
		sprseMatrix.output(order);
		solutionArray = sprseMatrix.solve();

		System.out.println("Solution :: ");
		for (double string : solutionArray) {
			System.out.println("x" + countXVariable + " : " + string);
			countXVariable++;
		}

		if (sprseMatrix.isSolution(solutionArray))
			System.out.println("\nisSolution() :: Correct Solution");
		else
			System.out.println("\nisSolution() :: Incorrect Solution");

	}

	public void stepThreeEquationThree(String[] equationThree, int order) {

		int countXVariable = 1;
		double[] solutionArray;
		SprseMatrix sprseMatrix = new SprseMatrix().initialize(order,
				equationThree);
		System.out.println("Initialize Matrix :: ");
		sprseMatrix.output(order);
		System.out.println("Trangulate Matrix :: ");
		sprseMatrix = sprseMatrix.triangulate();
		sprseMatrix.output(order);
		solutionArray = sprseMatrix.solve();

		System.out.println("Solution :: ");
		for (double string : solutionArray) {
			System.out.println("x" + countXVariable + " : " + string);
			countXVariable++;
		}

		if (sprseMatrix.isSolution(solutionArray))
			System.out.println("\nisSolution() :: Correct Solution");
		else
			System.out.println("\nisSolution() :: Incorrect Solution");

	}

	/* To print the equation in the input String array. */
	void displayEquation(String[] equation) {
		System.out.println("Input Equations ::");
		for (String string : equation) {
			System.out.println(string);
		}
		System.out.println("\n");
	}
}
