package com.example.model;

import java.util.List;

import com.example.entities.Driver;
import com.example.entities.Patient;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AdminDTO {
	@NotNull
	private int aid;
	@NotBlank
	@Size(min = 2,max = 20,message = "The Email Should Contain from 2 to 20 Characters...")
	private String aemail;
	@NotBlank
	@Size(min = 2,max = 20,message = "The Password Should Contain from 2 to 20 Characters...")
	private String apass;
	List<Driver>drivers;
	List<Patient>patients;
}
