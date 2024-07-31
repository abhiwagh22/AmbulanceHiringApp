package com.example.entities;

import java.util.HashSet;
import java.util.List;
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
@Table(name = "driver")
public class Driver {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "driverId",length = 20)
private int did;
@Column(name = "Drivername",length = 20)
private String dname;
@Column(name = "driMobNo",length = 20)
private long mobno;
@ManyToOne(cascade = CascadeType.PERSIST)
@JoinColumn(name = "adId")
@JsonIgnoreProperties("drivers")
private Admin admin;
private boolean status=Boolean.FALSE;
@ManyToMany(cascade = CascadeType.ALL)
@JoinTable(name = "driver_ambulance",joinColumns = {
@JoinColumn(name="driverId")
},
inverseJoinColumns = {
		@JoinColumn(name="ambuEmsNo ")
}
)
@JsonIgnoreProperties("drivers")
private Set<Ambulance>ambulance=new HashSet<Ambulance>();
}
