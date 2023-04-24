package com.doctor.DoctorManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doctor.DoctorManagement.Model.Speciality;

public interface ISpecilityRepository extends JpaRepository<Speciality, Integer>{

}
