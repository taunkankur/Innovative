package com.treebuilder;



public class StringProcessing {	
    public static String DivideString(String ClassName){
    	
    	// if the string all upper case (abbreviation)
    	if( isAllUpper(ClassName) ){
	    	return ClassName;
        }
        
    	// if it is normal string
    	String ClassNameWithSpace= DevideStringBasedonUpperCase((ClassName.replaceAll("_", " ")).replaceAll("-", " ")).trim();
	
	    // check each parts is start with capital letters and their lenght more than one
	    boolean yes=true;
 
            if( yes == true ){
	    	return capitalizeFirstLetters(ClassNameWithSpace);
	    }
	    else{   	
	    	String NewClassWithSpace="";
	    	String ClassNameNew=ClassName.replaceAll("_", " ").replaceAll("-", " ").trim();
	    	 
	    	 ///S=S.replaceAll("[A-Z]", "$");
	    	 for(int i=0; i<ClassNameNew.length();i++ ){
	    		if(i+1<ClassNameNew.length() && (i-1>=0)) {
	    	      if((Character.isLowerCase(ClassNameNew.trim().charAt(i+1)) && Character.isUpperCase(ClassNameNew.trim().charAt(i))) ||
	    	    		  (Character.isLowerCase(ClassNameNew.trim().charAt(i-1)) && Character.isUpperCase(ClassNameNew.trim().charAt(i))))
	    	    		 {
	    	    	 NewClassWithSpace+=" ";
	    	    	 
	    	      }
	    		}
	    	     NewClassWithSpace+=ClassNameNew.trim().charAt(i);
	    	     
	          }
	    	  return NewClassWithSpace;
	    }
    }
    
    public static String DevideStringBasedonUpperCase(String S){
    	 
         String res = "";
         for(int i = 0; i < S.length(); i++) {
                 Character ch = S.charAt(i);
                 if( Character.isUpperCase(ch) )
                         res += " " + Character.toLowerCase(ch);
                 else
                         res += ch;
         }
		return res;
    	 
     }
     
    public static boolean isAllUpper(String s) {
    	    for(char c : s.toCharArray()) {
    	       if(Character.isLetter(c) && Character.isLowerCase(c)) {
    	           return false;
    	        }
    	    }
    	    return true;
    	   }
    
    // this function captilize the first letter of each word without changing the case of the remaining letters
    public static String capitalizeFirstLetters ( String s ) {

        for (int i = 0; i < s.length(); i++) {

            if (i == 0) {
                // Capitalize the first letter of the string.
                s = String.format( "%s%s",
                             Character.toUpperCase(s.charAt(0)),
                             s.substring(1) );
            }

            // Is this character a non-letter or non-digit?  If so
            // then this is probably a word boundary so let's capitalize
            // the next character in the sequence.
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                if (i + 1 < s.length()) {
                    s = String.format( "%s%s%s",
                                 s.subSequence(0, i+1),
                                 Character.toUpperCase(s.charAt(i + 1)),
                                 s.substring(i+2) );
                }
            }

        }
        return s;

    }   
}     
     
    
     