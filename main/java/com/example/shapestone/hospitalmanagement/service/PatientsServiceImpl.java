package com.example.shapestone.hospitalmanagement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.shapestone.hospitalmanagement.Exception.ResourceNotFoundException;
import com.example.shapestone.hospitalmanagement.model.Patients;
import com.example.shapestone.hospitalmanagement.repository.PatientsRepository;

@Service
//This class is to add implementation for PatientsService class methods.
public class PatientsServiceImpl implements PatientsService {

	@Autowired
	private PatientsRepository patientsRepository;

	public PatientsServiceImpl(PatientsRepository patientsRepository) {
		super();
		this.patientsRepository = patientsRepository;
	}

	@Override
	public Patients patientsdetails(Patients patients) {
		return patientsRepository.save(patients);

	}

	@Override
	public List<Patients> getAll(Patients patients) {
		return (List<Patients>) patientsRepository.findAll();

	}

	@Override
	public List<Patients> getPatientsList() {
		return (List<Patients>) patientsRepository.findAll();

	}

	public String deleteid(int id) {
		patientsRepository.deleteById(id);
		return "Deleted Succesfully...";
	}

	@Override
	public void savePatients(Patients patients) {
		patientsRepository.save(patients);
	}

	@Override
	public Patients updatePatients(int id, Patients patientToUpdate) {
		Patients existingPatient = patientsRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("No patient found with ID: " + id));
		existingPatient.setName(patientToUpdate.getName());
		existingPatient.setAge(patientToUpdate.getAge());
		existingPatient.setGender(patientToUpdate.getGender());
		existingPatient.setDateofadmission(patientToUpdate.getDateofadmission());
		return patientsRepository.save(existingPatient);
	}

	@Override
	public Patients getPatientsById(int id) {

		return patientsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patients", "Id", id));
	}

}