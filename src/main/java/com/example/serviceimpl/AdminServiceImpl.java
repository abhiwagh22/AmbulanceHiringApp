package com.example.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.entities.Admin;
import com.example.exception.ResourceNotFoundException;
import com.example.model.AdminDTO;
import com.example.repository.AdminRepository;
import com.example.service.AdminService;
import com.example.utitity.AdminConverter;
@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
public AdminRepository adminRepository;
	@Autowired
	AdminConverter adminConverter;
	@Override
	public AdminDTO saveAdminInfo(Admin admin) {
		// TODO Auto-generated method stub
		Admin adm= adminRepository.save(admin);
		return adminConverter.convertToAdminDTO(adm);
	}

	@Override
	public List<AdminDTO> getAllAdminInfo() {
		// TODO Auto-generated method stub
		List<Admin> admins= adminRepository.findAll();
		List<AdminDTO> dtoa=new ArrayList<>();
	for(Admin a:admins) {
		dtoa.add(adminConverter.convertToAdminDTO(a));
	}
	return dtoa;
	}

	@Override
	public AdminDTO  getByAdminId( int aid) {
		// TODO Auto-generated method stub 
		Admin a= adminRepository.findById(aid).orElseThrow(()->
		new ResourceNotFoundException("Admin","Id",aid));
		return adminConverter.convertToAdminDTO(a);
	}

	@Override
	public String deleteAdminInfoById(int aid) {
		// TODO Auto-generated method stub
		adminRepository.findById(aid).orElseThrow(()->
		new ResourceNotFoundException("Admin", "Id", aid));
		adminRepository.deleteById(aid);
		return "Admin deleted";
	}

	@Override
	public AdminDTO  updateAdminInfo(int aid, Admin admin) {
		// TODO Auto-generated method stub
		Admin aa=adminRepository.findById(aid).orElseThrow(()->
		new ResourceNotFoundException("Admin","Id",aid));
		aa.setAemail(admin.getAemail());
		aa.setApass(admin.getApass());
		Admin ad=adminRepository.save(aa);
		return adminConverter.convertToAdminDTO(ad);
	}

}
