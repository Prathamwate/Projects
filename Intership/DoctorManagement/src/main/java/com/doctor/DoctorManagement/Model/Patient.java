package com.doctor.DoctorManagement.Model;

import java.util.ArrayList;

import org.json.JSONArray;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_patient")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private int patientId;
	
    @Column(name = "patientName")
    private String patientName;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "city")
    private String city;
    
    @NonNull
    @Column(name = "phone_number")
    private String phoneNumber;
    
    @Column(name = "symptom")
    private ArrayList<String> symptom;
    
    @ManyToOne
    @JoinColumn
    private Status status;

	
}
