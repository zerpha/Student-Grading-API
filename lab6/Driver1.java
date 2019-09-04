//Henry Nguyen 20278002
//CIS35 Java Programming Online
//Lab06
//Due Mar 23
//Submitted Mar 20
package Driver;

import exception.StudentGradingException;
import model.Student;
import util.Util;
import java.io.IOException;

public class Driver1 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		boolean problemFixed = true;
		Student lab2 [] = new Student[40];

		//Populate the student array
		try 
		{
			lab2 = Util.readFile("C:\\Users\\Henry\\Documents\\JAVA\\hw06\\src\\dataerror.txt", lab2);
		}
		catch(StudentGradingException e)
		{
			e.setFileName(e.fixProblemReadFromConsole()); 
			System.out.printf("%s%s\n", "Error - check file: ", e.getFileName());
			e.writeFile(e.getErrormsg());
			problemFixed = false;
		}
		
		if(problemFixed == true)//only prints if there are no errors 
		{
			int count = 0;
			System.out.printf("Stud  Qu1  Qu2  Qu3  Qu4  Qu5\n"); //print out all data
			while(lab2[count] != null)
			{
				lab2[count].print();
				count++;
				if(count == 40)
					break;
			}
		}
		
		
	}
}
