package com.stringparsing;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.print.attribute.standard.Finishings;

import com.linklist.sparcematrix.SLList;

public class ParseString {

	List<Double> coefString=new  ArrayList<Double>();
	List<Integer> colum=new  ArrayList<Integer>();
	private String sign="+";
	private String result;
	int col;
	
	public static void main(String[] args) {
		
		String[] equ="3x1+16x3-34x4=8".split("");

		String equation="3x1+16x3-34x4=8";

		
		}
	
void setCoefString(String str){
		
		this.coefString.add(Double.parseDouble(str));
	}
	
	void setCoefString(String sign,StringBuffer str){
		
		this.coefString.add(Double.parseDouble(sign+str));
	}
	
	void setColum(int colum){
		this.colum.add(colum);
	}
	
	List<Double> getCoefString(){
		
		return this.coefString;
	}
	
	List<Integer> getColum(){
	return	this.colum;
	}
	
	void setResult(String result){
		
		this.result=result;
	}
	
	
	String getResult(){
		return result;
	}
	
	public ParseString findIndex(String equation, int order){
		
//		if(equ[0].equals("-"))
//			sign="-";
//		else
//			sign="+";
		
		String[] equ=equation.split("");
		ParseString parseString = new ParseString();
		boolean isColum=false;
		StringBuffer str=new StringBuffer();
		//parseString.setResult();
		for(int i=1;i<equ.length;i++){
			
			if(!equ[i].equals("x")){
				if(equ[i].equals("+") || equ[i].equals("-")){
					sign=equ[i];
				}else{
					str.append(equ[i]);
				}
				
			}else{
				
				if(equ[0].equals("x")){
					str.append(1);
				}else if(equ[i-1].equals("+") ||equ[i-1].equals("-")){
					str.append(1);
				}
				this.col=Integer.parseInt(equ[i+1]);
				isColum=true;
			}
			
			if(isColum){
				
				parseString.setCoefString(sign, str);
				parseString.setColum(col);
//				System.out.println(sign+str);
//				System.out.println(col);
				str.setLength(0);
				isColum=false;
				i++;
			}
				
		}
		
		parseString.setCoefString(equation.substring(equation.indexOf("=")+1, equation.length()));
		parseString.setColum(order+1);
		return parseString;
	
	}
	
}
	  
		 

	

