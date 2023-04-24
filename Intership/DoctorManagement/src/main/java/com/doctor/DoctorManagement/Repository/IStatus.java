package com.doctor.DoctorManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doctor.DoctorManagement.Model.Status;

public interface IStatus extends JpaRepository<Status, Integer> {

}
