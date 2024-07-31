package com.example.service;

import java.util.List;

import com.example.entities.Ambulance;
import com.example.model.AmbulanceDTO;

public interface AmbulanceService {
public AmbulanceDTO saveAmbulanceInfo(Ambulance ambulance);
public List<AmbulanceDTO> geAllAmbulanceInfo();
AmbulanceDTO getByAmbulanceId(int emsno);
String deleteAmbulanceInfoById(int emsno);
AmbulanceDTO updateAmbulanceInfo(int emsno,Ambulance ambulance);

}
