package com.doctor.DoctorManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import com.doctor.DoctorManagement.Model.Patient;

import jakarta.transaction.Transactional;

public interface IPatientRepository extends JpaRepository<Patient, Integer>{

	 @Query(value = "select * from tbl_patient where status_id=1 and patient_id=:id", nativeQuery = true)
	 public List<Patient> findById(int id);

	 
	 @Transactional
	 @Modifying
	 @Query(value = "update tbl_patient set status_id=2 where patient_id= :id", countQuery = "Select count(*) from tbl_patient", nativeQuery = true)
	 public void deleteByDoctor(int id);

}
