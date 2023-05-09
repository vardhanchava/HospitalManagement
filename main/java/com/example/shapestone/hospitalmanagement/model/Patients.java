package com.example.shapestone.hospitalmanagement.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "patients")

public class Patients {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	@Column
	private String patientid;
	@Column
	private String name;
	@Column
	private int age;
	@Column
	private String gender;
	@Column
	private String dateofadmission;
	//constructor
	public Patients(int id, String patientid, String name, int age, String gender, String dateofadmission,
			List<Treatments> treatments) {
		super();
		this.id = id;
		this.patientid = patientid;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.dateofadmission = dateofadmission;
		this.treatments = treatments;
	}
//getter and setters
	public String getPatientid() {
		return patientid;
	}

	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateofadmission() {
		return dateofadmission;
	}

	public void setDateofadmission(String dateofadmission) {
		this.dateofadmission = dateofadmission;
	}

	@Override
	public String toString() {
		return "Patients [id=" + id + ", patientid=" + patientid + ", name=" + name + ", age=" + age + ", gender="
				+ gender + ", dateofadmission=" + dateofadmission + ", treatments=" + treatments + "]";
	}
	//Patients entity class has one to many relationship with the Treatments entity.
	@OneToMany(targetEntity = Treatments.class, cascade = CascadeType.ALL)
	
	@JoinColumn(name = "serialno")
	
	List<Treatments> treatments = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Treatments> getTreatments() {
		return treatments;
	}

	public void setTreatments(List<Treatments> treatments) {
		this.treatments = treatments;
	}
	//no argument constructor
	public Patients() {
	}

}