package com.example.utitity;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.example.entities.Patient;
import com.example.model.PatientDTO;
@Component
public class PatientConverter {

public Patient convertToPatientEntity(PatientDTO patientDTO) {
	Patient patient=new Patient();
	if(patientDTO!=null) {
		BeanUtils.copyProperties(patientDTO, patient);
	}
	return patient;
}
public PatientDTO convertToPatientDTO(Patient patient) {
	
	PatientDTO patientDTO=new PatientDTO();
	if(patient!=null) {
		BeanUtils.copyProperties(patient, patientDTO);
	}
	return patientDTO;
}
}
