package com.example.entities;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "admin")
public class Admin {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "adId",length = 20)
private int aid;
@Column(name = "adEmail",length = 20)
private String aemail;
@Column(name = "adPass",length = 20)
private String apass;
private boolean status=Boolean.FALSE;
@OneToMany(mappedBy = "admin",cascade = CascadeType.PERSIST)
@JsonIgnoreProperties("admin")
List<Driver> drivers=new ArrayList<>();
@OneToMany(mappedBy = "admin",cascade = CascadeType.PERSIST)
@JsonIgnoreProperties("admin")
List<Patient>patients=new ArrayList<>();
}
