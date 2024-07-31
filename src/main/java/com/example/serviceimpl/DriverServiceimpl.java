package com.example.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Driver;
import com.example.model.DriverDTO;
import com.example.repository.DriverRepository;
import com.example.service.DriverService;
import com.example.utitity.AdminConverter;
import com.example.utitity.DriverConverter;
@Service
public class DriverServiceimpl implements DriverService {
@Autowired
private DriverRepository driverRepository;
@Autowired
DriverConverter driverConverter;
	@Override
	public DriverDTO saveDriverInfo(Driver driver) {
		// TODO Auto-generated method stub
		Driver dd= driverRepository.save(driver);
		return driverConverter.convertToDriverDTO(dd);
	}

	@Override
	public List<DriverDTO> getAllDriverInfo() {
		// TODO Auto-generated method stub
		List<Driver>dri=driverRepository.findAll();
		List<DriverDTO> dtod=new ArrayList<>();
		for (Driver dd:dri) {
			dtod.add(driverConverter.convertToDriverDTO(dd));
		}
		 return dtod;
	}

	@Override
	public DriverDTO getByDriverId(int did) {
		// TODO Auto-generated method stub
		Driver d=driverRepository.findById(did).get();
		return driverConverter.convertToDriverDTO(d);
	}

	@Override
	public String deleteDriverInfoById(int did) { 
		// TODO Auto-generated method stub
		driverRepository.deleteById(did);
		return "Driver info deleted";
	}

	@Override
	public DriverDTO updateDriverInfo(int did, Driver driver) {
		// TODO Auto-generated method stub
		Driver dd=driverRepository.findById(did).get();
		dd.setDname(driver.getDname());
		dd.setMobno(driver.getMobno());
		Driver d= driverRepository.save(dd);
		return driverConverter.convertToDriverDTO(d);
	}
	

}
