package model;

import java.io.Serializable;

//implements serializable because StudentGrade class contains Student class
public class Student implements Serializable {
	 private int SID;

	 private int scores[] = new int[5];

	 public void setSID(int ID) {SID = ID;}
	 public int getSID() {return SID;}
	 public void setScore(int score, int index) {scores[index] = score;}
	 public int getScore(int index) {return scores[index];}
	 public void print() //print out all the scores
	 {
		 System.out.printf("%03d  %03d  %03d  %03d  %03d  %03d\n", getSID(), getScore(0),
				 getScore(1), getScore(2), getScore(3), getScore(4));
	 }
}
