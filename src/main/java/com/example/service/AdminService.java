package com.example.service;

import java.util.List;

import com.example.entities.Admin;
import com.example.entities.Ambulance;
import com.example.model.AdminDTO;

public interface AdminService {
public AdminDTO saveAdminInfo(Admin admin);
public List<AdminDTO> getAllAdminInfo();
AdminDTO getByAdminId(int aid);
String deleteAdminInfoById(int aid);
AdminDTO updateAdminInfo(int aid,Admin admin);
}
