package com.example.utitity;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.example.entities.Admin;
import com.example.entities.Ambulance;
import com.example.entities.Driver;
import com.example.entities.Patient;
import com.example.model.AdminDTO;
import com.example.model.AmbulanceDTO;
import com.example.model.DriverDTO;
import com.example.model.PatientDTO;


@Component
public class AdminConverter {
public Admin convertToAdminEntity(AdminDTO adminDTO) {
	
	Admin admin=new Admin();
	if(adminDTO!= null) {
		BeanUtils.copyProperties(adminDTO, admin);
	}
	return admin;
	
}
public AdminDTO convertToAdminDTO(Admin admin) { 
	AdminDTO adminDTO=new AdminDTO();
	if(admin!=null) {
		BeanUtils.copyProperties(admin, adminDTO);
	}
 return adminDTO;
}

}
