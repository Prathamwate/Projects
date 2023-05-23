package com.jpamapping.JpaMapping.model;


import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;
	private String name;
	//private String department;
	  
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addid")
	private Address address;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "sid")
	private List<Course> course;
	

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student_classroom",joinColumns =@JoinColumn(name = "sid"),
	inverseJoinColumns = @JoinColumn(name="class_id"))
	private Set<ClassRoom> classroom;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Department department;

}
