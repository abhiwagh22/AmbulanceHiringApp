package com.example.model;

import java.util.Set;

import com.example.entities.Driver;
import com.example.entities.Patient;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AmbulanceDTO {
	@NotNull
	private int emsno;
	@NotBlank
	@Size(min = 2,max = 20,message = "The Ownername should contaoin from 2 to 2o characters..")
	private String ownername;
	@NotBlank
	@Size(min = 2,max = 20,message = "The AmbulanceType should contain from 2 to 20 characters..")
	private String atype;
	@NotNull
	 @Min(value = 100, message = "Registration number must be at least 5 digits")
    @Max(value = 500, message = "Registration number must be at most 10 digits")
	private int rcno;
	private Set<Patient> patients;
	private Set<Driver>drivers;
}
