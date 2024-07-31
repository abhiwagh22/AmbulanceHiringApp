package com.example.utitity;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.example.entities.Ambulance;
import com.example.model.AmbulanceDTO;
@Component
public class AmbulanceConverter {
	public Ambulance convertToAmbulanceEntity(AmbulanceDTO ambulanceDTO) {
		Ambulance ambulance=new Ambulance();
		if(ambulanceDTO!=null) {
			BeanUtils.copyProperties(ambulanceDTO, ambulance);
		}
		
		return ambulance;
	}
	public AmbulanceDTO convertToAmbulanceDTO(Ambulance ambulance) {
		
		AmbulanceDTO ambulanceDTO=new AmbulanceDTO();
		if(ambulance!=null) {
			
			BeanUtils.copyProperties(ambulance, ambulanceDTO);
		}
		return ambulanceDTO;
	}
}
