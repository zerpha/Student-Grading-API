# Student Grading API
 A Java API that reads in student grades through a data set, returns statistics, and serializes/deserializes the data.

## How to run
Create a Java project with the the three text files and five packages, "adapter", "Driver", "exception", "model", and "util".
In the adapter package put in StudentAPI.java, StudentAPIImpl.java, and StudentAPIUsage.java. 
In the Driver package put in Driver1.java, Driver2.java, Driver3.java. 
In the exception package put in StudentGradingException.java.
In the model package put in Statistics.java and Student.java. 
In the util package put in StudentGrade.java and Util.java.


## Part I Shows Exception Handling
For part1, you use Driver1. In the try block, change the path 
of the text file dataerror.txt. This text file contains an error which
the StudentGradingException class will catch. You also have to change the file path
for where the error file will go in fixProblemReadFromConsole() in the StudentGradingException class.
Run Driver1. It will print the exception in error.txt if an is raised. 
If there is none, it will print the data in the console. 
It will read dataerror.txt. You can also change the file to data.txt which contains no errors.

# Part II Serializes the Data
For part2, use Driver2. It uses the same code as Driver1 to read the data. 
Change the file path in the try block for data.txt. Make sure to use data.txt and
not dataerror.txt. In Util.java, in the serialize method, change the file path
you want the serialized data to go to. Make sure to leave "\\" at the end of the String.
Run Driver2. If there are no exceptions it will serialize all the StudentGrade data in the array.

## Part III Deserializes the Data and returns statistics
For part3, use Driver3. Change the file path of data.txt. Now run Driver3.
It will print the statistics of the quizzes and print the score of the student ID: 1234.
It will print this info in the console.
