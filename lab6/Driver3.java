//Henry Nguyen 20278002
//CIS35 Java Programming Online
//Lab06
//Due Mar 23
//Submitted Mar 20
package Driver;

import java.io.IOException;

import adapter.StudentAPI;
import adapter.StudentAPIImpl;
import adapter.StudentAPIUsage;
public class Driver3 {

	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		StudentAPI a1 = new StudentAPIUsage("C:\\Users\\Henry\\Documents\\JAVA\\hw06\\src\\data.txt");
		a1.printstats();
		System.out.printf("\n");
		a1.printscores(1234); //read studID.ser and call printscores
		
	}

}
