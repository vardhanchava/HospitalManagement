package com.example.shapestone.hospitalmanagement.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.shapestone.hospitalmanagement.model.Patients;
import com.example.shapestone.hospitalmanagement.repository.PatientsRepository;

class PatientsServiceImplTest {
	@InjectMocks
	private PatientsServiceImpl service;

	@Mock
	private PatientsRepository repository;

	@Test
	public void testPatientsServiceImplConstructor() {
		PatientsServiceImpl service = new PatientsServiceImpl(repository);
		assertNotNull(service);
	}
	@BeforeEach
	void setUp() {
		repository = mock(PatientsRepository.class);
	    service = new PatientsServiceImpl(repository);
	}

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testPatientsDetails() {
		Patients patient = new Patients();
		patient.setPatientid("P001");
		patient.setName("John Doe");
		patient.setAge(40);
		patient.setGender("Male");

		when(repository.save(patient)).thenReturn(patient);

		Patients savedPatient = service.patientsdetails(patient);

		assertEquals(patient.getPatientid(), savedPatient.getPatientid());
		assertEquals(patient.getName(), savedPatient.getName());
		assertEquals(patient.getAge(), savedPatient.getAge());
		assertEquals(patient.getGender(), savedPatient.getGender());
		assertEquals(patient.getDateofadmission(), savedPatient.getDateofadmission());

		verify(repository, times(1)).save(patient);
	}

	@Test
	public void testGetAll() {
		List<Patients> patientsList = new ArrayList<>();
		Patients patient1 = new Patients();
		patient1.setPatientid("P001");
		patient1.setName("John Doe");
		patient1.setAge(40);
		patient1.setGender("Male");
		patientsList.add(patient1);

		when(repository.findAll()).thenReturn(patientsList);

		List<Patients> result = service.getAll(new Patients());

		assertEquals(patientsList.size(), result.size());
		assertEquals(patientsList.get(0).getPatientid(), result.get(0).getPatientid());
		assertEquals(patientsList.get(0).getName(), result.get(0).getName());
		assertEquals(patientsList.get(0).getAge(), result.get(0).getAge());
		assertEquals(patientsList.get(0).getGender(), result.get(0).getGender());

		verify(repository, times(1)).findAll();
	}

	@Test
	public void testGetPatientsList() {
		List<Patients> patients = new ArrayList<>();
		patients.add(new Patients(1, "P001", "John Doe", 40, "Male", null, null));
		when(repository.findAll()).thenReturn(patients);
		List<Patients> result = service.getPatientsList();
		assertEquals(patients.size(), result.size());
		assertEquals(patients.get(0).getPatientid(), result.get(0).getPatientid());
		assertEquals(patients.get(0).getAge(), result.get(0).getAge());
		verify(repository, times(1)).findAll();
	}
	@Test
	public void testDeleteById() {
	    PatientsRepository repository = mock(PatientsRepository.class);
	    PatientsServiceImpl service = new PatientsServiceImpl(repository);
	    int idToDelete = 1;
	    doNothing().when(repository).deleteById(idToDelete);
	    String result = service.deleteid(idToDelete);
	    assertEquals("Deleted Succesfully...", result);
	    verify(repository, times(1)).deleteById(idToDelete);
	}
	 @Test
	    public void testSavePatients() {
	        Patients patients = new Patients(); 
	        service.savePatients(patients); 
	        verify(repository, times(1)).save(patients); 
	    }
}
