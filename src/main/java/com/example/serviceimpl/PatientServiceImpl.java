package com.example.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Patient;
import com.example.model.PatientDTO;
import com.example.repository.PatientRepository;
import com.example.service.PatientService;
import com.example.utitity.AdminConverter;
import com.example.utitity.PatientConverter;
@Service
public class PatientServiceImpl implements PatientService {
	@Autowired
private PatientRepository patientRepository;
	@Autowired
	PatientConverter patientConverter;
	@Override
	public PatientDTO savePatientInfo(Patient patient) {
		// TODO Auto-generated method stub
		Patient p= patientRepository.save(patient);
		return patientConverter.convertToPatientDTO(p);
	}

	@Override
	public List<PatientDTO> getAllPatientInfo() {
		// TODO Auto-generated method stub
		List<Patient> pp=patientRepository.findAll();
		List<PatientDTO> p=new ArrayList<>();
		for (Patient pat:pp) {
			p.add(patientConverter.convertToPatientDTO(pat));
		}
		return p;
	}

	@Override
	public PatientDTO getByPatientId(int pid) {
		// TODO Auto-generated method stub
		Patient p=patientRepository.findById(pid).get();
		return patientConverter.convertToPatientDTO(p);
	}

	@Override
	public String deletePatientInfoById(int pid) {
		// TODO Auto-generated method stub
		patientRepository.deleteById(pid);
		return "Patient deleted" ;
	}

	@Override
	public PatientDTO updatePatientInfo(int pid, Patient patient) {
		// TODO Auto-generated method stub
		Patient pp=patientRepository.findById(pid).get();
	pp.setPname(patient.getPname());
	pp.setPemail(patient.getPemail());
	pp.setPmobno(patient.getPmobno());
	pp.setPgender(patient.getPgender());
	pp.setPaddress(patient.getPaddress());
		Patient ppp= patientRepository.save(pp) ;
		return patientConverter.convertToPatientDTO(ppp);
	}

}
