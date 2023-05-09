package com.example.shapestone.hospitalmanagement.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.example.shapestone.hospitalmanagement.model.Patients;
import com.example.shapestone.hospitalmanagement.service.PatientsService;

@ExtendWith(MockitoExtension.class)
class HospitalManagementControllerTest {

	@InjectMocks
	private HospitalManagementController controller;
	@Mock
	private PatientsService service;

	private MockMvc mockmvc;

	@Before
	@Test
	public void firstStep() {
		HospitalManagementController controller = new HospitalManagementController();
		mockmvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void testNoOfPatients() throws Exception {
		HospitalManagementController controller = new HospitalManagementController();
		String p = controller.noofpatinets();
		assertNotNull(p);
	}

	@Test
	public void testSavePatients() {
		HospitalManagementController controller = new HospitalManagementController();
		List<Patients> patients = new ArrayList<>();
		Patients p1 = new Patients();
		p1.setId(0);
		p1.setPatientid("P001");
		p1.setName("vardhan");
		p1.setAge(32);
		p1.setGender("Male");
		patients.add(p1);
		when(service.getPatientsList()).thenReturn(patients);
		assertEquals(p1.getPatientid(), service.getPatientsList().get(0).getPatientid());
		assertEquals(p1.getName(), service.getPatientsList().get(0).getName());
		assertEquals(p1.getAge(), service.getPatientsList().get(0).getAge());
		assertEquals(p1.getGender(), service.getPatientsList().get(0).getGender());
	}


	@Test
	public void testGetPatientsList() {

		List<Patients> patientsList = new ArrayList<Patients>();
		patientsList.add(new Patients(1, "P001", "vardhan", 0, null, null, null));
		when(service.getPatientsList()).thenReturn(patientsList);
		List<Patients> result = controller.getpatients();
		assertEquals("vardhan", result.get(0).getName());

	}

	@Test
	public void testDelete() {
		int id = 123;
		String expected = "Success";
		when(service.deleteid(id)).thenReturn(expected);
		String result = controller.delete(id);
		verify(service).deleteid(id);
		assertEquals(expected, result);
	}

}
