package com.doctor.DoctorManagement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Speciality {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    private String speciality_type;
}
