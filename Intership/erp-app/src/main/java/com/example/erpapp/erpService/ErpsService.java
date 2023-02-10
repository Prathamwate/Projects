package com.example.erpapp.erpService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.erpapp.dto.studentPercentageDto;
import com.example.erpapp.erpModel.Student;


@Service
public class ErpsService {

	private static final  List<Student> students=new ArrayList<>();
	private static int rollno=0;
	
	static {
		Student s1=new Student(++rollno,"Pratham",List.of(99.0,78.0,99.0,99.0),"Pratwada","M");
		students.add(s1);
		Student s2=new Student(++rollno,"Kajal",List.of(89.0,45.0,80.0,99.0),"Achalpur","f");
		students.add(s2);
		Student s3=new Student(++rollno,"Rohit",List.of(40.0,40.0,40.0,40.0),"Mumbai","M");
		students.add(s3);
		Student s4=new Student(++rollno,"Matin",List.of(54.0,78.0,87.0,49.0),"Amravati","M");
		students.add(s4);
		Student s5=new Student(++rollno,"Sanket",List.of(55.0,66.0,67.0,45.0),"Pratwada","M");
		students.add(s5);
	
		
	}

	public List<Student> findAll() {
	
		return students;
	}

	public Student findStudnet(int rollNo2) {
		for(Student student : students) {
			if(student.getRollNo()==rollNo2) {
				return student;
			}
		}
		return null;
	}

	public List<studentPercentageDto> findTopper() {
	   List<studentPercentageDto> percentage=findPercentage();
	   List<studentPercentageDto> topper=new ArrayList<>();
	   double max=0.0;
	   studentPercentageDto marks = null;
	   for(studentPercentageDto per: percentage) {
		     if(per.getPercetnage()>max) {
			  max=per.getPercetnage();
			  marks=per;
		  }
		}
	      studentPercentageDto dto=new studentPercentageDto(marks.getRollNo(),marks.getStudentname(),max);
		  topper.add(dto);
	   
	   return topper;
	}
	
	public List<studentPercentageDto> findLeast() {
		List<studentPercentageDto> percentage=findPercentage();
		   List<studentPercentageDto> least=new ArrayList<>();
		   double min=Integer.MAX_VALUE;
		   studentPercentageDto marks = null;
		   for(studentPercentageDto per: percentage) {
			     if(per.getPercetnage()<min) {
				  min=per.getPercetnage();
				  marks=per;
			  }
			}
		    studentPercentageDto dto=new studentPercentageDto(marks.getRollNo(),marks.getStudentname(),min);
		    least.add(dto);
		   
		   return least;
	}

	public List<studentPercentageDto> findPercentage() {
		List<studentPercentageDto> percetnage=new ArrayList<>();
	   for(Student student:students) {
		   Double per=0.0;
		   List<Double> marks=student.getMarks();
		   for(Double mark: marks) {
			   per+=mark;
		   }
		   per=per*100/400;
	       studentPercentageDto dto=new studentPercentageDto(student.getRollNo(),student.getStudentName(),per);
	       percetnage.add(dto);
	   }
	   return percetnage;
	}

	
	
	
}
