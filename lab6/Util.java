package util;

import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import model.Student;
import exception.StudentGradingException;
import java.io.IOException;
import java.util.*;
import util.StudentGrade;

//"throws" is put when the method uses keyword "throw" 
public class Util{
	public static Student[] readFile(String filename, Student [] stu)  throws StudentGradingException, IOException{
		
		int counter = 0;
		try {	
			FileReader file = new FileReader(filename); //open text file
			BufferedReader buff = new BufferedReader(file);
			String temp;
			String line = buff.readLine(); //skip first line
			boolean eof = false;
			while (!eof) 
			{//reads until hit end of file
			
				line = buff.readLine(); //skip first line
				if (line == null) //hit end of file
					eof = true;
				else if(line.isEmpty()){
					throw new StudentGradingException("Missing Row of data on line" + (counter+2));
				}
				else {
						temp = line;
						stu[counter] = new Student(); 
						StringTokenizer st = new StringTokenizer(temp);
					    while (st.hasMoreTokens()) //keeps going until there are no more tokens
					    {
					    	String ID = st.nextToken();
					    	if(ID.length() != 4)
					    	{
					    		throw new StudentGradingException("ID is not length 4 on line " + (counter+2));
					    	}
					    	stu[counter].setSID(Integer.parseInt(ID));
					         for(int count = 0; count < 5; count++)
					         {
					        	 if(st.hasMoreTokens())  //keeps going until there are no more tokens
					        	 {
					        		 String s = st.nextToken();
								    	if(Integer.parseInt(s) < 0 || Integer.parseInt(s) > 100)
								    	{
								    		throw new StudentGradingException("Grade is not between 0 - 100 on line " + (counter+2));
								    	}
					        		 stu[counter].setScore(Integer.parseInt(s), count);  
					        	 }
					        	 else
					        	 {
					        		 throw new StudentGradingException("There are less than 5 grades on line " + (counter+2));
					        	 }
					         }
					         if(st.hasMoreTokens())
				        	 {
				        		 throw new StudentGradingException("There are more than 5 grades on line " + (counter+2));
				        	 }
					    }
				}
				counter++;
				if(counter == 40)
					break;
			}
			buff.close(); 
			return stu;
		}
		catch(FileNotFoundException f1)
		{
			throw new StudentGradingException("File not found");
		}
		catch(StudentGradingException s)
		{
			throw s; //throws to the catch in the Driver
		}			
	}
	
public static void serialize(StudentGrade s) 
	{
		String filename = "C:\\Users\\Henry\\Documents\\JAVA\\hw06\\src\\StudentGrades\\"; 
		filename = filename +  s.getStudent().getSID() + ".ser"; //the serialized file will be the student ID 
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
			out.writeObject(s);
		}
		catch(IOException f){
			System.out.printf("Error while try to serialize\n");	
		}
	}
}

		
