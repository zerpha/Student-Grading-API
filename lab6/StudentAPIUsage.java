package adapter;

import java.io.IOException;

public class StudentAPIUsage extends StudentAPIImpl implements StudentAPI {
//this class has to be empty
	public StudentAPIUsage(){super();}
	public StudentAPIUsage(String filename)throws IOException 
	{
		super(filename);
	}
}
