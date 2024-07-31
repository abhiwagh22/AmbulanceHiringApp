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
public class DriverDTO {
	@NotNull
	private int did;
	@NotBlank
	@Size(min = 2,max = 20,message = "The DriverName should contain the Characters from 2 to 20..")
	private String dname;
	@NotNull
	 @Min(value = 1000000000L, message = "Mobile number must be at least 10 digits")
    @Max(value = 999999999999999L, message = "Mobile number must be at most 15 digits")
	private long mobno;
	private Admin admin;
	private Set<Ambulance>ambulance;
}
