package com.example.model;

import java.util.Set;

import com.example.entities.Admin;
import com.example.entities.Ambulance;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PatientDTO {
	@NotNull
	private int pid;
	@NotBlank
	@Size(min = 2,max = 20,message = "The patient name should contain the Characters from 2 to 20.. ")
	private String pname;
	@NotBlank
	@Size(min = 2,max = 20,message = "The Email Should Contrain the characters from 2 to 20..")
	private String pemail;
	@NotNull
	 @Min(value = 1000000000L, message = "Mobile number must be at least 10 digits")
    @Max(value = 999999999999999L, message = "Mobile number must be at most 15 digits")
	private long pmobno;
	@NotBlank
	@Size(min = 2,max = 10,message = "The Gender should contain from 2 to 10 characters..")
	private String pgender;
	@NotBlank
	@Size(min = 2,max = 30,message = "The Address should contain from 2 to 30 characters...")
	private String paddress;
	private Admin admin;
	private Set<Ambulance>ambulance;
}
