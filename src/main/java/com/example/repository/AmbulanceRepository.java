package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Ambulance;

@Repository
public interface AmbulanceRepository extends JpaRepository<Ambulance, Integer>{

}
