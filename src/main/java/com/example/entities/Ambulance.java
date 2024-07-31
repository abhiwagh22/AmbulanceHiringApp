package com.example.entities;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@SuppressWarnings("deprecation")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SQLDelete(sql="UPDATE user SET status=true  where user_id=?")
@Where(clause = "status=false")
@Table(name = "ambulance")
public class Ambulance {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "ambuEmsNo",length = 20)
private int emsno;
@Column(name = "owName",length = 20)
private String ownername;
@Column(name = "ambuType",length = 20)
private String atype;
@Column(name = "ambuRcNo",length = 20)
private int rcno;
private boolean status=Boolean.FALSE;
@ManyToMany(mappedBy ="ambulance",cascade = CascadeType.ALL )
private Set<Driver>drivers=new HashSet<Driver>();
@ManyToMany(mappedBy = "ambulance",cascade = CascadeType.ALL)
private Set<Patient> patients=new HashSet<Patient>();

}
