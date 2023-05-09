package com.example.shapestone.hospitalmanagement.service;

import java.util.List;

import com.example.shapestone.hospitalmanagement.model.Patients;

public interface PatientsService {
//	Method to add a new patient to the database.
	Patients patientsdetails(Patients patients);
//Method to get all the patients from the database.
	List<Patients> getAll(Patients patients);
//Method to get a list of all the patients in the database.
	List<Patients> getPatientsList();
//Method to delete a patient from the database based on their ID.
	String deleteid(int id);
//Method to save a patient in the database.
	void savePatients(Patients patients);
// Method to update a patient's information in the database.
	Patients updatePatients(int id,Patients patients);
//Method to get a specific patient from the database based on their ID.
	Patients getPatientsById(int id);

}
