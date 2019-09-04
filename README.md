# Student Grading API
 A Java API that reads in student grades through a data set, calculates statistics, returns results and serializes the data.

## How to run
tba.

## Part I
For part1, you use Driver1. In the try block, change the path 
of the text file dataerror.txt. This text file contains an error which
the StudentGradingException class will catch. You also have to change the file path
for where the error file will go in fixProblemReadFromConsole() in the StudentGradingException class.
Run Driver1. It will print the exception in error.txt if an is raised. 
If there is none, it will print the data in the console. 
You can also change the file to data.txt which contains no errors.

## Part II
For part2, use Driver2. It uses the same code as Driver1 to read the data. 
Change the file path in the try block for data.txt. Make sure to use data.txt and
not dataerror.txt. In Util.java, in the serialize method, change the file path
you want the serialized data to go to. Make sure to leave "\\" at the end of the String.
Run Driver2. If there are no exceptions it will serialize all the StudentGrade data in the array.

## Part III
For part3, use Driver3. Change the file path of data.txt. Now run Driver3.
It will print the statistics of the quizzes and print the score of the student ID: 1234.
It will print this info in the console.
