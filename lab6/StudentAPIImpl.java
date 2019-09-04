package adapter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import exception.StudentGradingException;
import model.*;
import util.StudentGrade;
import util.Util;

public abstract class StudentAPIImpl {

	private boolean problemFixed = true;
	private Student lab2 [] = new Student[40];
	private Statistics statlab2 = new Statistics();
	private StudentGrade grades [] = new StudentGrade[40];
	
	public StudentAPIImpl() {}
	public StudentAPIImpl(String filename) throws IOException 
	{
		int count = 0;
		try //reads file first
		{
			lab2 = Util.readFile(filename, lab2);
		}
		catch(StudentGradingException e) //will print error message thrown to it into a set file
		{
			e.setFileName(e.fixProblemReadFromConsole()); 
			System.out.printf("%s%s\n", "Error - check file: ", e.getFileName());
			e.writeFile(e.getErrormsg());
			problemFixed = false;
		}
		if (problemFixed == true)
		{
			statlab2.findlow(lab2); //calculate the low,high, average scores
			statlab2.findhigh(lab2);
			statlab2.findavg(lab2);
		
		
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
	
	public void printstats() 
	{		
		statlab2.printLow(); //print the low,high, average scores
		statlab2.printHigh();
		statlab2.printAverage();
	}
	
	public void printscores(int SID) 
	{
		StudentGrade g = new StudentGrade();
		String filename = "C:\\Users\\Henry\\Documents\\JAVA\\hw06\\src\\StudentGrades\\"; 
		filename = filename +  SID + ".ser"; //the serialized file will be the student ID 
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			g = (StudentGrade)in.readObject();
			in.close();
		}
		catch(ClassNotFoundException f)
		{
			System.out.printf("Class not found when trying to deserialize");
		}
		catch(FileNotFoundException f1)
		{
			System.out.printf("File not found when trying to deserialize");
		}
		catch(IOException f){
			System.out.printf("Error while try to deserialize\n");	
		}
		System.out.printf("Stud  Qu1  Qu2  Qu3  Qu4  Qu5\n"); //print out all data
		g.getStudent().print();
	}
}
