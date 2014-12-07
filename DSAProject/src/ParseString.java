/* Author : Ankur Taunk | Date : 3, Nov 2014
 * 
 * This Class is used to sparse the string equation
 *  
 */
import java.util.ArrayList;
import java.util.List;

public class ParseString {

	List<Double> coefString = new ArrayList<Double>();
	List<Integer> colum = new ArrayList<Integer>();
	private String sign = "+";
	int col;

	/*Getters and Setters.*/
	void setCoefString(String str) {

		this.coefString.add(Double.parseDouble(str));
	}

	void setCoefString(String sign, StringBuffer str) {

		this.coefString.add(Double.parseDouble(sign+str));
	}

	void setColum(int colum) {
		this.colum.add(colum);
	}

	List<Double> getCoefString() {

		return this.coefString;
	}

	List<Integer> getColum() {
		return this.colum;
	}

	 /*It parse the input equation string and returns ParseString object which
	 contains information about the coefficient,coefficient sign and column
	 where the coefficient belong to.*/
	public ParseString findIndex(String equation, int order) {

		String[] equ = equation.split("");
		ParseString parseString = new ParseString();
		boolean isColum = false;
		StringBuffer str = new StringBuffer();
		for (int i = 1; i < equ.length; i++) {

			if (!equ[i].equals("x")) {
				if (equ[i].equals("+") || equ[i].equals("-")) {
					sign = equ[i];
				} else {
					str.append(equ[i]);
				}

			} else {

				if (equ[1].equals("x") && i == 1) {
					str.append(1);
				} else if (equ[i - 1].equals("+") || equ[i - 1].equals("-")) {
					str.append(1);
				}
				this.col = Integer.parseInt(equ[i + 1]);
				isColum = true;
			}

			if (isColum) {

				parseString.setCoefString(sign, str);
				parseString.setColum(col);
				str.setLength(0);
				isColum = false;
				i++;
			}
		}
		/* Information about the Y column.*/
		parseString.setCoefString(equation.substring(equation.indexOf("=") + 1, equation.length()));
		parseString.setColum(order + 1);
		return parseString;

	}

}
