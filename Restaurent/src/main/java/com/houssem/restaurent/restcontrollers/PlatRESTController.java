package com.houssem.restaurent.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.houssem.restaurent.entitites.Plat;
import com.houssem.restaurent.service.PlatService;

@RestController
@RequestMapping("/api")
@CrossOrigin

public class PlatRESTController {

	@Autowired(required = true)
	PlatService platService;

	@RequestMapping(path="all",method = RequestMethod.GET)
	public List<Plat> getAllPlat() {
		return platService.getAllPlat();
	}

	@RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
	public Plat getPlatById(@PathVariable("id") Long id) {
		return platService.getPlat(id);
	}

	@RequestMapping(path="/addplat",method = RequestMethod.POST)
	public Plat createPlat(@RequestBody Plat Plat) {
		return platService.savePlat(Plat);
	}
	

	@RequestMapping(path="/updateplat",method = RequestMethod.PUT)
	public Plat updatePlat(@RequestBody Plat p) {
		return platService.updatePlat(p);
	}

	@RequestMapping(value = "/delplat/{id}", method = RequestMethod.DELETE)
	public void deletePlat(@PathVariable("id") Long id) {
		platService.deletePlatById(id);
	}

	@RequestMapping(value = "/menus/{idMenu}", method = RequestMethod.GET)
	public List<Plat> findByMenuIdMenu(@PathVariable("idMenu") Long idMenu) {
		return platService.findByMenuIdMenu(idMenu);
	}

	@RequestMapping(value = "/platByName/{nom}", method = RequestMethod.GET)
	public List<Plat> findByNomPlatContains(@PathVariable("nom") String nom) {
		return platService.findByNomPlatContains(nom);
	}
}
