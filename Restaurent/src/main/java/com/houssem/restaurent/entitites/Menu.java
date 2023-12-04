package com.houssem.restaurent.entitites;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idMenu;
	private String nomMenu;
	
	@JsonIgnore
	@OneToMany(mappedBy = "menu")
	private List<Plat> plats;


	
	

}
