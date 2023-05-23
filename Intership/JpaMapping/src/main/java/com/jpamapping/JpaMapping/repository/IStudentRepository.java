package com.jpamapping.JpaMapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpamapping.JpaMapping.model.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer>{

}
