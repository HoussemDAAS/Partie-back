package com.houssem.restaurent.entitites;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data

@Entity
public class Plat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPlat;
	private String nomPlat;
	private double prix;
	@ManyToOne
	private Menu menu;
	
	@OneToMany (mappedBy = "plat")
	 private List<Image> images;
	private String imagePath;
	
}


