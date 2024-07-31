package com.example.service;

import java.util.List;

import com.example.entities.Ambulance;
import com.example.entities.Driver;
import com.example.model.DriverDTO;

public interface DriverService {
public DriverDTO saveDriverInfo(Driver driver);
public List<DriverDTO> getAllDriverInfo();
DriverDTO getByDriverId(int did);
String deleteDriverInfoById(int did);
DriverDTO updateDriverInfo(int did,Driver driver);
}
