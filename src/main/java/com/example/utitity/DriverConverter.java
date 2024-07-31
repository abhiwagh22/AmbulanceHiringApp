package com.example.utitity;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.example.entities.Driver;
import com.example.model.DriverDTO;
@Component
public class DriverConverter {
	public Driver convertToDriverEntity(DriverDTO driverDTO) {
		
		Driver driver=new Driver();
		if(driverDTO!=null) {
			BeanUtils.copyProperties(driverDTO, driver);
		}
			return driver;
		}
		public DriverDTO convertToDriverDTO(Driver driver) {
			DriverDTO driverDTO=new DriverDTO();
			if(driver!=null) {
				BeanUtils.copyProperties(driver, driverDTO);
			}
			return driverDTO;
		}
}
