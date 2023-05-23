package com.jpamapping.JpaMapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpamapping.JpaMapping.model.ClassRoom;

@Repository
public interface IClassroomRepository extends JpaRepository<ClassRoom, Integer>{

}
