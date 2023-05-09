package com.example.shapestone.hospitalmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.shapestone.hospitalmanagement.model.Patients;

@Repository
/*
 * This is the PatientsRepository interface that extends CrudRepository
 * interface, which provides basic CRUD operations for the Patients entity
 */
public interface PatientsRepository extends CrudRepository<Patients, Integer> {

}
