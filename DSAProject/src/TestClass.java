/* Author : Ankur Taunk 
 * 
 * Date : 3, Nov 2014 
 * Description : This is test class to run the Program
 * 
 * Date : 20, Nov 2014
 * Description : Updated to Call TestCases for Step 2 of the Project
 * 
 * Date : 4, Dec 2014
 * Description : Updated to Call TestCases for Step 1/2/3 of the Project.
 * 
 */

public class TestClass {

	public static void main(String[] args) {

		int order;
		TestSuit tSuit = new TestSuit();
		System.out
				.println("********************************EQUATION 1***************************\n");
		order = 4;
		String[] equationOne = { "3x1+5x4=8", "2x2-7x3=9", "5x1-3x2-10x4=-8",
				"6x2-5x4=1" };
		tSuit.displayEquation(equationOne);
		System.out.println("STEP 1 --------->\n");
		tSuit.stepOneEqutionOne(equationOne, order);
		System.out.println("STEP 2 --------->\n");
		tSuit.stepTwoEquationOne(equationOne, order);
		System.out.println("STEP 3 --------->\n");
		tSuit.stepThreeEquationOne(equationOne, order);

		System.out
				.println("********************************EQUATION 2***************************\n");
		order = 6;
		String[] equationTwo = { "-3x1+16x3=6", "3x1+2x2=-3", "-x1-x2-x3=10",
				"x2+2x3+10x4=7", "2x5+x6=0", "8x4+3x6=-1" };
		tSuit.displayEquation(equationTwo);
		System.out.println("STEP 1 --------->\n");
		tSuit.stepOneEqutionTwo(equationTwo, order);
		System.out.println("STEP 2 --------->\n");
		tSuit.stepTwoEquationTwo(equationTwo, order);
		System.out.println("STEP 3 --------->\n");
		tSuit.stepThreeEquationTwo(equationTwo, order);

		System.out
				.println("********************************EQUATION 3***************************\n");
		order = 8;
		String[] equationThree = { "2x1-4x4+5x6=32", "3x1+4x3+2x5+x7+8x8=31",
				"x2+2x4+3x7=-7", "x1+x4+2x5+2x8=10", "-x1-2x2+5x8=8",
				"x2+2x4+3x6=8", "x3+2x5+x7+x8=8", "x1-3x5+x8=-5" };
		tSuit.displayEquation(equationThree);
		System.out.println("STEP 1 --------->\n");
		tSuit.stepOneEqutionThree(equationThree, order);
		System.out.println("STEP 2 --------->\n");
		tSuit.stepTwoEquationThree(equationThree, order);
		System.out.println("STEP 3 --------->\n");
		tSuit.stepThreeEquationThree(equationThree, order);

	}

}
