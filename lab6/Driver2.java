//Henry Nguyen 20278002
//CIS35 Java Programming Online
//Lab06
//Due Mar 23
//Submitted Mar 20
package Driver;

import model.Student;
import util.Util;
import model.Statistics;
import java.io.IOException;
import util.StudentGrade;

import exception.StudentGradingException;


public class Driver2 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		boolean problemFixed = true;
		Student lab2 [] = new Student[40];
		Statistics statlab2 = new Statistics();
		StudentGrade grades [] = new StudentGrade[40]; //NOT initialized right away
		int count = 0;
		//Populate the student array
		try 
		{
			lab2 = Util.readFile("C:\\Users\\Henry\\Documents\\JAVA\\hw06\\src\\data.txt", lab2);
		}
		catch(StudentGradingException e) //will print error message thrown to it into a set file
		{
			e.setFileName(e.fixProblemReadFromConsole()); 
			System.out.printf("%s%s\n", "Error - check file: ", e.getFileName());
			e.writeFile(e.getErrormsg());
			problemFixed = false;
		}
		
		statlab2.findlow(lab2); //calculate the low,high, average scores
		statlab2.findhigh(lab2);
		statlab2.findavg(lab2);
		
		//input data into StudentGrade array
		if(problemFixed == true)//only if there are no exceptions raised
		{
			count = 0;
			while(lab2[count] != null)
			{
				grades[count] = new StudentGrade(lab2[count], statlab2);
				count++;
				if(count == 40)
					break;
			}
		}
		//serialize the StudentGrade array 
		count = 0;
		while(grades[count] != null)
		{
			Util.serialize(grades[count]);	
			count++; 
			if(count == 40)
				break;
		}
		
		
		
		
	}

}
