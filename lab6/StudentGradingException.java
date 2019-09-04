package exception;

import java.io.*; 
import java.io.IOException;

public class StudentGradingException extends Exception{
	private String fileName;
	private String errormsg;
	
	//constructors 
	public StudentGradingException(){
		super();
	}
	public StudentGradingException(String errormsg){
		super();
		this.errormsg = errormsg;
	}
	public StudentGradingException(String fileName ,String errormsg){
		super();
		this.errormsg = errormsg;
		this.fileName = fileName;
	}
	
	public void writeFile(String s) throws IOException //write the error message, s into the file 
	{
		 FileWriter fileWriter = new FileWriter(fileName);
		 fileWriter.write(s);
		 fileWriter.close();
	}
	public String fixProblemReadFromConsole()
	{
		String a = "C:\\Users\\Henry\\Documents\\JAVA\\hw06\\src\\error.txt"; //the text file the error statement will be printed to
		System.out.printf("got here --> fixProblemReadFromConsole\n");
		return a; //returns the text file that the error will be printed in so that we can set it
	}
	
	public String getErrormsg() {
		return errormsg;
	}
	
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
