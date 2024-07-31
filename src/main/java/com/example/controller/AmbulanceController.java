package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

import com.example.entities.Ambulance;
import com.example.model.AmbulanceDTO;
import com.example.service.AmbulanceService;
import com.example.utitity.AdminConverter;
import com.example.utitity.AmbulanceConverter;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/ambulance")
@Validated
public class AmbulanceController {
	@Autowired
private AmbulanceService ambulanceService;
	@Autowired
	AmbulanceConverter ambulanceconverter;
	@PostMapping("/add")
  ResponseEntity<AmbulanceDTO> add(@Valid@RequestBody AmbulanceDTO ambulanceDTO) {
	  final	Ambulance ambulance=ambulanceconverter.convertToAmbulanceEntity(ambulanceDTO);
		return new ResponseEntity<AmbulanceDTO>(ambulanceService.saveAmbulanceInfo(ambulance),HttpStatus.CREATED);
	}
	@GetMapping("/getAll")
	public List<AmbulanceDTO> getAllAmbulanceInfo(){
		
		return ambulanceService.geAllAmbulanceInfo();
	}
	@GetMapping("/getByAmbulanceId/{ambuEmsNo}")
	public AmbulanceDTO getByAmbulanceId(@PathVariable("ambuEmsNo")  int emsno) {
		
		
		return ambulanceService.getByAmbulanceId(emsno);
	}

	@DeleteMapping("/deleteAmbulanceById/{ambuEmsNo}")
	public String deleteAmbulanceById(@PathVariable("ambuEmsNo")  int emsno ) {
		// TODO Auto-generated method stub
		return ambulanceService.deleteAmbulanceInfoById(emsno);
	}

   @PutMapping("/updateAmbulance/{ambuEmsNo}")
	public AmbulanceDTO updateAmbulance( @PathVariable("ambuEmsNo") int emsno,@Valid@RequestBody Ambulance ambulance) {
		// TODO Auto-generated method stub
	   return ambulanceService.updateAmbulanceInfo(emsno, ambulance);
	}

}


