package com.example.controller;
//when want to add own methods then we have to add controller nad service package;
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

import com.example.entities.Admin;
import com.example.model.AdminDTO;
import com.example.service.AdminService;
import com.example.utitity.AdminConverter;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/admin")
@Validated
public class AdminController {
	@Autowired
private AdminService adminService;
	@Autowired
	AdminConverter adminConverter;
	@PostMapping("/add")
	ResponseEntity<AdminDTO> add(@Valid@RequestBody AdminDTO adminDTO) {
	  final	Admin admin=adminConverter.convertToAdminEntity(adminDTO);
	return new  ResponseEntity<AdminDTO>(adminService.saveAdminInfo(admin),HttpStatus.CREATED);
	}
	@GetMapping("/getAll")
	public List<AdminDTO> getAllAdminInfo(){
		
		return adminService.getAllAdminInfo();
	}
	@GetMapping("/getByAdminId/{adId}")
	public AdminDTO getByAdminId(@PathVariable("adId")  int aid) {
		
		
		return adminService.getByAdminId(aid);
	}

	@DeleteMapping("/deleteAdminById/{adId}")
	public String deleteAdminById(@PathVariable("adId")  int aid ) {
		// TODO Auto-generated method stub
		return adminService.deleteAdminInfoById(aid);
	}

   @PutMapping("/updateAdmin/{adId}")
	public AdminDTO updateAdmin( @PathVariable("adId") int aid,@Valid@RequestBody Admin admin) {
		// TODO Auto-generated method stub
	   return adminService.updateAdminInfo(aid, admin);
	}
}
