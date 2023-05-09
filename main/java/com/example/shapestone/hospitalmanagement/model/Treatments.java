package com.example.shapestone.hospitalmanagement.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "treatments")
public class Treatments {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	String treatmentid;
	String patientid;
	
	public Treatments(int id, String treatmentid, String patientid, String diagnosis, String treatment,
			String dateoftreatment, float price) {
		super();
		this.id = id;
		this.treatmentid = treatmentid;
		this.patientid = patientid;
		this.diagnosis = diagnosis;
		this.treatment = treatment;
		this.dateoftreatment = dateoftreatment;
		this.price = price;
	}

	String diagnosis;

	String treatment;
	String dateoftreatment;
	float price;
	//getter and setters
	public String getTreatmentid() {
		return treatmentid;
	}

	public void setTreatmentid(String treatmentid) {
		this.treatmentid = treatmentid;
	}

	public String getPatientid() {
		return patientid;
	}

	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}

	public String getDateoftreatment() {
		return dateoftreatment;
	}

	public void setDateoftreatment(String dateoftreatment) {
		this.dateoftreatment = dateoftreatment;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getTreatment() {
		return treatment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public Treatments() {

	}
}
