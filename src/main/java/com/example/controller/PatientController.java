package com.example.controller;

import java.util.List;

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

import com.example.entities.Driver;
import com.example.entities.Patient;
import com.example.model.PatientDTO;
import com.example.service.PatientService;
import com.example.utitity.AdminConverter;
import com.example.utitity.PatientConverter;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/patient")
@Validated
public class PatientController {
@Autowired
private PatientService patientService;
@Autowired
PatientConverter patientConverter;
@PostMapping("/add")
ResponseEntity<PatientDTO> add(@Valid@RequestBody PatientDTO patientDTO) {
	final Patient patient=patientConverter.convertToPatientEntity(patientDTO);
	return new ResponseEntity<PatientDTO>(patientService.savePatientInfo(patient),HttpStatus.CREATED);
}
@GetMapping("/getAll")
public List<PatientDTO> getAllPatientInfo(){
	
	return patientService.getAllPatientInfo();
}
@GetMapping("/getByPatientrId/{patientId}")
public PatientDTO getByPatientId(@PathVariable("patientId")  int pid) {
	
	
	return patientService.getByPatientId(pid);
}

@DeleteMapping("/deletePatientById/{patientId}")
public String deletePatientById(@PathVariable("patientId")  int pid ) {
	// TODO Auto-generated method stub
	return patientService.deletePatientInfoById(pid);
}

@PutMapping("/updatePatient/{patientId}")
public PatientDTO updatePatient( @PathVariable("patientId") int pid,@Valid@RequestBody Patient patient) {
	// TODO Auto-generated method stub
   return patientService.updatePatientInfo(pid, patient);
}
}
