package com.Doctor.doctor.model;



import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_patient")
public class Patient   {

    @Id
    @Column(name = "patient_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer patientId;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "disease_type")
    private String diseaseType;

    @Column(name = "gender")
    private String gender;

    @Column(name = "admit_date")
    private Timestamp admitDate;

    @JoinColumn(name = "doctor_id")
    @ManyToOne(fetch=FetchType.LAZY)
    private Doctor doctor;
    
}
