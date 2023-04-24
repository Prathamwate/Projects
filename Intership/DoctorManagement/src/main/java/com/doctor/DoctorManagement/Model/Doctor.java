package com.doctor.DoctorManagement.Model;

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
@Table(name = "tbl_doctor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private int doctorId;
	
    @Column(name = "doctor_name")
    private String doctorName;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "city")
    private String city;
    
    @NonNull
    @Column(name = "phone_number")
    private String phoneNumber;
    
    @ManyToOne
    @JoinColumn
    private Speciality speciality;
    
    @ManyToOne
    @JoinColumn
    private Status status;
}
