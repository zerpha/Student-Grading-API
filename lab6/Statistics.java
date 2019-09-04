package model;

import java.io.Serializable;

//implements serializable because StudentGrade class contains Statistics class

public class Statistics implements Serializable {
	private int [] lowscores = new int [5];

	private int [] highscores = new int [5];

	private float [] avgscores = new float [5];

	public void findlow(Student [] a) {

	/* This method will find the lowest score and store it in an   array names lowscores. */
		int count = 0;
		for(int index = 0; index < 5; index++)
		{
			lowscores[index] = a[count].getScore(index);
		}
		count++;
		while(a[count] != null)
		{
			for(int index = 0; index < 5; index++)
			{
				if(lowscores[index] > a[count].getScore(index))
				{
					lowscores[index] = a[count].getScore(index);
				}
			}
			count++;
			if(count == 40)
				break;
		}
	}

	public void findhigh(Student [] a) {

	/* This method will find the highest score and store it in an     array names highscores. */
		int count = 0;
		for(int index = 0; index < 5; index++)
		{
			highscores[index] = a[count].getScore(index);
		}
		count++;
		while(a[count] != null)
		{
			for(int index = 0; index < 5; index++)
			{
				if(highscores[index] < a[count].getScore(index))
				{
					highscores[index] = a[count].getScore(index);
				}
			}
			count++;
			if(count == 40)
				break;
		}
	}
	

	public void findavg(Student [] a) {

	/* This method will find avg score for each quiz and store it in an array names avgscores. */
		int count = 0;
		while(a[count] != null)
		{
			for(int index = 0; index < 5; index++)
			{
				avgscores[index] += (float)a[count].getScore(index);
			}
			count++;
			if(count == 40)
				break;
		}
		for(int index = 0; index < 5; index++)
		{
			avgscores[index] = avgscores[index]/count;
		}
	}
	public void printLow() {
		System.out.printf("Low Score  ");
		for(int index = 0; index < 5; index++)
		{
			System.out.printf("%d    ",lowscores[index]);
		}
		System.out.printf("\n");
	}
	public void printHigh() {
		System.out.printf("High Score ");
		for(int index = 0; index < 5; index++)
		{
			System.out.printf("%d    ",highscores[index]);
		}
		System.out.printf("\n");
	}
	public void printAverage() {
		System.out.printf("Average    ");
		for(int index = 0; index < 5; index++)
		{
			System.out.printf("%.1f  ",avgscores[index]);
		}
		System.out.printf("\n");
	}
}
