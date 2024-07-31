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

import com.example.entities.Ambulance;
import com.example.entities.Driver;
import com.example.model.DriverDTO;
import com.example.service.AmbulanceService;
import com.example.service.DriverService;
import com.example.utitity.AdminConverter;
import com.example.utitity.DriverConverter;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/driver")
@Validated
public class DriverController {
	@Autowired
private DriverService driverService;
	@Autowired
	DriverConverter driverConverter;
	@PostMapping("/add")
	ResponseEntity<DriverDTO> add(@Valid@RequestBody DriverDTO driverDTO) {
	final Driver driver=driverConverter.convertToDriverEntity(driverDTO);
	return new ResponseEntity<DriverDTO>(driverService.saveDriverInfo(driver),HttpStatus.CREATED);
		
	
	}
	@GetMapping("/getAll")
	public List<DriverDTO> getAllDriverInfo(){
		
		return driverService.getAllDriverInfo();
	}
	@GetMapping("/getByDriverId/{driverId}")
	public DriverDTO getByDriverId(@PathVariable("driverId")  int did) {
		
		
		return driverService.getByDriverId(did);
	}

	@DeleteMapping("/deleteDriverById/{driverId}")
	public String deleteDriverById(@PathVariable("driverId")  int did ) {
		// TODO Auto-generated method stub
		return driverService.deleteDriverInfoById(did);
	}

   @PutMapping("/updateDriver/{driverId}")
	public DriverDTO updateDriver( @PathVariable("driverId") int did,@Valid@RequestBody Driver driver) {
		// TODO Auto-generated method stub
	   return driverService.updateDriverInfo(did, driver);
	}
}
