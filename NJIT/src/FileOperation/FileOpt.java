package FileOperation;

import java.io.File;

public class FileOpt {
	   public static void main(String[] args) {
		      File oldName = new File("C:\\Users\\Ankur\\Desktop\\Music\\TestClass.java");
		      File newName = new File("C:\\Users\\Ankur\\Desktop\\Music\\TestClass1.java");
		      if(oldName.renameTo(newName)) {
		         System.out.println("renamed");
		      } else {
		         System.out.println("Error");
		      }}
}
