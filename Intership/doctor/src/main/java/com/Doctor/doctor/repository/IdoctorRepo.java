package com.Doctor.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Doctor.doctor.model.Doctor;

public interface IdoctorRepo extends JpaRepository<Doctor, Integer>{

}
