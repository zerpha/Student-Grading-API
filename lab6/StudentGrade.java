package util;

import model.Student;
import model.Statistics;
import java.io.Serializable;

public class StudentGrade implements Serializable{
	
	private Student student;
	private Statistics stats;
	
	public StudentGrade() {}
	public StudentGrade(Student stud) {student = stud;}
	public StudentGrade(Statistics stat) {stats= stat;}
	public StudentGrade(Student stud, Statistics stat) {
		student = stud;
		stats = stat;
		}
	
	public void setStudent(Student stud) {student = stud;}
	public Student getStudent() {return student;}
	public void setStatistics(Statistics stat) {stats= stat;}
	public Statistics getStatistics() {return stats;}
	
	
	
	}

