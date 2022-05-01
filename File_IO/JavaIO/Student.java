package JavaIO;

import java.io.Serializable;
import java.util.Random;

public class Student implements Serializable{
	private String name;
	private String studentID;
	private double[] score;
	public Student(String name, String studentID) {
		this.name = name;
		this.studentID = studentID;
		score = new double[3];
	}
	public Student () {
		score = new double[3];
		initRandom();
	}
	public Student initRandom() {
		Random r =new Random();
		String name="";
		int studentID=r.nextInt(899999)+100000;
		for(int c=0;c<10;c++) {name+=(char)(r.nextInt(25)+97);}
		this.name=name;
		this.studentID=String.valueOf(studentID);
		for(int i=0;i<score.length;i++) {
			score[i]=scoreGen(r);
		}
		return this;
	}
	
	public double scoreGen(Random r) {
		return (double)((int)((r.nextDouble()*10)*100))/100;
	}
	
	public double getAverageScore() {
		double result=0;
		for(int i=0;i<score.length;i++) {
			result+=score[i];
		}
		return result/score.length;
	}
	
	public void setScore(double[] score) {
		this.score = score;
	}
	
	public void setScore(int course,double score) {
		try {
			this.score[course]=score;
		} catch (Exception e) {
			System.out.println("invalid position");
		}
	}
	
	@Override
	public String toString() {
		String listScore="Score: [";
		for(int i=0;i<score.length-1;i++) {
			listScore+=score[i]+",";
		}
		listScore+=score[score.length-1]+"]";
		
		return "Student ID: "+studentID+", Name: "+name+", "+listScore+", Average Score: "+getAverageScore();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public double[] getScore() {
		return score;
	}
	
	
}
