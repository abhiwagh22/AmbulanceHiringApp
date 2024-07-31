package com.example.entities;

import java.util.HashSet;

import java.util.Set;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@SuppressWarnings("deprecation")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SQLDelete(sql="UPDATE user SET status=true  where user_id=?")
@Where(clause = "status=false")
@Table(name = "patient")
public class Patient {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "patientId",length = 20)
private int pid;
@Column(length = 20)
private String pname;
@Column(length = 20)
private String pemail;
@Column(length = 10)
private long pmobno;
@Column(length = 10)
private String pgender;
@Column(length = 30)
private String paddress;
private boolean status=Boolean.FALSE;
@ManyToOne(cascade = CascadeType.PERSIST)
@JoinColumn(name = "adId")
@JsonIgnoreProperties("patients")
private Admin admin;
@ManyToMany(cascade = CascadeType.ALL)
@JoinTable(name = "patient_ambulance",joinColumns = {
@JoinColumn(name="patientId")
},
inverseJoinColumns = {
		@JoinColumn(name="ambuEmsNo")
}
)
@JsonIgnoreProperties("patients")
private Set<Ambulance>ambulance=new HashSet<Ambulance>();
}


