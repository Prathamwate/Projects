package com.doctor.DoctorManagement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Status {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	  
	    private String status_description;
}
