package com.Doctor.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Doctor.doctor.model.Patient;

public interface IpatientRepo extends JpaRepository<Patient, Integer> {

}
