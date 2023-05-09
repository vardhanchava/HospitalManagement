package com.example.shapestone.hospitalmanagement.controller;

import java.util.List;
import java.util.Optional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shapestone.hospitalmanagement.model.Patients;
import com.example.shapestone.hospitalmanagement.service.PatientsService;

import lombok.extern.slf4j.Slf4j;

@RestController
/*
 * This @RestController annotation is used to indicate that this class is a
 * controller that handles requests and returns responses in JSON format
 */
@RequestMapping("/hospital")
/*
 * The @RequestMapping annotation is used to map HTTP requests to handler
 * methods of the controller.
 */
@Validated
//The @Validated annotation is used to enable parameter validation.
@Slf4j
//The @Slf4j annotation is used to enable logging.

public class HospitalManagementController {
	// private static final Log object named log which is used for logging
	private static final Log log = LogFactory.getLog(Patients.class);

	@Autowired
	private PatientsService service;

	/*
	 * This noofpatients method returns the number of patients.
	 * http://localhost:8080/noofpatients
	 */
	@GetMapping("/noofpatients")
	public String noofpatinets() {
		int p = 4;
		return "number of patients are " + p;
	}

	/*
	 * This method is used to post new records. http://localhost:8080/
	 */
	@PostMapping("/")
	public void savePatients(@RequestBody Patients patients) {
		log.info("error, requested {/} post :: web method");
		service.savePatients(patients);
	}

	/*
	 * This method is used to get all the data from the DB.
	 * http://localhost:8080/list
	 */
	@GetMapping("/list")
	public List<Patients> getpatients() {
		return service.getPatientsList();
	}

	/*
	 * The put request is used to update records by id.
	 * http://localhost:8080/put/{id}
	 */
	@PutMapping("/put/{id}")
	public Patients updatePatients(@PathVariable("id") int id, @RequestBody Patients patients) {
		log.info("error, requested {/put/} put :: web method");
		return service.updatePatients(id, patients);
	}
	/*
	 * This method is used to get all the data from the DB based on id.
	 * http://localhost:8080/list/{id}
	 */
	@GetMapping("/list/{id}")
	public ResponseEntity<Patients> getpassengerById(@PathVariable("id") int id) {
		return new ResponseEntity<Patients>(service.getPatientsById(id), HttpStatus.OK);
	}

	/*
	 * The delete method handles DELETE requests to delete a specific patient record
	 * by ID. http://localhost:8080/delete/{id}
	 */	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		return service.deleteid(id);

	}

}
