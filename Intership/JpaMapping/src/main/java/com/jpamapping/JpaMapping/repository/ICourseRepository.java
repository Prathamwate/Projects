package com.jpamapping.JpaMapping.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpamapping.JpaMapping.model.Course;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Integer>{

	

}
