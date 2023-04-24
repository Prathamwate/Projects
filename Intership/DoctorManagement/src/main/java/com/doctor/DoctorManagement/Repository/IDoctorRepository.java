package com.doctor.DoctorManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.doctor.DoctorManagement.Model.Doctor;

import jakarta.transaction.Transactional;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Integer>{

	List<Doctor> findByCity(String city);
	
	 @Query(value = "Select * From tbl_doctor where speciality_id=:id AND city=:city", countQuery = "Select count(*) from tbl_doctor", nativeQuery = true)
	 public List<Doctor> findByCityAndSpe(int id, String city);
	 
	 @Query(value = "select * from tbl_doctor where status_id=1 and doctor_id=:id", nativeQuery = true)
	 public List<Doctor> findById(int id);
	 
	 @Transactional
	 @Modifying
	 @Query(value = "update tbl_doctor set status_id=2 where doctor_id= :id", countQuery = "Select count(*) from tbl_doctor", nativeQuery = true)
	 void deleteByDoctor(int id);

}
