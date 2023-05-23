package com.jpamapping.JpaMapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpamapping.JpaMapping.model.Address;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Integer> {

}
