package com.houssem.restaurent.service;

import java.util.List;

import com.houssem.restaurent.entitites.Menu;
import com.houssem.restaurent.entitites.Plat;



public interface PlatService {
	Plat savePlat(Plat m);
	Plat updatePlat(Plat m);
	void deletePlat(Plat m);
	
	Plat getPlat(Long id);
	List<Plat> getAllPlat();
	List<Plat> findByNomPlat(String nom);
	List<Plat> findByNomPlatContains(String nom);
	List<Plat> findByMenu (Menu menu);
	List<Plat> findByMenuIdMenu(Long id);
	List<Plat> findByOrderByNomPlattAsc();
	List<Plat> trierPlatsNomsPrix();
	void deletePlatById(long id);
	
}
