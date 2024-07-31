package com.example.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Ambulance;
import com.example.entities.Driver;
import com.example.exception.ResourceNotFoundException;
import com.example.model.AmbulanceDTO;
import com.example.repository.AmbulanceRepository;
import com.example.repository.DriverRepository;
import com.example.service.AmbulanceService;
import com.example.utitity.AdminConverter;
import com.example.utitity.AmbulanceConverter;
@Service
public class AmbulanceServiceImpl implements AmbulanceService{
	@Autowired
private AmbulanceRepository ambulanceRepository;
	@Autowired
	private DriverRepository driverRepository;
	@Autowired
	AmbulanceConverter ambulanceConverter;
	@Override
	public AmbulanceDTO saveAmbulanceInfo(Ambulance ambulance) {
		// TODO Auto-generated method stub
		Ambulance aa= ambulanceRepository.save(ambulance);
		return ambulanceConverter.convertToAmbulanceDTO(aa);
	}

	@Override
	public List<AmbulanceDTO> geAllAmbulanceInfo() {
		// TODO Auto-generated method stub
		List<Ambulance> aa=ambulanceRepository.findAll();
		List<AmbulanceDTO> dtoaa=new ArrayList<>();
		for(Ambulance a :aa) {
			dtoaa.add(ambulanceConverter.convertToAmbulanceDTO(a));
		}
		return dtoaa;
	}

	@Override
	public AmbulanceDTO getByAmbulanceId(int emsno) {
		// TODO Auto-generated method stub
		Ambulance aa= ambulanceRepository.findById(emsno).orElseThrow(()->
		new ResourceNotFoundException("Ambulance","Id",emsno));
		return ambulanceConverter.convertToAmbulanceDTO(aa);
	}

	@Override
	public String deleteAmbulanceInfoById(int emsno ) {
		// TODO Auto-generated method stub
		ambulanceRepository.findById(emsno).orElseThrow(()->
		new ResourceNotFoundException("Ambulance", "Id", emsno));
		ambulanceRepository.deleteById(emsno);
		return "Ambulance Info deleted";
	}

	@Override
	public AmbulanceDTO updateAmbulanceInfo(int emsno, Ambulance ambulance) {
		// TODO Auto-generated method stub
		Ambulance aa=ambulanceRepository.findById(emsno).orElseThrow(()->
		new ResourceNotFoundException("Ambulance","Id", emsno));
	aa.setOwnername(ambulance.getOwnername());
	aa.setAtype(ambulance.getAtype());
	aa.setRcno(ambulance.getRcno());
		Ambulance aaa=ambulanceRepository.save(aa);
		return ambulanceConverter.convertToAmbulanceDTO(aaa);
	}

	

}
