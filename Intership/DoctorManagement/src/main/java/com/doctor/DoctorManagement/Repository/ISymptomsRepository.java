package com.doctor.DoctorManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.doctor.DoctorManagement.Model.Symptoms;

public interface ISymptomsRepository extends JpaRepository<Symptoms, Integer>{

	List<Symptoms> findBySymptom(String sym);

}
