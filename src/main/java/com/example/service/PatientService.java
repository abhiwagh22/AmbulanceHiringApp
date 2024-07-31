package com.example.service;

import java.util.List;

import com.example.entities.Driver;
import com.example.entities.Patient;
import com.example.model.PatientDTO;

public interface PatientService {
public PatientDTO savePatientInfo(Patient patient);
public List<PatientDTO> getAllPatientInfo();
PatientDTO getByPatientId(int pid);
String deletePatientInfoById(int pid);
PatientDTO updatePatientInfo(int pid,Patient patient);
}
