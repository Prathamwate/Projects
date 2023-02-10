package com.example.erpapp.erpModel;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Student {
	
	private int rollNo;
	private String studentName;
	private List<Double> marks;
	private String city;
	private String gender;
	
	
//	public Student(int rollNo, String studentName, List<Double> marks, String city, String gender) {
//		super();
//		this.rollNo = rollNo;
//		this.studentName = studentName;
//		this.marks = marks;
//		this.city = city;
//		this.gender = gender;
//	}
//	
//	
//	public int getRollNo() {
//		return rollNo;
//	}
//	public void setRollNo(int rollNo) {
//		this.rollNo = rollNo;
//	}
//	public String getStudentName() {
//		return studentName;
//	}
//	public void setStudentName(String studentName) {
//		this.studentName = studentName;
//	}
//	public List<Double> getMarks() {
//		return marks;
//	}
//	public void setMarks(List<Double> marks) {
//		this.marks = marks;
//	}
//	public String getCity() {
//		return city;
//	}
//	public void setCity(String city) {
//		this.city = city;
//	}
//	public String getGender() {
//		return gender;
//	}
//	public void setGender(String gender) {
//		this.gender = gender;
//	}
	
	


}
